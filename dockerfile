 FROM amazoncorretto:17
 WORKDIR ./app
 COPY ./target/rest.api-0.0.1-SNAPSHOT.jar /app/rest.api-0.0.1-SNAPSHOT.jar
 EXPOSE 1010
 ENTRYPOINT ["java", "-jar", "/app/rest.api-0.0.1-SNAPSHOT.jar"]