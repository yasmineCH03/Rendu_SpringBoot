package tn.esprit.championnat.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Table(name="Pilotes")
@Getter
@Setter
public class Pilote {
    @Id
    private  long idPilote;
    private  String libelleP;
    private  int  nbPointsTotal;
    private  int classementGeneral;

    @OneToMany (mappedBy = "pilote")
    private Set<Position> position ;

    @ManyToOne
    private Equipe equipe;
}
