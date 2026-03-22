package tn.esprit.mohamedyoussefazzouz4ds9.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "skiers")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Skier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkier;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String city;


    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Piste> pistes;

    @OneToOne
    private Subscription subscription;

    @OneToMany
    @JsonIgnore
    private Set<Registration> registrations ;


}

