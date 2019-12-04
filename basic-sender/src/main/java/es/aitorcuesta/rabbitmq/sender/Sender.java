package es.aitorcuesta.rabbitmq.sender;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sender {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		AmqpTemplate template = context.getBean(AmqpTemplate.class);
		Queue queue = context.getBean(Queue.class);
		for (int i = 0; i < 1000; i++) {
			template.convertAndSend(queue.getName(), UUID.randomUUID().toString());
			Thread.sleep(ThreadLocalRandom.current().nextLong(1, 5 + 1) * 1000l);
		}

		System.exit(0);

	}

}
