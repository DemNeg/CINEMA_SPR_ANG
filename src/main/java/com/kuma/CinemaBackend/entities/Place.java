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
@Table(name = "place")
@Data @NoArgsConstructor @ToString
public class Place implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id",unique = true,nullable = false)
    private Long id;
    private int numero;
    private double longitude;
    private double latitude;
    private double altitude;
    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;
    @JsonIgnore
    @OneToMany(mappedBy = "place",fetch = FetchType.LAZY)
    private Collection<TicketPlace> ticketPlaces;

    public Place(int numero, double longitude, double latitude, double altitude, Salle salle) {
        this.numero = numero;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
        this.salle = salle;
    }
}
