package es.aitorcuesta.rabbitmq.listener;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Listener {

	@Value("${queue.myqueue.name}")
	private String queueName;

	@Bean
	public Queue myQueue() {
		return new Queue(queueName);
	}

	@RabbitListener(queues = "${queue.myqueue.name}")
	public void listen(String message) {
		System.out.println("Annotations listener -->" + message);
	}

}
