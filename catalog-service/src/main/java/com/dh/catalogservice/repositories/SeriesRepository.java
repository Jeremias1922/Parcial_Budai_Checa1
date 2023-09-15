package com.dh.catalogservice.repositories;

import com.dh.catalogservice.model.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SeriesRepository extends MongoRepository<Serie, Long> {

    List<Serie> findAllByGenre(String genre);

}
