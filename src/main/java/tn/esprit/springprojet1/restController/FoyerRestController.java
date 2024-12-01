package tn.esprit.springprojet1.restController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springprojet1.entities.Foyer;
import tn.esprit.springprojet1.services.IFoyerService;

import java.util.List;

@RestController
@AllArgsConstructor
public class FoyerRestController {
    private IFoyerService ifoyerService;

    @PostMapping("/addFoyer")
    public Foyer addFoyer(@RequestBody Foyer foyer) {
        return ifoyerService.addFoyer(foyer);
    }
    @PutMapping("/updateFoyer")
    public Foyer updateFoyer(Foyer foyer) {
        return ifoyerService.updateFoyer(foyer);
    }
    @GetMapping("/retrieveAllFoyer")
    public List<Foyer> retrieveAllFoyer() {
        return ifoyerService.retrieveAllFoyers();
    }
    @GetMapping("/retrieveFoyerById/{idFoyer}")
    public Foyer retrieveFoyerById(@PathVariable long idFoyer) {
        return ifoyerService.retrieveFoyerById(idFoyer);
    }
    @DeleteMapping("/retrieveFoyerById/{idFoyer}")
    public void deleteFoyerById(@PathVariable long idFoyer) {
        ifoyerService.retrieveFoyerById(idFoyer);
    }
    @GetMapping("/getFoyerByNom/{nomFoyer}")
    public Foyer getFoyerByNom(@PathVariable String nomFoyer) {return ifoyerService.getFoyerByNom(nomFoyer);}






}
