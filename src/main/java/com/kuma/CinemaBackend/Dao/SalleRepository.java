package com.kuma.CinemaBackend.Dao;

import com.kuma.CinemaBackend.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface SalleRepository extends JpaRepository<Salle,Long> {
    @Query("select s from Salle s where s.cinema.id=:x")
    public List<Salle> listParCinema(@Param("x") Long id);
}
