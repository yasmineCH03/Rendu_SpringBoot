package tn.esprit.championnat.entities;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name="Courses")
@Getter
@Setter
public class Course {

    @Id
    public Long idCourse;
    public String emplacement;
    public LocalDate dateCourse;


    @ManyToMany (mappedBy = "courses")
    private Set<Championnat> championnatSet;

    @OneToMany (mappedBy = "course")
    private Set<Position> positions;

}
