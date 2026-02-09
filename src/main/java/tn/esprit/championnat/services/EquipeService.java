package tn.esprit.championnat.services;

import tn.esprit.championnat.entities.Equipe;
import tn.esprit.championnat.repositories.EquipeRepository;

public class EquipeService implements IEquipeService {

    public EquipeRepository equipeRepository;


    @Override
    public Equipe ajouterEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }
}
