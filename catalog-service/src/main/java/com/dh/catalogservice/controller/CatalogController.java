package com.dh.catalogservice.controller;
import com.dh.catalogservice.client.IMovieClient;
import com.dh.catalogservice.client.ISerieClient;
import com.dh.catalogservice.model.Catalog;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class CatalogController {
    @Autowired
    private  IMovieClient iMovieClient;
    private ISerieClient iSerieClient;

    private CatalogService catalogService;

    @GetMapping("catalog/{genre}")
     ResponseEntity<Catalog> getMovieListByGenre (@PathVariable String genre){
        return ResponseEntity.ok(catalogService.catalogo(genre))  ;
    }

    @PostMapping("catalog/save")
    ResponseEntity<Movie> saveMovie (@RequestBody Movie movie){
        return  iMovieClient.saveMovie(movie);
    }


    @PostMapping("catalog/create")
    ResponseEntity<Serie> create (@RequestBody Serie serie){ return iSerieClient.create(serie) ; }

}


