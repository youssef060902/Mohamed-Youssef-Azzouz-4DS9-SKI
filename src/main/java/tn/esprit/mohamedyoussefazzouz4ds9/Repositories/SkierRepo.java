package tn.esprit.mohamedyoussefazzouz4ds9.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Skier;
import tn.esprit.mohamedyoussefazzouz4ds9.enums.TypeSubscription;

import java.util.List;

@Repository
public interface SkierRepo extends JpaRepository<Skier, Long> {

    List<Skier> findBySubscriptionTypeAbonnement(TypeSubscription typesubscription);

}