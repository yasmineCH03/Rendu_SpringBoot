package tn.esprit.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.championnat.entities.Contrat;
import tn.esprit.championnat.repositories.ContratRepository;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ContratService implements IContratService {

    private  ContratRepository contratRepository;


    @Override
    @Scheduled(cron = "*/30 * * * * *")
    public void archiverContratsExpireesEtAffichageContratsActifsParEquipe() {int anneeCourante = LocalDate.now().getYear();

        List<Contrat> contratsExpires = contratRepository.findAll()
                .stream()
                .filter(c -> Integer.parseInt(c.getAnnee()) < anneeCourante)
                .collect(Collectors.toList());

        contratsExpires.forEach(c -> {
            c.setArchived(true);
            contratRepository.save(c);
        });
        Map<String, List<Contrat>> contratsParEquipe = contratRepository.findAll()
                .stream()
                .filter(c -> c.getArchived() == null || !c.getArchived())
                .collect(Collectors.groupingBy(c -> c.getEquipe().getLibelle()));

        contratsParEquipe.forEach((nomEquipe, contrats) ->
                contrats.forEach(c ->
                        log.info("L'équipe {} a un contrat d'un montant de {} avec le sponsor {}",
                                nomEquipe,
                                c.getMontant(),
                                c.getSponsor().getNom())
                )
        );
    }
    /** List<Contrat> contratArchived = ContratRepository.findbyArchived(false)
     * equipeRepository.findAll().forEach(equipe->    */

}
