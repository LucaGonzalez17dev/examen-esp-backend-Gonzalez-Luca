package com.dh.movie.event;

import com.dh.movie.config.RabbitMQConfig;
import com.dh.movie.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;


@Component
public class PeliculaGuardadaEvent {

    private  final RabbitTemplate rabbitTemplate;

    public PeliculaGuardadaEvent(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public  void guardarPelicula(Movie movie) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,RabbitMQConfig.TOPIC_CATALOGO, movie);
    }


}
