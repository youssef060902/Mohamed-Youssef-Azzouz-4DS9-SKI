package tn.esprit.mohamedyoussefazzouz4ds9.Services.Implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Course;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Piste;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Skier;
import tn.esprit.mohamedyoussefazzouz4ds9.Repositories.CourseRepo;
import tn.esprit.mohamedyoussefazzouz4ds9.Repositories.PisteRepo;
import tn.esprit.mohamedyoussefazzouz4ds9.Repositories.RegistrationRepo;
import tn.esprit.mohamedyoussefazzouz4ds9.Repositories.SkierRepo;
import tn.esprit.mohamedyoussefazzouz4ds9.Services.Interfaces.ISkierService;
import tn.esprit.mohamedyoussefazzouz4ds9.enums.TypeSubscription;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class SkierServiceImpl implements ISkierService {

    private SkierRepo skierRepo;
    private CourseRepo courseRepo;
    private PisteRepo pisteRepo;
    private RegistrationRepo registrationRepo;

    @Override
    public Skier addSkier(Skier skier) {
        return skierRepo.save(skier);
    }

    @Override
    public Skier updateSkier(Skier skier) {
        return skierRepo.save(skier);
    }

    @Override
    public void deleteSkier(Long id) {
        skierRepo.deleteById(id);
    }

    @Override
    public Skier getSkier(Long id) {

        Optional<Skier> optionalSkier = skierRepo.findById(id);

        if (optionalSkier.isPresent()) {
            return optionalSkier.get();
        } else {
            throw new RuntimeException("Skier not found");
        }
    }

    @Override
    public List<Skier> getSkiers() {
        return skierRepo.findAll();
    }

    @Override
    public Skier assignSkierToPiste(Long numSkier, Long numPiste) {

        Piste piste = pisteRepo.findById(numPiste).get();
        Skier skier = skierRepo.findById(numSkier).get();

        Set<Piste> pistesMisesAJour = new HashSet<>();

        if (skier.getPistes() != null) {
            pistesMisesAJour = skier.getPistes();
        }

        pistesMisesAJour.add(piste);

        skier.setPistes(pistesMisesAJour);

        skierRepo.save(skier);

        return skier;
}

    @Override
    public Skier addSkierAndAssignToCourse(Skier skier, Long numCourse) {

        Course course = courseRepo.findById(numCourse).get();

        Skier savedSkier = skierRepo.save(skier);

        savedSkier.getRegistrations().forEach(registration -> {

            registration.setSkier(savedSkier);

            registration.setCourse(course);

            registrationRepo.save(registration);
        });

        return savedSkier;
    }

    @Override
    public List<Skier> retrieveSkiersBySubscriptionType(TypeSubscription typesubscription) {

        return skierRepo.findBySubscriptionTypeAbonnement(typesubscription);
    }
}