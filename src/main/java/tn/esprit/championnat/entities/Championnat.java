package tn.esprit.championnat.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "championnats")
@Getter
@Setter
public class Championnat {
    @Id
    private long idChampionnat;
    private String libelleC;
    private int annee;

    @Enumerated(EnumType.STRING)
    private Categorie categorie;

    @OneToOne (fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Detailchampionnat detailchampionnat;

    @ManyToMany (cascade = CascadeType.ALL)
    private Set<Course> courses ;
}
