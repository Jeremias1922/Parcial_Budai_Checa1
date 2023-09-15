package com.dh.catalogservice.queue;

import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.service.CatalogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MovieListener {

    private final CatalogService service;

    public MovieListener(CatalogService service) {
        this.service = service;
    }

    @RabbitListener(queues = {"${queue.movie1.name}"})
    public void receive(@Payload Movie movie1) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.guardarMovie(movie1);
    }
}

