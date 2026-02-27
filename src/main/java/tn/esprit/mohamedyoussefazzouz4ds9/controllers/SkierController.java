package tn.esprit.mohamedyoussefazzouz4ds9.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Skier;
import tn.esprit.mohamedyoussefazzouz4ds9.Services.Interfaces.ISkierService;

import java.util.List;

@RestController
@RequestMapping("/api/skier")
@AllArgsConstructor
public class SkierController {

    private ISkierService skierService;

    @PostMapping("/add")
    public Skier addSkier(@RequestBody Skier skier) {
        return skierService.addSkier(skier);
    }

    @GetMapping("/all")
    public List<Skier> getAllSkiers() {
        return skierService.getSkiers();
    }

    @GetMapping("/{id}")
    public Skier getSkier(@PathVariable Long id) {
        return skierService.getSkier(id);
    }

    @PutMapping("/update")
    public Skier updateSkier(@RequestBody Skier skier) {
        return skierService.updateSkier(skier);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSkier(@PathVariable Long id) {
        skierService.deleteSkier(id);
    }
}