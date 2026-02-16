package tn.esprit.mohamedyoussefazzouz4ds9.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "pistes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Piste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numPiste;



    @ManyToMany(mappedBy = "pistes",cascade = CascadeType.ALL)
    private Set<Skier> skiers;
}
