FROM openjdk:17
EXPOSE 8080
#ADD bekesh/cinema-room-github-action.jar CinemaSeats-0.0.1-SNAPSHOT.jar
ADD cinema-room-github-action.jar build/libs/CinemaSeats-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "CinemaSeats-0.0.1-SNAPSHOT.jar"]

#FROM openjdk:8-jdk
#
#RUN mkdir /CinemaSeats-0.0.1-SNAPSHOT.jar
#
#COPY CinemaSeats-0.0.1-SNAPSHOT.jar /libs/CinemaSeats-0.0.1-SNAPSHOT.jar
#
#WORKDIR /CinemaSeats-0.0.1-SNAPSHOT.jar
#
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "CinemaSeats-0.0.1-SNAPSHOT.jar"]