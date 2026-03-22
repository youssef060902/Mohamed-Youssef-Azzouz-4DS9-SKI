package tn.esprit.mohamedyoussefazzouz4ds9.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Registration;
import tn.esprit.mohamedyoussefazzouz4ds9.Services.Interfaces.IRegistrationService;

import java.util.List;

@RestController
@RequestMapping("/api/registration")
@AllArgsConstructor
public class RegistrationController {

    private IRegistrationService registrationService;

    @PostMapping("/add")
    public Registration addRegistration(@RequestBody Registration registration) {
        return registrationService.addRegistration(registration);
    }

    @GetMapping("/all")
    public List<Registration> getAllRegistrations() {
        return registrationService.getRegistrations();
    }

    @GetMapping("/{id}")
    public Registration getRegistration(@PathVariable Long id) {
        return registrationService.getRegistration(id);
    }

    @PutMapping("/update")
    public Registration updateRegistration(@RequestBody Registration registration) {
        return registrationService.updateRegistration(registration);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRegistration(@PathVariable Long id) {
        registrationService.deleteRegistration(id);
    }

    @PostMapping("/addRegistrationAndAssignToSkier/{numSkier}")
    public Registration addRegistrationAndAssignToSkier(
            @RequestBody Registration registration,
            @PathVariable Long numSkier) {

        return registrationService.addRegistrationAndAssignToSkier(registration, numSkier);
    }

    @PutMapping("/assignRegistrationToCourse/{numRegistration}/{numCourse}")
    public Registration assignRegistrationToCourse(
            @PathVariable Long numRegistration,
            @PathVariable Long numCourse) {

        return registrationService.assignRegistrationToCourse(numRegistration, numCourse);
    }

    @PostMapping("/addRegistrationAndAssignToSkierAndCourse/{numSkier}/{numCourse}")
    public Registration addRegistrationAndAssignToSkierAndCourse(
            @RequestBody Registration registration,
            @PathVariable Long numSkier,
            @PathVariable Long numCourse) {

        return registrationService
                .addRegistrationAndAssignToSkierAndCourse(registration, numSkier, numCourse);
    }


}