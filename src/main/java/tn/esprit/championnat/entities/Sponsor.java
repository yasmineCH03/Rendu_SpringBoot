package tn.esprit.championnat.entities;
import jakarta.persistence.*;
import lombok.*;



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
}
