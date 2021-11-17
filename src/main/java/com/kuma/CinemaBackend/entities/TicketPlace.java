package com.kuma.CinemaBackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class TicketPlace implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id",unique = true,nullable = false)
    private Long id;
    private double prix;
    private String nomClient;
    private int codePayement;
    private boolean reservee;
    @ManyToOne
    @JoinColumn(name = "projection_id")
    private ProjectionFilm projectionFilm;
    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    public TicketPlace(double prix, String nomClient, int codePayement, boolean reservee, ProjectionFilm projectionFilm, Place place) {
        this.prix = prix;
        this.nomClient = nomClient;
        this.codePayement = codePayement;
        this.reservee = reservee;
        this.projectionFilm = projectionFilm;
        this.place = place;
    }
}
