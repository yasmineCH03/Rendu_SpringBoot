package tn.esprit.championnat.entities;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name="Sponsors")
@Getter
@Setter
public class Sponsor {

    @Id
    private Long idSponsor;
    private String nom;
    private String pays;
    private Float budgetAnnuel;
    private Boolean bloquerContrat;
    private boolean archived;
    private LocalDate dateCreation;
    private LocalDate dateDerniereModification;

    @OneToMany (mappedBy = "sponsor")
    private List<Contrat> contrats;
}
