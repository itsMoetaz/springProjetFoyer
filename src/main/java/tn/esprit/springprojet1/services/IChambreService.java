package tn.esprit.springprojet1.services;

import tn.esprit.springprojet1.entities.Chambre;
import tn.esprit.springprojet1.entities.TypeChambre;

import java.util.List;

public interface IChambreService {
    public Chambre addChambre(Chambre c);
    public Chambre updateChambre(Chambre c);
    public List<Chambre> getAllChambres();
    public Chambre getChambreById(long idChambre);
    public void deleteChambreById(long idChambre);
//    public List<Chambre> findByBloc_IdBlocAndTypeC(Long idBloc, TypeChambre typeC);
    public List<Chambre> findChambreByBT(Long idB, TypeChambre typeC);
}
