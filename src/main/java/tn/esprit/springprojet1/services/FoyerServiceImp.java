package tn.esprit.springprojet1.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.springprojet1.entities.Foyer;
import tn.esprit.springprojet1.repositories.FoyerRepository;

import java.util.List;
@AllArgsConstructor //tasna3 constructeur paramétré
@Service //tasna3lek instance taa service
@Slf4j



public class FoyerServiceImp implements IFoyerService{

    private FoyerRepository foyerRepository;
    @Override
    public Foyer addFoyer(Foyer foyer) {
        foyer.getBlocs().forEach(bloc -> bloc.setFoyer(foyer));

        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer retrieveFoyerById(long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public void deleteFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }

    @Override
    public Foyer getFoyerByNom(String nomFoyer) {
        return foyerRepository.findByNomFoyer(nomFoyer);
    }


}
