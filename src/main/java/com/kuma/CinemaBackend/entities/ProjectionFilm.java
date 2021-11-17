package com.kuma.CinemaBackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "projection_film")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class ProjectionFilm implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateProjection;
    private double prix;
    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    //Unidirectionnal manyToOne impl
    @ManyToOne
    @JoinColumn(name = "seance_id")
    private Seance seance;
    @JsonIgnore
    @OneToMany(mappedBy = "projectionFilm",fetch = FetchType.LAZY)
    private Collection<TicketPlace> ticketPlaces;

    public ProjectionFilm(Date dateProjection, double prix, Salle salle, Film film, Seance seance) {
        this.dateProjection = dateProjection;
        this.prix = prix;
        this.salle = salle;
        this.film = film;
        this.seance = seance;
    }
}
