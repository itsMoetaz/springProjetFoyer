package tn.esprit.springprojet1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.springprojet1.entities.Chambre;
import tn.esprit.springprojet1.entities.TypeChambre;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
//    public List<Chambre> findByBloc_IdBlocAndTypeC(Long idBloc, TypeChambre TypeC);
    @Query("select c from Chambre c where c.bloc.idBloc= :idB and c.typeC= :typeC")
    public List<Chambre> findChambreByBT(@Param("idB") long idB, @Param("typeC") TypeChambre typeC);

}
