package tn.esprit.mohamedyoussefazzouz4ds9.Services.Implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Piste;
import tn.esprit.mohamedyoussefazzouz4ds9.Repositories.PisteRepo;
import tn.esprit.mohamedyoussefazzouz4ds9.Services.Interfaces.IPisteService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PisteServiceImpl implements IPisteService {

    private PisteRepo pisteRepo;

    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepo.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepo.save(piste);
    }

    @Override
    public void deletePiste(Long id) {
        pisteRepo.deleteById(id);
    }

    @Override
    public Piste getPiste(Long id) {

        Optional<Piste> optionalPiste = pisteRepo.findById(id);

        if (optionalPiste.isPresent()) {
            return optionalPiste.get();
        } else {
            throw new RuntimeException("Piste not found");
        }
    }

    @Override
    public List<Piste> getPistes() {
        return pisteRepo.findAll();
    }
}