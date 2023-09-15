package com.dh.movieservice.queue;

import com.dh.movieservice.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieSender {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    private TopicExchange topicExchange;

    private final String routingKey = "quick.orange.rabbit";



    public void sendMsg(Movie movie) {
        rabbitTemplate.convertAndSend(topicExchange.getName(), routingKey, movie);
    }

}