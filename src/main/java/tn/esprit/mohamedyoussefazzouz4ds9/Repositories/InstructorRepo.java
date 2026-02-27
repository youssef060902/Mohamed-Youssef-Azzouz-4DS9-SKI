package tn.esprit.mohamedyoussefazzouz4ds9.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Instructor;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor, Long> {

}