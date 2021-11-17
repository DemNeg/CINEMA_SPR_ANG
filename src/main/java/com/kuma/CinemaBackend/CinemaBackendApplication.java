package com.kuma.CinemaBackend;

import com.kuma.CinemaBackend.Dao.*;
import com.kuma.CinemaBackend.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.RestControllerConfiguration;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

@SpringBootApplication
public class CinemaBackendApplication implements CommandLineRunner {
	@Autowired
	VilleRepository villeRepository;
	@Autowired
	CinemaRepository cinemaRepository;
	@Autowired
	SalleRepository salleRepository;
	@Autowired
	CategorieFilmRepository categorieFilmRepository;
	@Autowired
	FilmRepository filmRepository;
	@Autowired
	SeanceRepository seanceRepository;
	@Autowired
	TicketPlaceRepository ticketPlaceRepository;
	@Autowired
	RepositoryRestConfiguration restConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(CinemaBackendApplication.class, args);
	}
	@Autowired
	PlaceRepository placeRepository;
	@Autowired
	ProjectionFilmRepository projectionFilmRepository;
	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Cinema.class);
		restConfiguration.exposeIdsFor(Ville.class);
		//Les villes
		Ville v1 = villeRepository.save(new Ville("Rabat",100,500,600));
		Ville v2 = villeRepository.save(new Ville("Fes",444,332,120));
		Ville v3 = villeRepository.save(new Ville("Marrakech",333,620,111));
		Ville v4 = villeRepository.save(new Ville("Tanger",121,635,564));
		//Les cinemas
		Cinema cn1 = cinemaRepository.save(new Cinema("Pazza XL",561,546,200,v1));
		Cinema cn2 = cinemaRepository.save(new Cinema("LES LECHERS",622,451,100,v1));
		Cinema cn3 = cinemaRepository.save(new Cinema("Pazza XL",214,620,333,v2));
		//Les salles
		Salle sl1 = salleRepository.save(new Salle("Salle 001",cn1));
		Salle sl2 = salleRepository.save(new Salle("Salle 002",cn1));
		Salle sl3 = salleRepository.save(new Salle("Salle 003",cn1));
		Salle sl4 = salleRepository.save(new Salle("Salle 100",cn2));
		Salle sl5 = salleRepository.save(new Salle("Salle 101",cn2));
		Salle sl6 = salleRepository.save(new Salle("Salle 102",cn2));
		Salle sl7 = salleRepository.save(new Salle("Salle 200",cn3));
		Salle sl8 = salleRepository.save(new Salle("Salle 201",cn3));
		Salle sl9 = salleRepository.save(new Salle("Salle 202",cn3));
		//Les places
		Place pl1 = placeRepository.save(new Place(1,200,212,100,sl1));
		Place pl12 = placeRepository.save(new Place(2,200,212,100,sl1));
		Place pl2 = placeRepository.save(new Place(4,202,50,33,sl2));
		Place pl22 = placeRepository.save(new Place(5,545,66,21,sl2));
		Place pl3 = placeRepository.save(new Place(1,545,66,52,sl3));
		Place pl32 = placeRepository.save(new Place(2,200,212,522,sl3));
		Place pl4 = placeRepository.save(new Place(1,545,66,52,sl4));
		Place pl42 = placeRepository.save(new Place(2,200,212,522,sl4));
		Place pl5 = placeRepository.save(new Place(1,545,66,52,sl5));
		Place pl52 = placeRepository.save(new Place(2,200,212,522,sl5));
		Place pl6 = placeRepository.save(new Place(1,545,66,52,sl6));
		Place pl62 = placeRepository.save(new Place(2,200,212,522,sl6));
		Place pl7 = placeRepository.save(new Place(1,545,66,52,sl7));
		Place pl72 = placeRepository.save(new Place(2,200,212,522,sl7));
		Place pl8 = placeRepository.save(new Place(1,545,66,52,sl8));
		Place pl82 = placeRepository.save(new Place(2,200,212,522,sl8));
		Place pl9 = placeRepository.save(new Place(1,545,66,52,sl9));
		Place pl92 = placeRepository.save(new Place(2,200,212,522,sl9));

		// Les categories de film
		CategorieFilm cat1 = categorieFilmRepository.save(new CategorieFilm("Action"));
		CategorieFilm cat2 = categorieFilmRepository.save(new CategorieFilm("Aventure"));
		CategorieFilm cat3 = categorieFilmRepository.save(new CategorieFilm("Romance"));

		// Les films
		Film f1 = filmRepository.save(new Film("Rambo",200,"George lucas","Film de guerre,avec de l'action","Photo d'affiche",new Date(),cat1));
		Film f2 = filmRepository.save(new Film("Le secret de la lettre de feu",190,"George lucas","Film d'aventure","Photo d'affiche",new Date(),cat2));
		Film f3 = filmRepository.save(new Film("One day",890,"George Rodriguez","Film de romance,d'amour","Photo d'affiche",new Date(),cat3));

		//Les Seances
		Seance sn = seanceRepository.save(new Seance(addHours(new Date(2021,11,11), 8)));
		Seance sn1 = seanceRepository.save(new Seance(addHours(new Date(2021,11,11), 11)));
		Seance sn2 = seanceRepository.save(new Seance(addHours(new Date(2021,11,11), 14)));
		Seance sn3 = seanceRepository.save(new Seance(addHours(new Date(2021,11,11), 17)));
		//Les projections
		ProjectionFilm pf1 = projectionFilmRepository.save(new ProjectionFilm(new Date(2021,11,15),75,sl1,f1,sn));
		ProjectionFilm pf2 = projectionFilmRepository.save(new ProjectionFilm(new Date(2021,11,15),75,sl2,f1,sn1));
		ProjectionFilm pf3 = projectionFilmRepository.save(new ProjectionFilm(new Date(2021,11,15),75,sl3,f2,sn2));
		ProjectionFilm pf4 = projectionFilmRepository.save(new ProjectionFilm(new Date(2021,11,15),75,sl4,f2,sn3));
		//Les Tickets
		TicketPlace tk1 = ticketPlaceRepository.save(new TicketPlace(75,"Singou",1232,false,pf1,pl1));
		TicketPlace tk2 = ticketPlaceRepository.save(new TicketPlace(75,"Mohamed",1211,false,pf1,pl12));
		TicketPlace tk3 = ticketPlaceRepository.save(new TicketPlace(75,"Assetou",4232,false,pf2,pl2));
		TicketPlace tk4 = ticketPlaceRepository.save(new TicketPlace(75,"Ousmane",1542,false,pf2,pl22));
	}
	public Date addHours(Date date, int hours) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, hours);
		return calendar.getTime();
	}
}

