package com.example.serieservice.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {

    @Value("${exchange.serie1.name}")
    private String serieExchange;

    @Value("${queue.serie1.name}")
    private String serieQueue;

    @Bean
    public Queue serieQueue() {
        return new Queue(serieQueue, true);
    }

    @Bean("baseQueue")
    public Queue queue1() {
        return new Queue("baseQueue", true);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(serieExchange);
    }

    @Bean
    public Binding bindingTopic(TopicExchange topic,
                                Queue serieQueue) {
        return BindingBuilder.bind(serieQueue)
                .to(topic)
                .with("*.orange.*");
    }

    @Bean
    public Binding binding1(@Qualifier("baseQueue") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("#");
    }


}