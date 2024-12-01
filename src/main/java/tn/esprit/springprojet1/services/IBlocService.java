package tn.esprit.springprojet1.services;

import tn.esprit.springprojet1.entities.Bloc;
import tn.esprit.springprojet1.entities.Foyer;

import java.util.List;

public interface IBlocService {
    public Bloc addBloc(Bloc b);
    public Bloc updateBloc(Bloc b);
    public List<Bloc> getAllBlocs();
    public Bloc getBlocById(long idBloc);
    public void deleteBlocById(long idBloc);
    public Bloc getBlocByCapacity(long capaciteB);
    public void affecterBlocFoyer(Long bloc, Long foyer);
    public void desaffecterBlocFoyer(Long blocID);
}
