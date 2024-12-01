package tn.esprit.springprojet1.services;

import tn.esprit.springprojet1.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    public Universite addUniversite(Universite u);
    public Universite updateUniversite(Universite u);
    public List<Universite> getAllUniversites();
    public Universite getUniversiteById(long idUniversite);
    public void deleteUniversiteById(long idUniversite);
    public Universite affecterFoyerAUniversite(long idUniversite,long idFoyer);
}
