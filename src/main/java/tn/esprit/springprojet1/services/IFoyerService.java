package tn.esprit.springprojet1.services;

import tn.esprit.springprojet1.entities.Foyer;

import java.util.List;

public interface IFoyerService {
    public Foyer addFoyer(Foyer foyer);
    public Foyer updateFoyer(Foyer foyer);
    public List<Foyer> retrieveAllFoyers();
    public Foyer retrieveFoyerById(long idFoyer);
    public void deleteFoyer(long idFoyer);
    public  Foyer getFoyerByNom(String nomFoyer);
}
