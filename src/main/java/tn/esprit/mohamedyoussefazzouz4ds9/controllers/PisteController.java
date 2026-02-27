package tn.esprit.mohamedyoussefazzouz4ds9.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Piste;
import tn.esprit.mohamedyoussefazzouz4ds9.Services.Interfaces.IPisteService;

import java.util.List;

@RestController
@RequestMapping("/api/piste")
@AllArgsConstructor
public class PisteController {

    private IPisteService pisteService;

    @PostMapping("/add")
    public Piste addPiste(@RequestBody Piste piste) {
        return pisteService.addPiste(piste);
    }

    @GetMapping("/all")
    public List<Piste> getAllPistes() {
        return pisteService.getPistes();
    }

    @GetMapping("/{id}")
    public Piste getPiste(@PathVariable Long id) {
        return pisteService.getPiste(id);
    }

    @PutMapping("/update")
    public Piste updatePiste(@RequestBody Piste piste) {
        return pisteService.updatePiste(piste);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePiste(@PathVariable Long id) {
        pisteService.deletePiste(id);
    }
}