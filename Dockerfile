#
# Build stage
#
FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:17-jdk-slim
COPY --from=build /target/techtest-api-0.0.1-SNAPSHOT.jar techtest-api.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","techtest-api.jar"]