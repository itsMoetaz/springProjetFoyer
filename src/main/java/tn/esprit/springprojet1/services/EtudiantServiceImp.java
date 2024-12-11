package tn.esprit.springprojet1.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springprojet1.entities.Etudiant;
import tn.esprit.springprojet1.repositories.EtudiantRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor  //tasna3 constructeur paramétré

public class EtudiantServiceImp implements IEtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        // Fetch the existing Etudiant
        Etudiant existingEtudiant = etudiantRepository.findById(e.getIdEtudiant())
                .orElseThrow(() -> new RuntimeException("Etudiant not found"));

        // Copy non-null properties from the new object to the existing one
        BeanUtils.copyProperties(e, existingEtudiant, getNullPropertyNames(e));

        // Save and return the updated Etudiant
        return etudiantRepository.save(existingEtudiant);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiantById(long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public void deleteEtudiantById(long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public List<Etudiant> recupererEtudiantsSelonEcoleEtDateNaisance(String e, Date d) {
        return etudiantRepository.findAllByEcoleAndDateNaissanceGreaterThan(e, d);
    }

    private String[] getNullPropertyNames(Etudiant source) {
        return Arrays.stream(BeanUtils.getPropertyDescriptors(source.getClass()))
                .map(pd -> pd.getName())
                .filter(name -> {
                    try {
                        return BeanUtils.getPropertyDescriptor(source.getClass(), name).getReadMethod().invoke(source) == null;
                    } catch (Exception e) {
                        return false;
                    }
                })
                .toArray(String[]::new);
    }
}
