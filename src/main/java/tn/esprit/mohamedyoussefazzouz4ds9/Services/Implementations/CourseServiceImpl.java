package tn.esprit.mohamedyoussefazzouz4ds9.Services.Implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Course;
import tn.esprit.mohamedyoussefazzouz4ds9.Repositories.CourseRepo;
import tn.esprit.mohamedyoussefazzouz4ds9.Services.Interfaces.ICourseService;

import java.util.List;

@Repository
@AllArgsConstructor
public class CourseServiceImpl implements ICourseService {

    private final CourseRepo courseRepo;
    @Override
    public Course addCourse(Course course) {

        return courseRepo.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);

    }

    @Override
    public Course getCourse(Long id) {
        return courseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    @Override
    public List<Course> getCourses() {
        return courseRepo.findAll();
    }
}
