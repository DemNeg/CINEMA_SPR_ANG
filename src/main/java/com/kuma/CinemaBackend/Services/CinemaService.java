package com.kuma.CinemaBackend.Services;

import com.kuma.CinemaBackend.entities.Place;
import com.kuma.CinemaBackend.entities.ProjectionFilm;
import com.kuma.CinemaBackend.web.DataIntermediaire;

import java.util.List;

public interface CinemaService {

    public List<DataIntermediaire> listSalle_avec_contenu(int id);
    public List<ProjectionFilm> getProjections(Long id);
    public List<Place> list_de_Places(int idSalle);
}
