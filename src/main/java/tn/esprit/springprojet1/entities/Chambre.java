package tn.esprit.springprojet1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter //generer les getters
@Setter //generer les setters
@NoArgsConstructor
@ToString
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private long idChambre;
    private long numChambre;
    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "chambre")
    private Set<Reservation> reservations= new HashSet<Reservation>();
    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Bloc bloc;


}
