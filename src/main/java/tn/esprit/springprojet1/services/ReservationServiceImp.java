package tn.esprit.springprojet1.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.springprojet1.entities.Chambre;
import tn.esprit.springprojet1.entities.Reservation;
import tn.esprit.springprojet1.repositories.ChambreRepository;
import tn.esprit.springprojet1.repositories.ReservationRepository;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor //tasna3 constructeur paramétré
@Service //tasna3lek instance taa service
@Slf4j

public class ReservationServiceImp implements IReservationService {

    private ReservationRepository reservationRepository;
    private ChambreRepository chambreRepository;

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(long idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public void deleteReservationById(long idReservation) {
        reservationRepository.deleteById(idReservation);
    }

    @Override
   // @Scheduled(fixedRate = 50000)
    public void mettreAJourEtAfficherReservations() {
        LocalDate dateSeuil = LocalDate.of(2024, 1, 1);
        List<Reservation> reservations = reservationRepository.findByDateDebutBefore(dateSeuil);
        for (Reservation reservation : reservations) {
            reservation.setEstValide(false);
            reservationRepository.save(reservation);
        }
        List<Reservation> reservation = reservationRepository.findAll();
        log.info("les reservations :" + reservation);
    }

    @Override
    public void affecterReservationAuCHambre(Long reservationID, Long chambreID) {
        Reservation reservation = reservationRepository.findById(reservationID).get();
        Chambre chambre = chambreRepository.findById(chambreID).get();
        reservation.setChambre(chambre);
        reservationRepository.save(reservation);
            }

    @Override
    public void desaffecterReservationDuCHambre(Long reservationID) {
        Reservation reservation = reservationRepository.findById(reservationID).get();
        reservation.setChambre(null);
        reservationRepository.save(reservation);
    }
}
