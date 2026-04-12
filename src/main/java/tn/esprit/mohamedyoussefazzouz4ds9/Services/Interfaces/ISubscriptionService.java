package tn.esprit.mohamedyoussefazzouz4ds9.Services.Interfaces;

import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Subscription;
import tn.esprit.mohamedyoussefazzouz4ds9.enums.TypeSubscription;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ISubscriptionService {

    Subscription addSubscription(Subscription subscription);

    Subscription updateSubscription(Subscription subscription);

    void deleteSubscription(Long id);

    Subscription getSubscription(Long id);

    List<Subscription> getSubscriptions();

    Set<Subscription> getSubscriptionByType(TypeSubscription type);

    List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate);

    public void retrieveSubscriptions();
    public void showMonthlyRecurringRevenue();



}