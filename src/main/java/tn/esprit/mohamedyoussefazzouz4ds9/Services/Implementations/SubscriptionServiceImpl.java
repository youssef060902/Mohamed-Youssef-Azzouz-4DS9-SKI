package tn.esprit.mohamedyoussefazzouz4ds9.Services.Implementations;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Skier;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Subscription;
import tn.esprit.mohamedyoussefazzouz4ds9.Repositories.SubscriptionRepo;
import tn.esprit.mohamedyoussefazzouz4ds9.Services.Interfaces.ISubscriptionService;
import tn.esprit.mohamedyoussefazzouz4ds9.enums.TypeSubscription;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Slf4j
@Service
@AllArgsConstructor
public class SubscriptionServiceImpl implements ISubscriptionService {

    private SubscriptionRepo subscriptionRepo;

    @Override
    public Subscription addSubscription(Subscription subscription) {
        return subscriptionRepo.save(subscription);
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        return subscriptionRepo.save(subscription);
    }

    @Override
    public void deleteSubscription(Long id) {
        subscriptionRepo.deleteById(id);
    }

    @Override
    public Subscription getSubscription(Long id) {

        Optional<Subscription> optionalSubscription = subscriptionRepo.findById(id);

        if (optionalSubscription.isPresent()) {
            return optionalSubscription.get();
        } else {
            throw new RuntimeException("Subscription not found");
        }
    }

    @Override
    public List<Subscription> getSubscriptions() {
        return subscriptionRepo.findAll();
    }

    @Override
    public Set<Subscription> getSubscriptionByType(TypeSubscription type) {

        return subscriptionRepo.findByTypeSubOrderByStartDateAsc(type);
    }

    @Override
    public List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {

        return subscriptionRepo.findByStartDateBetween(startDate, endDate);
    }

    @Scheduled(cron = "0 0 9 * * *")
    @Override
    public void retrieveSubscriptions() {
        LocalDate today = LocalDate.now();
        LocalDate limitDate = today.plusDays(7);

        List<Subscription> expiringSoon = subscriptionRepo.retrieveSubscriptions(today, limitDate);

        for (Subscription sub : expiringSoon) {
            Skier skier = sub.getSkier();
            if (skier != null) {
                log.info("Subscription n°{} expires soon — Skier: {} {} (id: {})",
                        sub.getNumSub(),
                        skier.getFirstName(),
                        skier.getLastName(),
                        skier.getNumSkier()
                );
            }
        }

    }
    @Scheduled(cron = "0 0 1 1 * *")
    @Override
    public void showMonthlyRecurringRevenue() {

        Float monthlyTotal    = subscriptionRepo.sumPriceByType(TypeSubscription.MONTHLY);
        Float semestrialTotal = subscriptionRepo.sumPriceByType(TypeSubscription.SEMESTRIAL);
        Float annualTotal     = subscriptionRepo.sumPriceByType(TypeSubscription.ANNUAL);

        float mrr = 0f;
        if (monthlyTotal    != null) mrr += monthlyTotal;
        if (semestrialTotal != null) mrr += semestrialTotal / 6f;
        if (annualTotal     != null) mrr += annualTotal     / 12f;

        log.info("=== Monthly Recurring Revenue (MRR) ===");
        log.info("MONTHLY     contribution : {}",  monthlyTotal    != null ? monthlyTotal    : 0f);
        log.info("SEMESTRIAL  contribution : {}",  semestrialTotal != null ? semestrialTotal / 6f  : 0f);
        log.info("ANNUAL      contribution : {}",  annualTotal     != null ? annualTotal     / 12f : 0f);
        log.info("Total MRR               : {}", mrr);
    }

}

