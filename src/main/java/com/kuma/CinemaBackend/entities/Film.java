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
@Table(name = "film")
@Data @NoArgsConstructor  @ToString
public class Film implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id",unique = true,nullable = false)
    private Long id;
    private String titre;
    private double duree;
    private String realisateur;
    private String description;
    private String photo;
    private Date dateSorite;
    @JsonIgnore
    @OneToMany(mappedBy = "film",fetch = FetchType.LAZY)
    private Collection<ProjectionFilm> projectionFilms;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private CategorieFilm categorie_film;

    public Film(String titre, double duree, String realisateur, String description, String photo, Date dateSorite, CategorieFilm categorie_film) {
        this.titre = titre;
        this.duree = duree;
        this.realisateur = realisateur;
        this.description = description;
        this.photo = photo;
        this.dateSorite = dateSorite;
        this.categorie_film = categorie_film;
    }
}
