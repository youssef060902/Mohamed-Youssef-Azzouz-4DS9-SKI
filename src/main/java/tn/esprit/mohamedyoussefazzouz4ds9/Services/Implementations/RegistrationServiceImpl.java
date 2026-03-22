package tn.esprit.mohamedyoussefazzouz4ds9.Services.Implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Course;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Registration;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Skier;
import tn.esprit.mohamedyoussefazzouz4ds9.Repositories.CourseRepo;
import tn.esprit.mohamedyoussefazzouz4ds9.Repositories.RegistrationRepo;
import tn.esprit.mohamedyoussefazzouz4ds9.Repositories.SkierRepo;
import tn.esprit.mohamedyoussefazzouz4ds9.Services.Interfaces.IRegistrationService;
import tn.esprit.mohamedyoussefazzouz4ds9.enums.TypeCourse;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements IRegistrationService {

    private RegistrationRepo registrationRepo;
    private SkierRepo skierRepo;
    private CourseRepo courseRepo;

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
        return registrationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Registration not found"));
    }

    @Override
    public List<Registration> getRegistrations() {
        return registrationRepo.findAll();
    }

    @Override
    public Registration addRegistrationAndAssignToSkier(Registration registration, Long numSkieur) {

        Skier skier = skierRepo.findById(numSkieur).orElse(null);

        Registration reg = registrationRepo.save(registration);

        skier.getRegistrations().add(reg);

        reg.setSkier(skier);

        registrationRepo.save(reg);

        return reg;
    }

    @Override
    public Registration assignRegistrationToCourse(Long numRegistration, Long numCourse) {

        Registration registration = registrationRepo.findById(numRegistration).get();

        Course course = courseRepo.findById(numCourse).get();

        registration.setCourse(course);

        return registrationRepo.save(registration);
    }

    @Override
    public Registration addRegistrationAndAssignToSkierAndCourse(
            Registration registration, Long numSkier, Long numCourse) {

        Skier skier = skierRepo.findById(numSkier).get();
        Course course = courseRepo.findById(numCourse).get();

        int nbRegistrations = course.getRegistrations().size();

        if ((course.getTypeCourse() == TypeCourse.COLLECTIVE_CHILDREN
                || course.getTypeCourse() == TypeCourse.COLLECTIVE_ADULT)
                && nbRegistrations >= 6) {

            throw new RuntimeException("Course already full");
        }

        int age = Period.between(skier.getBirthDate(), LocalDate.now()).getYears();

        if (course.getTypeCourse() == TypeCourse.COLLECTIVE_CHILDREN && age > 12) {
            throw new RuntimeException("This course is for children only");
        }

        if (course.getTypeCourse() == TypeCourse.COLLECTIVE_ADULT && age < 12) {
            throw new RuntimeException("This course is for adults only");
        }

        registration.setSkier(skier);
        registration.setCourse(course);

        return registrationRepo.save(registration);
    }
}
