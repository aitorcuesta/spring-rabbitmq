package es.aitorcuesta.rabbitmq.listener;

public class Listener {

	public void listen(String message) {
		System.out.println("XML listener -->" + message);
	}

}
