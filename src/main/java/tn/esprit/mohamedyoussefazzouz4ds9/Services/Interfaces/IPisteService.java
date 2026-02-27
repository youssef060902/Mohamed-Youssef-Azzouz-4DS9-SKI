package tn.esprit.mohamedyoussefazzouz4ds9.Services.Interfaces;

import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Piste;

import java.util.List;

public interface IPisteService {

    Piste addPiste(Piste piste);

    Piste updatePiste(Piste piste);

    void deletePiste(Long id);

    Piste getPiste(Long id);

    List<Piste> getPistes();
}