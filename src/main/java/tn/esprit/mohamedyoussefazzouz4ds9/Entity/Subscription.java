package tn.esprit.mohamedyoussefazzouz4ds9.Entity;


import jakarta.persistence.*;
import lombok.*;
import tn.esprit.mohamedyoussefazzouz4ds9.enums.TypeSubscription;

import java.time.LocalDate;

@Entity
@Table(name = "subscriptions")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSub;


    @OneToOne(mappedBy = "subscription")
    private Skier skier;
}

