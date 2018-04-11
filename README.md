# fitness-dsl
DSL for fitness apps development

## Pushing image to docker registry
* Follow steps in https://docs.docker.com/docker-cloud/builds/push-images/

## Running the service in docker on an EC2 instance
* Create an EC2 instance
* SSH into it
* Install docker using `sudo yum install docker`
* Start the docker daemon using `sudo service docker start`
* Pull down the docker image
* Run the docker image using
```
docker run -p 8080:8080 <image_id> &
```
* Edit the security group to allow TCP to connect through 8080.
* Hit the service
