package com.kuma.CinemaBackend.web;

import com.kuma.CinemaBackend.entities.Film;
import com.kuma.CinemaBackend.entities.Salle;
import com.kuma.CinemaBackend.entities.Seance;

import java.util.List;
public class DataIntermediaire {
    private Salle salle;
    private Film film;
    private List<Seance> seances;

    public DataIntermediaire() {
    }
    public DataIntermediaire(Salle salle, Film film, List<Seance> seances) {
        this.salle = salle;
        this.film = film;
        this.seances = seances;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public List<Seance> getSeances() {
        return seances;
    }

    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }
}
