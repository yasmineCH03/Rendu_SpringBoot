package tn.esprit.championnat.entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "championnats")
@Getter
@Setter
public class Championnat {
    @Id
    private long idChampionnat;
    private String libelleC;
    private int annee;
    private Categorie categorie;

}
