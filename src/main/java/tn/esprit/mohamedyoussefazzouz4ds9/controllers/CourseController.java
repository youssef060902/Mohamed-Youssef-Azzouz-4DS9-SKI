package tn.esprit.mohamedyoussefazzouz4ds9.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Course;
import tn.esprit.mohamedyoussefazzouz4ds9.Services.Interfaces.ICourseService;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final ICourseService courseService;

    // 🔥 Injection par constructeur (100% fiable)
    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @GetMapping("/all")
    public List<Course> getAllCourses(){
        return courseService.getCourses();
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable Long id){
        return courseService.getCourse(id);
    }

    @PutMapping("/update")
    public Course updateCourse(@RequestBody Course course){
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
    }
}