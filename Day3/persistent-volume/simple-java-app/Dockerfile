FROM docker.io/maven:3.6.3-jdk-11 as stage1
RUN mvn clean package

FROM registry.access.redhat.com/ubi8/ubi-minimal:8.6-751
COPY --from=stage1 target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app.jar" ]
