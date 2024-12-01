package tn.esprit.springprojet1.restController;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springprojet1.entities.Bloc;
import tn.esprit.springprojet1.services.IBlocService;

import java.util.List;

@RestController
public class BlocRestController {
    @Autowired
    private IBlocService iblocService;

    @PostMapping("/addBloc")
    public Bloc addBloc(@RequestBody Bloc b) {
        return iblocService.addBloc(b);
    }

    @PutMapping("/updateBloc")
    public Bloc updateBloc(@RequestBody Bloc b) {
        return iblocService.updateBloc(b);
    }

    @GetMapping("/getAllBlocs")
    public List<Bloc> getAllBlocs() {
        return iblocService.getAllBlocs();
    }

    @GetMapping("/getBlocById/{idBloc}")
    public Bloc getBlocById(@PathVariable long idBloc) {
        return iblocService.getBlocById(idBloc);
    }

    @DeleteMapping("/deleteBlocById/{idBloc}")
    public void deleteBlocById(@PathVariable long idBloc) {
        iblocService.deleteBlocById(idBloc);
    }

    @GetMapping("/getBlocByCapacity/{capaciteB}")
    public Bloc getBlocByCapacity(@PathVariable Long capaciteB) {return iblocService.getBlocByCapacity(capaciteB);}

    @PutMapping("/affecter-bloc-foyer/{bloc-id}/{foyer-id}")
    @Operation(description = "affecter bloc a foyer ")
    public void affecgterBlocFoyer(@PathVariable("bloc-id") Long blocID, @PathVariable("foyer-id") Long foyerID) {
    iblocService.affecterBlocFoyer(blocID, foyerID);
    }

    @PutMapping("/desaffecter-bloc-foyer/{bloc-id}")
    @Operation(description = "desaffecter bloc de foyer ")
    public void desaffecgterBlocFoyer(@PathVariable("bloc-id") Long blocID) {
        iblocService.desaffecterBlocFoyer(blocID);
    }
}
