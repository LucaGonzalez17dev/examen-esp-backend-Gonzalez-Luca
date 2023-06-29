package com.dh.catalog.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "CatalogExchange";
    public static final String TOPIC_GUARDAR_SERIE = "com.dh.backend.guardarSerie";
    public static final String QUEUE_GUARDAR_SERIE ="queueGuardarSerie";
    public static final String TOPIC_GUARDAR_PELICULA = "com.dh.backend.guardarPelicula";
    public static final String QUEUE_GUARDAR_PELICULA ="queueGuardarPelicula";

    @Bean
    public TopicExchange appExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue queueGuardarSerie(){
        return new Queue(QUEUE_GUARDAR_SERIE);
    }

    @Bean
    public Binding topicGuardarSerie(){
        return BindingBuilder.bind(queueGuardarSerie()).to(appExchange()).with(TOPIC_GUARDAR_SERIE);

    }

    @Bean
    public Queue queueGuardarPelicula(){
        return new Queue(QUEUE_GUARDAR_PELICULA);
    }
    @Bean
    public Binding topicGuardarPelicula(){
        return BindingBuilder.bind(queueGuardarSerie()).to(appExchange()).with(TOPIC_GUARDAR_PELICULA);

    }


    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}