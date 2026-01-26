package tn.esprit.championnat.entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "DetailChampionnats")
@Getter
@Setter
public class Detailchampionnat {
    @Id
    private String code;
    private String description;
}
