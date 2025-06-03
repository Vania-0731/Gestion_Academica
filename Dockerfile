# Etapa de build: usar Maven con OpenJDK 17
FROM maven:3.9.3-openjdk-17-slim AS build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

# Etapa de ejecución: usar Amazon Corretto 17 para correr la app
FROM amazoncorretto:17

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
