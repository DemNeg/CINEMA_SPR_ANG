package com.kuma.CinemaBackend.Services;

import com.kuma.CinemaBackend.Dao.*;
import com.kuma.CinemaBackend.entities.*;
import com.kuma.CinemaBackend.web.DataIntermediaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService{
   @Autowired
    SalleRepository salleRepository;
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    SeanceRepository seanceRepository;
    @Autowired
    ProjectionFilmRepository projectionFilmRepository;
    @Autowired
    PlaceRepository placeRepository;
    @Override
    public List<DataIntermediaire> listSalle_avec_contenu(int id) {
        List<Salle> salles = salleRepository.listParCinema(Long.valueOf(id));
        List<DataIntermediaire> dataIntermediaires= new ArrayList<DataIntermediaire>();
       for(int i=0;i<salles.size();i++)
       {
            DataIntermediaire dataIntermediaire = new DataIntermediaire();
            dataIntermediaire.setSalle(salles.get(i));
            dataIntermediaire.setFilm(trouverFilm(salles.get(i).getId()));
            dataIntermediaire.setSeances(trouverSeances(salles.get(i).getId()));
            dataIntermediaires.add(dataIntermediaire);
       }
        return dataIntermediaires;
    }

    public List<ProjectionFilm> getProjections(Long id)
    {
        return projectionFilmRepository.list_ProjectionBySalle(id);
    }

    @Override
    public List<Place> list_de_Places(int idSalle) {
        return placeRepository.listPlaces(Long.valueOf(idSalle));
    }

    private List<Seance> trouverSeances(Long id) {
        List<ProjectionFilm> listDesProjection_BY_salle = getProjections(id);
        List<Seance> seances = new ArrayList<>();
        for (int i=0;i<listDesProjection_BY_salle.size();i++)
        {
            seances.add(listDesProjection_BY_salle.get(i).getSeance());
        }
        return seances;
    }

    private Film trouverFilm(Long id) {
        List<ProjectionFilm> listDesProjection_BY_salle = getProjections(id);
        int i=listDesProjection_BY_salle.size();
        Film film=new Film();
        if(listDesProjection_BY_salle.size()>0)
        {
            film = listDesProjection_BY_salle.get(i-1).getFilm();
            System.out.println(listDesProjection_BY_salle.get(0).getFilm().getTitre());
        }

        return film;
    }
}
