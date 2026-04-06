package tn.esprit.championnat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.championnat.entities.Categorie;
import tn.esprit.championnat.entities.Pilote;
import tn.esprit.championnat.entities.Position;

import java.util.List;

public interface PiloteRepository extends JpaRepository <Pilote,Long> {

    List<Pilote> findByPositionCourseChampionnatsCategorie(Categorie categorie);
    List<Position> findByPiloteAndCourseChampionnatsAnneeAndCourseChampionnatsCategorie(
            Pilote pilote, int annee, Categorie categorie);

}
