package com.workedcompras.api.rabbitmq;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    @Value("${rabbitmq.queue.name-pendente}")
    private String queueName;

    @Value("${rabbitmq.routingkey}")
    private String routingkey;

    @Bean
    public Queue queue() {
        return new Queue(queueName, false);
    }

}
