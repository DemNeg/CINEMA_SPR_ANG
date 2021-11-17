package com.kuma.CinemaBackend.Dao;

import com.kuma.CinemaBackend.entities.ProjectionFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface ProjectionFilmRepository extends JpaRepository<ProjectionFilm,Long> {
    @Query("select p from ProjectionFilm p where p.salle.id=:x")
    public List<ProjectionFilm> list_ProjectionBySalle(@Param("x") Long id);
}
