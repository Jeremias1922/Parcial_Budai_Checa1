package com.dh.catalogservice.queue;

import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.service.CatalogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class SerieListener {

    private final CatalogService service;

    public SerieListener(CatalogService service) {
        this.service = service;
    }


    @RabbitListener(queues = {"${queue.serie1.name}"})
    public void receive(@Payload Serie serie1) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.guardarSerie(serie1);
    }
}
