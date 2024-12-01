package tn.esprit.springprojet1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.springprojet1.entities.Bloc;

public interface BlocRepository extends JpaRepository<Bloc, Long> {
    @Query ("select  b from Bloc b where b.capaciteBloc= :capaciteB")
     Bloc getBlocByCapacity(@Param("capaciteB") long capaciteB);
}
