package es.aitorcuesta.rabbitmq.sender;

import java.util.UUID;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Sender {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		AmqpTemplate template = context.getBean(AmqpTemplate.class);
		Queue queue = context.getBean(Queue.class);
		template.convertAndSend(queue.getName(), UUID.randomUUID().toString());
				
		System.exit(0);

	}

}
