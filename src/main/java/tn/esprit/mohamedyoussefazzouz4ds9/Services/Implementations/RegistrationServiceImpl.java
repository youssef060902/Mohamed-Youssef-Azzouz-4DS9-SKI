package tn.esprit.mohamedyoussefazzouz4ds9.Services.Implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Registration;
import tn.esprit.mohamedyoussefazzouz4ds9.Repositories.RegistrationRepo;
import tn.esprit.mohamedyoussefazzouz4ds9.Services.Interfaces.IRegistrationService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements IRegistrationService {

    private RegistrationRepo registrationRepo;

    @Override
    public Registration addRegistration(Registration registration) {
        return registrationRepo.save(registration);
    }

    @Override
    public Registration updateRegistration(Registration registration) {
        return registrationRepo.save(registration);
    }

    @Override
    public void deleteRegistration(Long id) {
        registrationRepo.deleteById(id);
    }

    @Override
    public Registration getRegistration(Long id) {

        Optional<Registration> optionalRegistration = registrationRepo.findById(id);

        if (optionalRegistration.isPresent()) {
            return optionalRegistration.get();
        } else {
            throw new RuntimeException("Registration not found");
        }
    }

    @Override
    public List<Registration> getRegistrations() {
        return registrationRepo.findAll();
    }
}