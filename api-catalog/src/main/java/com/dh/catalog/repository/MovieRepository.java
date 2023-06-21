package com.dh.catalog.repository;

import com.dh.catalog.model.movie.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    @Query("{'genre': ?0}")
    List<Movie> findAllByGenre(String genre);

}
