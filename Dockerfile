# we need just those because the build will be done in another jenkins stage
FROM openjdk:17-jdk-alpine
EXPOSE 8081
ADD target/bankAccountService-0.0.1-SNAPSHOT.jar bankAccountService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/bankaccountservice.jar"]














## Use the official OpenJDK 17 image as the base image
#FROM openjdk:17-jdk-slim
#
## Set the author label
#LABEL authors="elgharras"
#
## Expose the application port
#EXPOSE 8081
#
## Create a directory for the application
#RUN mkdir -p /usr/src/app
#
## Set the working directory
#WORKDIR /usr/src/app
#
## Copy the Maven wrapper and the pom.xml file
#COPY .mvn/ .mvn
#COPY mvnw pom.xml ./
#
## Download the dependencies
#RUN ./mvnw dependency:go-offline
#
## Copy the source code
#COPY src ./src
#
## Build the application
#RUN ./mvnw clean package -DskipTests
#
## Run the application
#CMD ["java", "-jar", "target/bankAccountService-0.0.1-SNAPSHOT.jar"]