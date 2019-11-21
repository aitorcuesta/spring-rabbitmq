# spring-rabbitmq
Spring and RabbitMQ examples

## Running RabbitMQ with Docker

Before you can run any of these examples you need to run a RabbitMQ installation, the easiest way to do this is using Docker:

`docker run -d -p 5672:5672 -p 15672:15672 --name my-rabbit rabbitmq:3-management`

 This will start a RabbitMQ container in detached mode exposing two ports:
 * 5672. Client connection port
 * 15672. Management port
 
If you need more information about running a RabbitMQ container you can go to [https://hub.docker.com/_/rabbitmq](URL)

## Sending data to RabbitMQ

### basic-sender

A simple application for sending messages to RabbitMQ. Just run the Sender class

## Receiving data form RabbitMQ

Just run the Launcher class on all the below examples

### rabbitmq-listener-xml

A simple application that defines a RabbitMQ listener
Everything is configured using XML.

### rabbitmq-listener-annotations

Is the same listener defined above, but now is configurated via Spring `@Configuration` annotation.
Introduces the `@RabbitListener` annotation.

### rabbitmq-listener-xml-advanced

Demonstrates how to configure a `@RabbitListener` using XML.

### rabbitmq-spring-boot

The same listener, but now using Spring Boot.