package tn.esprit.springprojet1.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.springprojet1.entities.Chambre;
import tn.esprit.springprojet1.entities.TypeChambre;
import tn.esprit.springprojet1.repositories.ChambreRepository;

import java.util.List;

@AllArgsConstructor //tasna3 constructeur paramétré
@Service //tasna3lek instance taa service
@Slf4j

public class ChambreServiceImp implements IChambreService {

    private ChambreRepository chambreRepository;

    @Override
    public Chambre addChambre(Chambre chambre) {
        chambre.getReservations().forEach(reservation -> reservation.setChambre(chambre));
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    //@Scheduled(fixedRate = 5000)
    //@Scheduled(cron = "0 0 8 * 4 *")
    public List<Chambre> getAllChambres() {
    List<Chambre> chambreList = chambreRepository.findAll();
    for (Chambre chambre : chambreList) {
        log.info("CHambre:" + chambre);
    }

        return chambreList;
    }

    @Override
    public Chambre getChambreById(long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public void deleteChambreById(long idChambre) {
        chambreRepository.deleteById(idChambre);
    }


    @Override
    public List<Chambre> findChambreByBT(Long idB, TypeChambre typeC) {
        return chambreRepository.findChambreByBT(idB, typeC);
    }

//    @Override
//    public List<Chambre> findByBloc_IdBlocAndTypeC(Long idBloc, TypeChambre typeC) {
//        return chambreRepository.findByBloc_IdBlocAndTypeC(idBloc, typeC);
//    }
}
