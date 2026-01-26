package tn.esprit.championnat.entities;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name="Courses")
@Getter
@Setter
public class Course {

    @Id
    public Long idCourse;
    public String emplacement;
    public LocalDate dateCourse;

}
