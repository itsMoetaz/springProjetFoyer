package tn.esprit.springprojet1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springprojet1.entities.Foyer;

public interface FoyerRepository extends JpaRepository<Foyer, Long> {
    Foyer findByNomFoyer(String nomFoyer);
}

