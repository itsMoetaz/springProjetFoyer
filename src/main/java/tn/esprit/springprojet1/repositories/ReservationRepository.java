package tn.esprit.springprojet1.repositories;

import org.apache.catalina.LifecycleState;
import org.hibernate.annotations.ListIndexJdbcType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.springprojet1.entities.Reservation;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

   @Query("select count(r)  from Reservation r where r.dateDebut= :start and r.dateFin= :end")
//    public Reservation getNombreReservation(Date debut, Date fin);
    Long countByDateDebutBetween(LocalDate start, LocalDate end);
    List<Reservation> findByDateDebutBefore(LocalDate date);

}
