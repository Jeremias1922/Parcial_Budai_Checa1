package com.dh.catalogservice.client;

import com.dh.catalogservice.feing.FeingConfiguration;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(name= "serie-service")
@LoadBalancerClient(name = "serie-service", configuration = FeingConfiguration.class)

public interface ISerieClient {

    @GetMapping("/api/v1/serie/getAll")
    ResponseEntity<List<Serie>> getAll(@RequestBody Serie serie);

    @GetMapping("/api/v1/serie/{genre}")
    ResponseEntity<List<Serie>> getSeriesBygGenre(@PathVariable Serie serie);

    @PostMapping
    ResponseEntity<Serie> create(@RequestBody Serie serie);

}
