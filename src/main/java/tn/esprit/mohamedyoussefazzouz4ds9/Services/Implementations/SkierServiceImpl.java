package tn.esprit.mohamedyoussefazzouz4ds9.Services.Implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Skier;
import tn.esprit.mohamedyoussefazzouz4ds9.Repositories.SkierRepo;
import tn.esprit.mohamedyoussefazzouz4ds9.Services.Interfaces.ISkierService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SkierServiceImpl implements ISkierService {

    private SkierRepo skierRepo;

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
}