package tn.esprit.championnat.entities;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name="Contrats")
@Getter
@Setter
public class Contrat {

    @Id
    private long idContrat;
    private float montant;
    private String annee;
    private Boolean archived;


    @ManyToOne
    private Equipe equipe;

    @ManyToOne
    private Sponsor sponsor;

}
