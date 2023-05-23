FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/app.jar app.jar
RUN mkdir "/storage"
ENTRYPOINT ["java", "-jar", "/app.jar"]
