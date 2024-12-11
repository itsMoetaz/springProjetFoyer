package tn.esprit.springprojet1.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springprojet1.entities.Etudiant;
import tn.esprit.springprojet1.services.IEtudiantService;

import java.util.Date;
import java.util.List;

@RestController
public class EtudiantRestController {
    @Autowired
    private IEtudiantService ietudiantService;

    @PostMapping("/addEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        return ietudiantService.addEtudiant(e);
    }
    @PutMapping("/updateEtudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        return ietudiantService.updateEtudiant(e);
    }
    @GetMapping("/getAllEtudiants")
    public List<Etudiant> getAllEtudiants() {
        return ietudiantService.getAllEtudiants();
    }
    @GetMapping("/getEtudiantById/{idEtudiant}")
    public Etudiant getEtudiantById(@PathVariable long idEtudiant) {
        return ietudiantService.getEtudiantById(idEtudiant);
    }

    @GetMapping("/getEtudiantByEcoleAndDateNaissance/{ecole}/{dateN}")
    public List<Etudiant>getEtudiantByEcoleAndDateNaissance(@PathVariable("ecole") String ecole,
                                                            @PathVariable("dateN") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateN) {
        return ietudiantService.recupererEtudiantsSelonEcoleEtDateNaisance(ecole, dateN);
    }


    @DeleteMapping("/deleteEtudiantById/{idEtudiant}")
    public void deleteEtudiantById(@PathVariable long idEtudiant) {
        ietudiantService.deleteEtudiantById(idEtudiant);
    }
}
