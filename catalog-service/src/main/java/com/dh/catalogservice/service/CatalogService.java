package com.dh.catalogservice.service;

import com.dh.catalogservice.model.Catalog;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.repositories.MoviesRespository;
import com.dh.catalogservice.repositories.SeriesRepository;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class CatalogService implements ICatalogService {

    private MoviesRespository moviesRespository;
    private SeriesRepository seriesRepository;
    private CircuitBreakerRegistry circuitBreakerRegistry;


    @CircuitBreaker(name = "catalog", fallbackMethod = "message")
    @Retry(name = "catalogs")
    @Override
    public Catalog catalogo(String genre) {
        Catalog catalog1 = new Catalog();
        List<Serie> listSeries = seriesRepository.findAllByGenre(genre);
        List<Movie> movieList = moviesRespository.findByGenre(genre);
        catalog1.setSerieList(listSeries);
        catalog1.setMovieList(movieList);
        return catalog1;
    }


    @Override
    public Serie guardarSerie(Serie serie) {
        return seriesRepository.save(serie);
    }

    @Override
    public Movie guardarMovie(Movie movie) {
        return moviesRespository.save(movie);
    }


    private String message(CallNotPermittedException exception) {
//
        return "Error al comunicarse con el servidor";
    }




}
