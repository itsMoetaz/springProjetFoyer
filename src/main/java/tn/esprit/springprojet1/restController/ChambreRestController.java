package tn.esprit.springprojet1.restController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springprojet1.entities.Chambre;
import tn.esprit.springprojet1.entities.TypeChambre;
import tn.esprit.springprojet1.services.IChambreService;

import java.util.List;

@RestController
@Tag(name = "Gestion des chambres")
public class ChambreRestController {
    @Autowired
    private IChambreService ichambreService;

    @PostMapping("/addChambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        return ichambreService.addChambre(c);
    }

    @PutMapping("/updateChambre")
    public Chambre updateChambre(@RequestBody Chambre c) {
        return ichambreService.updateChambre(c);
    }

    @GetMapping("/getAllChambres")
    @Operation(description = "récupérer toutes les chambres de la base de données")
    public List<Chambre> getAllChambres() {
        return ichambreService.getAllChambres();
    }

    @GetMapping("/getChambreById/{idChambre}")
    public Chambre getChambreById(@PathVariable long idChambre) {
        return ichambreService.getChambreById(idChambre);
    }

    @DeleteMapping("/deleteChambreById/{idChambre}")
    public void deleteChambreById(@PathVariable long idChambre) {
        ichambreService.deleteChambreById(idChambre);
    }

    @GetMapping("/findChambreByBT/{idB}/{typeC}")
    public List<Chambre> findChambreByBT(@PathVariable long idB, @PathVariable TypeChambre typeC) {
        return ichambreService.findChambreByBT(idB, typeC);
    }

    @GetMapping("/findChambreByET/{cin}")
    public List<Chambre>findChambreByEt(@PathVariable Long cin){
        return ichambreService.findChambreByET(cin);
    }
}
