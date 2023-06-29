package com.dh.catalog.event;



import com.dh.catalog.config.RabbitMQConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SerieGuardadaEventConsumer {
    @RabbitListener(queues = RabbitMQConfig.QUEUE_CATALOGO)
    public void listen(SerieGuardadaEventConsumer.SerieDto serieDto){

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class SerieDto {

        private String id;
        private String name;
        private String genre;
}
}
