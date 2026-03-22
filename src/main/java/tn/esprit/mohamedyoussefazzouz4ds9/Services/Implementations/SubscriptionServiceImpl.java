package tn.esprit.mohamedyoussefazzouz4ds9.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Subscription;
import tn.esprit.mohamedyoussefazzouz4ds9.Repositories.SubscriptionRepo;
import tn.esprit.mohamedyoussefazzouz4ds9.Services.Interfaces.ISubscriptionService;
import tn.esprit.mohamedyoussefazzouz4ds9.enums.TypeSubscription;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
}