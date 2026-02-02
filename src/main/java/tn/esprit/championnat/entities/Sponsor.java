package tn.esprit.championnat.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name="Sponsors")
@Getter
@Setter
public class Sponsor {

    @Id
    private long idSponsor;
    private String nom;
    private String pays;
    private float budgetAnnuel;
    private boolean bloquerContrat;

    @OneToMany (mappedBy = "sponsor")
    private List<Contrat> contrats;
}
