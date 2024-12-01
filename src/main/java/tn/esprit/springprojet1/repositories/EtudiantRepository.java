package tn.esprit.springprojet1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springprojet1.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
