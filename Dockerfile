FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY ClientAPI/pom.xml .
COPY ClientAPI/src ./src
RUN mvn -f pom.xml clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8070
ENTRYPOINT ["java", "-jar", "app.jar"]