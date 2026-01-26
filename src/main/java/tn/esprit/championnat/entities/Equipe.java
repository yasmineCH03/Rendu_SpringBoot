package tn.esprit.championnat.entities;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name="Equipes")
@Getter
@Setter
public class Equipe {

    @Id
    private long idEquipe;
    private String libelle;
    private int nbPointsTotal;
    private int classementGeneral;
}
