package tn.esprit.springprojet1.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springprojet1.entities.Foyer;
import tn.esprit.springprojet1.entities.Universite;
import tn.esprit.springprojet1.repositories.FoyerRepository;
import tn.esprit.springprojet1.repositories.UniversiteRepository;

import java.util.List;

@RequiredArgsConstructor  //tasna3 constructeur paramétré
@Service //tasna3lek instance taa service
@Slf4j

public class UniversiteServiceImp implements IUniversiteService {
    private final UniversiteRepository universiteRepository;

    private final FoyerRepository foyerRepository;

    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite getUniversiteById(long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public void deleteUniversiteById(long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idU, long idF) {
        Foyer foyer = foyerRepository.findById(idF).orElse(null);
        Universite universite = universiteRepository.findById(idU).orElse(null);
        universite.setFoyer(foyer);
            return universiteRepository.save(universite);
    }
}
