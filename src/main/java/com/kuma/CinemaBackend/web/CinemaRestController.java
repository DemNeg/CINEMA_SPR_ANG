package com.kuma.CinemaBackend.web;

import com.kuma.CinemaBackend.Services.CinemaService;
import com.kuma.CinemaBackend.entities.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("CinemaRest")
@CrossOrigin("*")
public class CinemaRestController {
   @Autowired
    CinemaService cinemaService;
    @GetMapping("/dataInter/{id}")
    public List<DataIntermediaire> getSalles(@PathVariable(name = "id") int id){
       return cinemaService.listSalle_avec_contenu(id);
    }
    @GetMapping("/places/{id}")
    public List<Place> getPlaces(@PathVariable(name = "id") int idSalle){
        return cinemaService.list_de_Places(idSalle);
    }
}
