package tn.esprit.mohamedyoussefazzouz4ds9.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Course;
import tn.esprit.mohamedyoussefazzouz4ds9.enums.Support;
import tn.esprit.mohamedyoussefazzouz4ds9.enums.TypeCourse;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {



}
