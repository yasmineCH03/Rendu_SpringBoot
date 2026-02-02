package tn.esprit.championnat.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name="Equipes")
@Getter
@Setter
public class Equipe {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idEquipe;
    private String libelle;
    private int nbPointsTotal;
    private int classementGeneral;

    @OneToMany(mappedBy = "equipe")
    private List<Pilote> pilotes;

    @OneToMany (mappedBy = "equipe")
    private List<Contrat> contrats;
}
