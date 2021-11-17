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
@Table(name = "cat_film")
@Data @NoArgsConstructor @ToString
public class CategorieFilm implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id",unique = true,nullable = false)
    private Long id;
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "categorie_film")
    private Collection<Film> films;

    public CategorieFilm(String name) {
        this.name = name;
    }
}
