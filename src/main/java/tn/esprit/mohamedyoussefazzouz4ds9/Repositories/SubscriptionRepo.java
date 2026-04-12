package tn.esprit.mohamedyoussefazzouz4ds9.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Subscription;
import tn.esprit.mohamedyoussefazzouz4ds9.enums.TypeSubscription;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription, Long> {
    Set<Subscription> findByTypeSubOrderByStartDateAsc(TypeSubscription type);
    List<Subscription> findByStartDateBetween(LocalDate startDate, LocalDate endDate);
    @Query("SELECT s FROM Subscription s WHERE s.endDate BETWEEN :today AND :limitDate")
    List<Subscription> retrieveSubscriptions(@Param("today") LocalDate today,
                                             @Param("limitDate") LocalDate limitDate);
    @Query("SELECT SUM(s.price) FROM Subscription s WHERE s.typeSub = :type")
    Float sumPriceByType(@Param("type") TypeSubscription type);
}