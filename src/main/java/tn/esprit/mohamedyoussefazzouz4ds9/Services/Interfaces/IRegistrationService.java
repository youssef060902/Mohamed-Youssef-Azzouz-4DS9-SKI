package tn.esprit.mohamedyoussefazzouz4ds9.Services.Interfaces;

import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Instructor;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Registration;

import java.util.List;

public interface IRegistrationService {

    Registration addRegistration(Registration registration);

    Registration updateRegistration(Registration registration);

    void deleteRegistration(Long id);

    Registration getRegistration(Long id);

    List<Registration> getRegistrations();

    Registration addRegistrationAndAssignToSkier(Registration registration, Long numSkieur);

    Registration assignRegistrationToCourse(Long numRegistration, Long numCourse);

    Registration addRegistrationAndAssignToSkierAndCourse(
            Registration registration, Long numSkier, Long numCourse);

}