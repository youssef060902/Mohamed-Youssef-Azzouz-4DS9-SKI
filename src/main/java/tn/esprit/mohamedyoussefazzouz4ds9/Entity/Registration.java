package tn.esprit.mohamedyoussefazzouz4ds9.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "registrations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numRegistration;

    private int numWeek;

    @ManyToOne
    private Course course;
}

