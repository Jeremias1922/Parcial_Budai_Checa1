package com.example.serieservice.queue;

import com.example.serieservice.model.Serie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SerieSender {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    private TopicExchange topicExchange;

    private final String routingKey = "quick.orange.rabbit";



    public void sendMsg(Serie serie) {
        rabbitTemplate.convertAndSend(topicExchange.getName(), routingKey, serie);
    }

}