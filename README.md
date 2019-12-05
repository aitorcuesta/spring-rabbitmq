# spring-rabbitmq (docker branch)
In this branch I have added some changes to the basic-sender and the rabbitmq-spring-boot consumer to create a load balanced system on demand.

## Running RabbitMQ

For running this example you need to run a rabbitmq container setting a virtual host:

`docker run -d -p 5672:5672 -p 15672:15672 --name my-rabbit -e RABBITMQ_DEFAULT_VHOST=my_vhost rabbitmq:3-management`

 This will start a RabbitMQ container in detached mode exposing two ports:
 * 5672. Client connection port
 * 15672. Management port
 
If you need more information about running a RabbitMQ container you can go to [https://hub.docker.com/_/rabbitmq](URL)

## Sending data to RabbitMQ

### basic-sender

A simple application for sending messages to RabbitMQ. Just run the Sender class.
It has been modified to send 1000 messages. It sleeps between one and five seconds after sending a message.

## Receiving data form RabbitMQ

Just the rabbitmq-spring-boot is available

### rabbitmq-spring-boot

The same listener, but now using Spring Boot.
It has been modified to be a very slow consumer. It sleeps 10 seconds when a message is received.

#### Dockerfile

Inside docker folder there is a Dockerfile so this client can be built as a Docker image. For building this image you have to do this:

* Build the listener jar, you can run `mvn package` or similar
* Build the docker image. You have to go to the target folder and run `docker build -f ../docker/Dockerfile .`

#### Monitor file

Inside the docker folder there is a shell script file for monitoring. It must receive as first parameter the IP address where the rabbitmq is listening.

## Running the example

Make sure the rabbitmq container is running

Then start a couple of listeners:

`docker run -d --add-host rabbitmqhost:IP_ADDRESS_WHERE_RABBITMQ_IS_LISTENING --name rabbit-worker-1 rabbit-worker`

`docker run -d --add-host rabbitmqhost:IP_ADDRESS_WHERE_RABBITMQ_IS_LISTENING --name rabbit-worker-2 rabbit-worker`

Try to run the monitor.sh file (don't forget the ip_address parameter). It should print that there are two containers working and no queued messages.

Then launch the basic-sender and wait.

Then try to run regularly monitor.sh, you can use crontab or similar. It will check the number of queued messages and rabbitmq-spring-boot workers. If the number of queued messages is above 10 it starts automatically a new container, if it goes below 5 stops one worker, the minimum number of workers is two.

This is a simple demonstration about how easy is doing a round-robin load balance and adjusting the number or workers on demand using Docker and RabbitMQ.