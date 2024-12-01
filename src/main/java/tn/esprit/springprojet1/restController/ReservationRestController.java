package tn.esprit.springprojet1.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springprojet1.entities.Reservation;
import tn.esprit.springprojet1.services.IReservationService;

import java.util.List;

@RestController
public class ReservationRestController {
    @Autowired
    private IReservationService ireservationService;

    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation r) {
        return ireservationService.addReservation(r);
    }

    @PutMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation r) {
        return ireservationService.updateReservation(r);
    }

    @GetMapping("/getAllReservations")
    public List<Reservation> getAllReservations() {
        return ireservationService.getAllReservations();
    }

    @GetMapping("/getReservationById/{idReservation}")
    public Reservation getReservationById(@PathVariable long idReservation) {
        return ireservationService.getReservationById(idReservation);
    }

    @DeleteMapping("/deleteReservationById/{idReservation}")
    public void deleteReservationById(@PathVariable long idReservation) {
        ireservationService.deleteReservationById(idReservation);
    }

    @PutMapping("/affecterReservationAuChambre/{ReservationID}/{chambreID}")
    public void affecterReservationAuChambre(@PathVariable Long ReservationID,@PathVariable Long chambreID){
        ireservationService.affecterReservationAuCHambre(ReservationID,chambreID);
    };

    @PutMapping("/desaffecterReservationDuChambre/{ReservationID}")
    public void desaffecterReservationDuChambre(@PathVariable Long ReservationID){
        ireservationService.desaffecterReservationDuCHambre(ReservationID);
    };
}
