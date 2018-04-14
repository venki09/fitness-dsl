# fitness-dsl
DSL for fitness apps development

## Pre-requisites
Following tools are needed to build this project
* Git CLI
* Java8
* Maven 3.x+

## Building and running locally
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
