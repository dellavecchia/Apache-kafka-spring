FROM eclipse-temurin:20.0.2_9-jre-ubi9-minimal
ARG JAR_FILE=target/*jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
