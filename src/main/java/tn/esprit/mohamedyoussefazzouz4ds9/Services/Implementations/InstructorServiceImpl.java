package tn.esprit.mohamedyoussefazzouz4ds9.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Instructor;
import tn.esprit.mohamedyoussefazzouz4ds9.Repositories.InstructorRepo;
import tn.esprit.mohamedyoussefazzouz4ds9.Services.Interfaces.IInstructorService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InstructorServiceImpl implements IInstructorService {

    private InstructorRepo instructorRepo;

    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepo.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Instructor instructor) {
        return instructorRepo.save(instructor);
    }

    @Override
    public void deleteInstructor(Long id) {
        instructorRepo.deleteById(id);
    }

    @Override
    public Instructor getInstructor(Long id) {

        Optional<Instructor> optionalInstructor = instructorRepo.findById(id);

        if (optionalInstructor.isPresent()) {
            return optionalInstructor.get();
        } else {
            throw new RuntimeException("Instructor not found");
        }
    }

    @Override
    public List<Instructor> getInstructors() {
        return instructorRepo.findAll();
    }
}