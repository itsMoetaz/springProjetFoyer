package tn.esprit.springprojet1.services;

import tn.esprit.springprojet1.entities.Etudiant;

import java.util.Date;
import java.util.List;

public interface IEtudiantService {
    public Etudiant addEtudiant(Etudiant e);
    public Etudiant updateEtudiant(Etudiant e);
    public List<Etudiant> getAllEtudiants();
    public Etudiant getEtudiantById(long idEtudiant);
    public void deleteEtudiantById(long idEtudiant);
    public List<Etudiant> recupererEtudiantsSelonEcoleEtDateNaisance(String e, Date d);
}
