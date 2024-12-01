package tn.esprit.springprojet1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Getter //generer les getters
@Setter //generer les setters
@NoArgsConstructor
@ToString
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    @Temporal(TemporalType.DATE)
    private Date anneeUniversitaire;
    private boolean estValide;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    @ManyToMany
    @JsonIgnore
    @ToString.Exclude
    private Set<Etudiant> etudiants;
    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    private Chambre chambre;
}
