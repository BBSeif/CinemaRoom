#FROM openjdk:17
#EXPOSE 8080
##ADD bekesh/cinema-room-github-action.jar CinemaSeats-0.0.1-SNAPSHOT.jar
##ADD cinema-room-github-action.jar build/libs/CinemaSeats-0.0.1-SNAPSHOT.jar
#ADD bekesh/cinema-room-github-action.jar cinema-room-github-action.jar
#ENTRYPOINT ["java", "-jar", "CinemaSeats-0.0.1-SNAPSHOT.jar"]

FROM openjdk:17

RUN mkdir /CinemaSeats-0.0.1-SNAPSHOT.jar

COPY build/libs/CinemaSeats-0.0.1-SNAPSHOT.jar  CinemaSeats-0.0.1-SNAPSHOT.jar

WORKDIR /app

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "CinemaSeats-0.0.1-SNAPSHOT.jar"]