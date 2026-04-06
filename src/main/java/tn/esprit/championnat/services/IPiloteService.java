package tn.esprit.championnat.services;

import tn.esprit.championnat.entities.Categorie;
import tn.esprit.championnat.entities.Pilote;

import java.util.List;

public interface IPiloteService {

    public String addPilote(Pilote p);
    public void mettreAJourPointsEtClassementPilotes();
}
