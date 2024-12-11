package tn.esprit.springprojet1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springprojet1.entities.Etudiant;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    public List<Etudiant> findAllByEcoleAndDateNaissanceGreaterThan(String e, Date d);
}
