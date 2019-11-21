package es.aitorcuesta.rabbitmq.config;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:queues.properties")
@EnableRabbit
public class RabbitMQConfig {				
    
}
