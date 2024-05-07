FROM gradle:jdk17-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:17
EXPOSE 8761
RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/railway_track_management-0.0.1-SNAPSHOT.jar /app/railway_track_management.jar

ENTRYPOINT ["java", "-jar","/app/railway_track_management.jar"]