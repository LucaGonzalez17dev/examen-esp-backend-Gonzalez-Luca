package com.dh.movie.service;


import com.dh.movie.event.PeliculaGuardadaEvent;
import com.dh.movie.model.Movie;
import com.dh.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {


    private final MovieRepository movieRepository;

    private final PeliculaGuardadaEvent peliculaGuardadaEvent;

    public MovieService(MovieRepository movieRepository, PeliculaGuardadaEvent peliculaGuardadaEvent) {
        this.movieRepository = movieRepository;
        this.peliculaGuardadaEvent = peliculaGuardadaEvent;
    }

    public List<Movie> findByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    public Movie save(Movie movie) {
        peliculaGuardadaEvent.guardarPelicula(movie);
        return movieRepository.save(movie);
    }
}
