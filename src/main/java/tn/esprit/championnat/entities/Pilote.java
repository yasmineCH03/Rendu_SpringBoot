package tn.esprit.championnat.entities;
import jakarta.persistence.*;
import lombok.*;



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
}
