#FROM docker.io/maven:3.6.3-jdk-11 as stage1
#COPY src .
#COPY pom.xml .
#RUN mvn clean package spring-boot:repackage 

FROM registry.access.redhat.com/ubi8/ubi-openjdk-11
#COPY --from=stage1 target/*.jar app.jar
COPY app.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app.jar" ]
