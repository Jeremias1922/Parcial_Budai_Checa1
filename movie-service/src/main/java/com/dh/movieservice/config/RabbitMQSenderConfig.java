package com.dh.movieservice.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {

    @Value("${exchange.movie1.name}")
    private String movieExchange;

    @Value("${queue.movie1.name}")
    private String movieQueue;

    @Bean
    public Queue personaQueue() {
        return new Queue(movieQueue, true);
    }

    @Bean("baseQueue")
    public Queue queue1() {
        return new Queue("baseQueue", true);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(movieExchange);
    }

    @Bean
    public Binding bindingTopic(TopicExchange topic,
                                Queue personaQueue) {
        return BindingBuilder.bind(personaQueue)
                .to(topic)
                .with("*.orange.*");
    }

    @Bean
    public Binding binding1(@Qualifier("baseQueue") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("#");
    }


}
