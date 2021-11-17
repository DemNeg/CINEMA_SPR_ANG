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
@Data @NoArgsConstructor @ToString
@Table(name = "cinema")
public class Cinema implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    private String name;
    private double longitude;
    private double latitude;
    private double altitude;
    private int nombreSalles;
    @ManyToOne
    @JoinColumn(name = "ville_id")
    private Ville ville;
    @OneToMany(mappedBy = "cinema",fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Salle> salles;

    public Cinema(String name, double longitude, double latitude, double altitude, Ville ville) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
        this.ville = ville;
    }
}
