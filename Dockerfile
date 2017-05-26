FROM openjdk:jre-alpine
ADD target/simple-micro-service-swarm.jar /opt/simple-micro-service-swarm.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/simple-micro-service-swarm.jar"]
