package tn.esprit.springprojet1.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.springprojet1.entities.Bloc;
import tn.esprit.springprojet1.entities.Foyer;
import tn.esprit.springprojet1.repositories.BlocRepository;
import tn.esprit.springprojet1.repositories.FoyerRepository;

import java.util.List;

@AllArgsConstructor //tasna3 constructeur paramétré
@Service //tasna3lek instance taa service
@Slf4j
public class BlocServiceImp implements IBlocService {

    private BlocRepository blocRepository;
    private FoyerRepository foyerRepository;

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public List<Bloc> getAllBlocs() {


        return blocRepository.findAll();
    }

    @Override
    public Bloc getBlocById(long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void deleteBlocById(long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public Bloc getBlocByCapacity(long capaciteB) {
        return blocRepository.getBlocByCapacity(capaciteB);
    }

    @Override
    public void affecterBlocFoyer(Long blocID, Long foyerID) {
        Foyer foyer = foyerRepository.findById(foyerID).get();
        Bloc bloc = blocRepository.findById(blocID).get();
        bloc.setFoyer(foyer);
        blocRepository.save(bloc);
    }

    @Override
    public void desaffecterBlocFoyer(Long blocID) {
        Bloc bloc = blocRepository.findById(blocID).get();
        bloc.setFoyer(null);
        blocRepository.save(bloc);
    }
}
