package tn.esprit.mohamedyoussefazzouz4ds9.Services.Interfaces;

import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Skier;

import java.util.List;

public interface ISkierService {

    Skier addSkier(Skier skier);

    Skier updateSkier(Skier skier);

    void deleteSkier(Long id);

    Skier getSkier(Long id);

    List<Skier> getSkiers();
}