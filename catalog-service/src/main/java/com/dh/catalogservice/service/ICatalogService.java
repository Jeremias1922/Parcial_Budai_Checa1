package com.dh.catalogservice.service;

import com.dh.catalogservice.model.Catalog;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import org.springframework.web.bind.annotation.PostMapping;

public interface ICatalogService  {

    public Catalog catalogo(String genre);
    public Serie guardarSerie(Serie serie);
    public Movie guardarMovie(Movie movie);


}
