FROM openjdk:21
ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ADD ${JAR_FILE} demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/demo-0.0.1-SNAPSHOT.jar"]