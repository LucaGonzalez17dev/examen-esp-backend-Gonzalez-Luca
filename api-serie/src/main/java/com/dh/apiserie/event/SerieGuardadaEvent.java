package com.dh.apiserie.event;


import com.dh.apiserie.config.RabbitMQConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class SerieGuardadaEvent {

    private final RabbitTemplate rabbitTemplate;

    public SerieGuardadaEvent(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void guardar(SerieGuardadaEvent.SerieDto serieDto) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,RabbitMQConfig.TOPIC_GUARDAR_SERIE, serieDto);

    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SerieDto {
        private String id;
        private String name;
        private String genre;
    }
}
