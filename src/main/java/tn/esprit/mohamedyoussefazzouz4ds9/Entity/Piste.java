package tn.esprit.mohamedyoussefazzouz4ds9.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.mohamedyoussefazzouz4ds9.enums.Color;

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
    private String namePiste;
    private int length;
    private int slope;
    @Enumerated(EnumType.STRING)
    private Color color;



    @ManyToMany(mappedBy = "pistes",cascade = CascadeType.ALL)
    private Set<Skier> skiers;
}
