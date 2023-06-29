package com.dh.catalog.event;

import com.dh.catalog.config.RabbitMQConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PeliculaGuardadaEventConsumer {
    @RabbitListener(queues = RabbitMQConfig.QUEUE_GUARDAR_SERIE)
    public void listen(PeliculaGuardadaEventConsumer.Movie movie){

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Movie {
        private Long id;
        private String name;
        private String genre;
        private String urlStream;
    }
}
