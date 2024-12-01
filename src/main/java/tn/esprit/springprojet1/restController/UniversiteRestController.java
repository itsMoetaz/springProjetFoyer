package tn.esprit.springprojet1.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springprojet1.entities.Universite;
import tn.esprit.springprojet1.services.IUniversiteService;

import java.util.List;

@RestController
public class UniversiteRestController {
    @Autowired
    private IUniversiteService iuniversiteService;

    @PostMapping("/addUniversite")
    public Universite addUniversite(@RequestBody Universite u) {
        return iuniversiteService.addUniversite(u);
    }

    @PutMapping("/updateUniversite")
    public Universite updateUniversite(@RequestBody Universite u) {
        return iuniversiteService.updateUniversite(u);
    }

    @GetMapping("/getAllUniversites")
    public List<Universite> getAllUniversites() {
        return iuniversiteService.getAllUniversites();
    }

    @GetMapping("/getUniversiteById/{idUniversite}")
    public Universite getUniversiteById(@PathVariable long idUniversite) {
        return iuniversiteService.getUniversiteById(idUniversite);
    }

    @DeleteMapping("/deleteUniversiteById/{idUniversite}")
    public void deleteUniversiteById(@PathVariable long idUniversite) {
        iuniversiteService.deleteUniversiteById(idUniversite);
    }

    @PostMapping("/affecterFoyer/{idF}/{idU}")
    public Universite affecterFoyerAUniversite(@PathVariable long idF,@PathVariable long idU){
       return iuniversiteService.affecterFoyerAUniversite(idF, idU);
    }
}
