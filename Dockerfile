# Etapa de construcción: usar Maven con OpenJDK 17
FROM maven:3.8.4-openjdk-17-slim AS build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

# Etapa de ejecución: usar OpenJDK 17
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
