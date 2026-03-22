package tn.esprit.mohamedyoussefazzouz4ds9.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import tn.esprit.mohamedyoussefazzouz4ds9.enums.Support;
import tn.esprit.mohamedyoussefazzouz4ds9.enums.TypeCourse;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numCourse;

    private int level;

    @Enumerated(EnumType.STRING)
    private TypeCourse typeCourse;

    @Enumerated(EnumType.STRING)
    private Support support;

    private Float price;

    private int timeSlot;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private Set<Registration> registrations;


    @Override
    public String toString() {
        return "Course " + numCourse + " level=" + level;
    }


}

