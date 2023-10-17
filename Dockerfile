FROM openjdk:17
EXPOSE 8082
ADD target/cinema-room-github-action.jar cinema-room-github-action.jar
ENTRYPOINT ["java", "-jar", "/cinema-room-github-action.jar"]
