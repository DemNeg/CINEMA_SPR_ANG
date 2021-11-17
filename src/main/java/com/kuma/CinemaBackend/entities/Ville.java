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
@Table(name = "ville")
@Data @NoArgsConstructor @ToString
public class Ville implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id",unique = true,nullable = false)
    private Long id;
    private String name;
    private double longitude;
    private double latitude;
    private double altitude;
    @JsonIgnore
    @OneToMany(mappedBy = "ville",fetch = FetchType.LAZY)
    private Collection<Cinema> cinemas;

    public Ville(String name, double longitude, double latitude, double altitude) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
    }
}
