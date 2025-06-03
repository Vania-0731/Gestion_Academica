# Usamos imagen con Maven y JDK para compilar
FROM maven:3.8.6-openjdk-17-slim AS build

WORKDIR /app

# Copiamos los archivos de proyecto
COPY pom.xml .
COPY src ./src

# Compilamos y generamos el jar
RUN mvn clean package -DskipTests

# Segunda etapa: imagen más ligera con solo Java para correr el jar
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copiamos el jar generado en la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto de la app
EXPOSE 8080

# Comando para correr la app
ENTRYPOINT ["java", "-jar", "app.jar"]
