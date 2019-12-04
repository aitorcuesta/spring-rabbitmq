#!/bin/bash

workers=`docker ps --format "{{.Names}}" | grep -c rabbit-worker-`
messages=`curl -s -i -u guest:guest http://$1:15672/api/queues/my_vhost/myqueue | sed 's/,/\n/g' | grep '"messages"' | sed 's/"messages"://g'`
echo $workers containers working
echo $messages queued messages

# Checking for start new workers
if [ $messages -gt 10 ]; then
	docker run -d --add-host rabbitmqhost:$1 --name rabbit-worker-$((workers+1)) rabbit-worker
	echo New container rabbit-worker-$((workers+1)) started
fi

# Checking for stop workers
if [ $messages -lt 5 ] && [ $workers -gt 2 ]; then
	docker container stop rabbit-worker-$workers
	docker container prune -f
	echo Container rabbit-worker-$workers stopped
fi
