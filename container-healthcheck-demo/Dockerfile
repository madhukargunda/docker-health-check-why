#Java 8 Base image which contains the java run time environment
FROM java:8

#Who is the maintainer of the docker files
MAINTAINER Madhukar Gunda study.pattern@gmail.com

#Expose the java port ,The instruction EXPOSE tells Docker the running container listens on specific network ports. 
EXPOSE 2222

#Add the account service jar file to container whiche we are going to create.
#This instruction copy the jar file into root of the container
#We can specify the custom path where we want to copy the jar file
ADD /target/container-healthcheck-demo.jar container-healthcheck.jar

#RUN the jar file
ENTRYPOINT ["java" ,"-jar","container-healthcheck.jar" ]