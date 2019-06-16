 ## Docker Container Health Check Why ?

- Docker healthcheck is used to check the health status of the container.
- In Generally docker engine checks the process of the docker container is running or not.
- But docker engine doesnot check the application which runnin in side the container.
- Using the docker health checks we can check the health status of the application running inside container.
- There are different ways we can apply the HEALTHCHECK of the docker container.

```
          - In Docker Compose YAML file
          - In Docker file
          - Docker Swarm Service Create/Updates
          - Docker run commands
```

- Docker engine understand the exit codes exit 1 or exit 0.
- If Healthcheck command returns the exit 0 means container is healty if it returns the 1 container is
not healthy .
- Using docker run command docker engine will not take any action on the unhealth containers.
- When using the containers with docker swarm , if container is unhealthy it try to restart the contianer.
- There are three container states ,STARTING,HEALTHY,UNHEALTHY.
- By default every 30 seconds docker checks the health of the container.
- We can check the container health check status.
```
       docker container ls
       docker container inspect
```
- Using docker container inspect we can see the last 5 health check status.
- docker service will replace the unhealthy container with new container as a new taks ,under new node.
- If we use the docker service update with HEALTHCHECK ,If docker notice that the container is no healthy it will not go the new task until this container healthy.

``` 
 docker run \
   --health-cmd="curl -f localhosr:9200/_cluster/health || false \
   --health-interval=5s \
   --health-retries=3 \
   --health-timeout=2s \
   --health-start-perios=15s \
   elasticsearch:2
   
```
The Default values are
```
  --intervals=DURATION (default: 30s) ,This specifies the every 30 seconds health check will trigger.
  --timeout=DURATION(default: 30s) , With in the 30 sec if health check doesnot returns anything it time out.
  --start-period=DURATION(default 0) , waits the longer wait period for first health check ,because some times application will take more time to boot 
  --retires=N (default: 3)
```

```  
Syntax of the healthcheck is
HEALTHCHECK curl -f http://localhost/ || false
HEALTHCHECK --timeout=2s --interval=3s --retries=3 CMD curl -f http://localhost// || exit 1
```

Example of nginx

```
FROM nginx:1.13
HEALTHCHECK --timeout=3s --interval=30s CMD curl -f http://localhost// || exit 1
```
