package tn.esprit.mohamedyoussefazzouz4ds9.Services.Implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Course;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Instructor;
import tn.esprit.mohamedyoussefazzouz4ds9.Repositories.CourseRepo;
import tn.esprit.mohamedyoussefazzouz4ds9.Repositories.InstructorRepo;
import tn.esprit.mohamedyoussefazzouz4ds9.Services.Interfaces.IInstructorService;
import tn.esprit.mohamedyoussefazzouz4ds9.enums.Support;

import java.util.*;

@Service
@AllArgsConstructor
public class InstructorServiceImpl implements IInstructorService {

    private InstructorRepo instructorRepo;
    private CourseRepo courseRepo;

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

    @Override
    public Instructor addInstructorAndAssignToCourse(Instructor instructor, Long numCourse) {

        Course course = courseRepo.findById(numCourse).get();
        instructor.getCourses().add(course);
        return instructorRepo.save(instructor);
}
    @Override
     public Instructor addInstructorAndAssignToCourses(Instructor instructor, List<Long> numCourse) {

        List<Course> courses = courseRepo.findAllById(numCourse);

        for (Course course : courses) {
            instructor.getCourses().add(course);
        }
        Set<Course> courseSet = new HashSet<>();
        for( Course course : courses){
            courseSet.add(course);
        }
        instructor.setCourses(courseSet);

        return instructorRepo.save(instructor);
    }

    @Override
    public List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support) {

        Instructor instructor = instructorRepo.findById(numInstructor).get();

        List<Integer> weeks = new ArrayList<>();

        instructor.getCourses().forEach(course -> {

            if(course.getSupport().equals(support)) {

                course.getRegistrations().forEach(registration -> {

                    weeks.add(registration.getNumWeek());

                });

            }

        });

        return weeks;
    }
}