# Fitness-dsl
This project consists of 2 components.
* Computation component - This is a DSL built using the [ANTLR4](https://github.com/antlr/antlr4) framework which helps in building of a fitness application. Many fitness applications currently being built follow a similar piece of logic. This project aims to make that easy and fluent.
* Web-service component - Exposes the DSL as a service using REST HTTP framework.

## Pre-requisites
Following tools are needed to build this project
* Git CLI
* Java8
* Maven 3.x+
* Docker (if you want to run it in a container)

## Building and running locally.
* Clone the repo
```
git clone https://github.com/venki09/fitness-dsl.git
```
* Navigate to the directory and run the maven build
```
cd fitness-dsl
mvn clean install
```
* Once the build succeeds, run the tomcat server locally
```
cd service
mvn tomcat7:run
```
* Now you can navigate to the browser and hit the following endpoints
```
# Nutrition command
localhost:8080/fitness-service/nutrition_info?food=<apple or orange>

# Exercise command
localhost:8080/fitness-service/exercise_info?distance=<distance>&unit=<miles or kilometers>&time=<time>&exercise=<ran or cycled or swam>
```

Alternatively, you could also deploy your WAR in a tomcat server and run it.

## Running as a docker container
* Build the docker image using the command
```
cd service
mvn docker:build # This will build the docker image
docker run -p 8080:8080 fitness-service # Spins up a container from the image being built in the previous step
```

## Pushing image to a docker registry
* Follow steps in https://docs.docker.com/docker-cloud/builds/push-images/

## Running the service in docker on an EC2 instance
* Create an EC2 instance.
* SSH into it.
* Install docker using `sudo yum install docker`.
* Start the docker daemon using `sudo service docker start`.
* Pull down the docker image.
* Run the docker image using.
```
docker run -p 8080:8080 <image_id> &
```
* Edit the security group to allow TCP to connect through 8080.
* Hit the service endpoints!
