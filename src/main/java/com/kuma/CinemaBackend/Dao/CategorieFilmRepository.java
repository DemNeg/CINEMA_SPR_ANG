package com.kuma.CinemaBackend.Dao;

import com.kuma.CinemaBackend.entities.CategorieFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface CategorieFilmRepository extends JpaRepository<CategorieFilm,Long> {
}
