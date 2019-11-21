package es.aitorcuesta.rabbitmq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.aitorcuesta.rabbitmq.config.RabbitMQConfig;

public class Launcher {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(RabbitMQConfig.class);

	}

}
