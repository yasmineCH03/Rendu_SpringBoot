package tn.esprit.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.championnat.entities.Equipe;
import tn.esprit.championnat.repositories.EquipeRepository;

@Service
@AllArgsConstructor
public class EquipeService implements IEquipeService {

    public EquipeRepository equipeRepository;


    @Override
    public Equipe ajouterEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }
}
