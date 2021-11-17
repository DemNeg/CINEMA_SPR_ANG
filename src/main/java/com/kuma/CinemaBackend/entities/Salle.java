package com.kuma.CinemaBackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "SALLE")
@Data @NoArgsConstructor @ToString
public class Salle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id",unique = true,nullable = false)
    private Long id;
    private String name;
    private int nombrePlaces;
    @JsonIgnore
    @OneToMany(mappedBy = "salle",fetch = FetchType.LAZY)
    private Collection<Place> places;
    @JsonIgnore
    @OneToMany(mappedBy = "salle",fetch = FetchType.LAZY)
    private Collection<ProjectionFilm> projectionFilms;
    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    public Salle(String name, Cinema cinema) {
        this.name = name;
        this.cinema = cinema;
    }
}
