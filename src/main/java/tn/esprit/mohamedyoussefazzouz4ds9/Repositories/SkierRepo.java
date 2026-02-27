package tn.esprit.mohamedyoussefazzouz4ds9.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.mohamedyoussefazzouz4ds9.Entity.Skier;

@Repository
public interface SkierRepo extends JpaRepository<Skier, Long> {

}