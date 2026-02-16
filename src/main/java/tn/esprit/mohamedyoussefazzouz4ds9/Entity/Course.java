package tn.esprit.mohamedyoussefazzouz4ds9.Entity;

import jakarta.persistence.*;
import lombok.*;
import tn.esprit.mohamedyoussefazzouz4ds9.enums.Support;
import tn.esprit.mohamedyoussefazzouz4ds9.enums.TypeCourse;

import java.util.Set;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numCourse;

    @Column(nullable = false)
    private int level;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TypeCourse typeCourse;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private Support support;

    @Column(nullable = false)
    private Float price;

    private int timeSlot;

    @OneToMany(mappedBy = "course",
            cascade = CascadeType.ALL)
    private Set<Registration> registrations;


}

