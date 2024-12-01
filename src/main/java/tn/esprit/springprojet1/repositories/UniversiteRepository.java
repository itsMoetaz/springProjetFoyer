package tn.esprit.springprojet1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springprojet1.entities.Universite;

public interface UniversiteRepository extends JpaRepository<Universite, Long> {
}
