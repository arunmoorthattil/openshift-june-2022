FROM docker.io/maven:3.6.3-jdk-11
WORDIR Day3/persistent-volume//simple-java-app 
RUN mvn clean package
COPY target/*.jar app.jar

FROM registry.access.redhat.com/ubi8/ubi-minimal:8.6-751
COPY app.jar /app.jar
ENTRYPOINT [ "java", "-jar", "/app.jar" ]
