package tn.esprit.championnat.entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Positions")
@Getter
@Setter

public class Position {

    @Id
    private long idPosition;
    private int classement;
    private int nbPoints;

    @ManyToOne (cascade = CascadeType.ALL)
    private Course course;

    @ManyToOne
    private Pilote pilote;
}
