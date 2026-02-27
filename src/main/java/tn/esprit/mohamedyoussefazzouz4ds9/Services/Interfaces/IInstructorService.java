package tn.esprit.mohamedyoussefazzouz4ds9.Services.Interfaces;

import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Instructor;

import java.util.List;

public interface IInstructorService {

    Instructor addInstructor(Instructor instructor);

    Instructor updateInstructor(Instructor instructor);

    void deleteInstructor(Long id);

    Instructor getInstructor(Long id);

    List<Instructor> getInstructors();
}
