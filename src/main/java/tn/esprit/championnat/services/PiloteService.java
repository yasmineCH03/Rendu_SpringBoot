package tn.esprit.championnat.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.championnat.entities.Categorie;
import tn.esprit.championnat.entities.Pilote;
import tn.esprit.championnat.entities.Position;
import tn.esprit.championnat.repositories.PiloteRepository;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class PiloteService implements IPiloteService{


    PiloteRepository piloteRepository;
    @Override
    public String addPilote(Pilote p) {
        piloteRepository.save(p);
        return "Pilote ajouté avec succés";
    }

    @Override
    @Scheduled(cron = "0 15 11 31 12 ?")
    public void mettreAJourPointsEtClassementPilotes() {
        int anneeCourante = LocalDate.now().getYear();
        Categorie categoriecible = Categorie.FORMULA1;
        PiloteRepository piloteRepository = null;
        PiloteRepository positionRepository = null;

        // 1. Récupérer les pilotes FORMULA1 via keyword
        List<Pilote> pilotesFormula1 = piloteRepository
                .findByPositionCourseChampionnatsCategorie(categoriecible);

        // 2. Mettre à jour les points de chaque pilote via keyword
        for (Pilote pilote : pilotesFormula1) {
            List<Position> positions = positionRepository
                    .findByPiloteAndCourseChampionnatsAnneeAndCourseChampionnatsCategorie(
                            pilote, anneeCourante, categoriecible);

            int totalPoints = positions.stream()
                    .mapToInt(Position::getNbPoints)
                    .sum();

            pilote.setNbPointsTotal(totalPoints);
            piloteRepository.save(pilote);
        }

        List<Pilote> pilotesTries;
        pilotesTries = piloteRepository
                .findByPositionCourseChampionnatsCategorie(categoriecible)
                .stream()
                .sorted(Comparator.comparingInt(Pilote::getNbPointsTotal).reversed())
                .collect(Collectors.toList());

        for (int i = 0; i < pilotesTries.size(); i++) {
            Pilote p = pilotesTries.get(i);
            p.setClassementGeneral(p.getNbPointsTotal() > 0 ? i + 1 : 0);
            piloteRepository.save(p);
        }

        log.info("Classement mis à jour pour {} - année {}", categoriecible, anneeCourante);
    }



}
