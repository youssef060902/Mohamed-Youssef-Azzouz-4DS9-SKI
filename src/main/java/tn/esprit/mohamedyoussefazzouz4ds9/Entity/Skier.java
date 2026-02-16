package tn.esprit.mohamedyoussefazzouz4ds9.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "skiers")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Skier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkier;


    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Piste> pistes;

    @OneToOne
    private Subscription subscription;


}

