package com.dh.catalogservice.repositories;

import com.dh.catalogservice.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MoviesRespository extends MongoRepository<Movie, Long> {

    List<Movie> findByGenre(String genre);

}
