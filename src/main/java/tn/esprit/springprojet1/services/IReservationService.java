package tn.esprit.springprojet1.services;

import tn.esprit.springprojet1.entities.Chambre;
import tn.esprit.springprojet1.entities.Reservation;

import java.util.List;

public interface IReservationService {
    public Reservation addReservation(Reservation r);
    public Reservation updateReservation(Reservation r);
    public List<Reservation> getAllReservations();
    public Reservation getReservationById(long idReservation);
    public void deleteReservationById(long idReservation);
    public void mettreAJourEtAfficherReservations();
    public void affecterReservationAuCHambre(Long reservationID, Long chambreID);
    public void desaffecterReservationDuCHambre(Long reservationID);

}
