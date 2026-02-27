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

    // CREATE
    @PostMapping("/add")
    public Registration addRegistration(@RequestBody Registration registration) {
        return registrationService.addRegistration(registration);
    }

    // READ ALL
    @GetMapping("/all")
    public List<Registration> getAllRegistrations() {
        return registrationService.getRegistrations();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Registration getRegistration(@PathVariable Long id) {
        return registrationService.getRegistration(id);
    }

    // UPDATE
    @PutMapping("/update")
    public Registration updateRegistration(@RequestBody Registration registration) {
        return registrationService.updateRegistration(registration);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public void deleteRegistration(@PathVariable Long id) {
        registrationService.deleteRegistration(id);
    }
}