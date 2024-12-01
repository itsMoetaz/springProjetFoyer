package tn.esprit.springprojet1.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter //generer les getters
@Setter //generer les setters
@NoArgsConstructor
@ToString
public class Bloc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idBloc;
    private String nomBloc;
    private long capaciteBloc;
    @OneToMany(mappedBy = "bloc")
    @JsonIgnore
    private Set<Chambre> chambres;
    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    private Foyer foyer;
}
