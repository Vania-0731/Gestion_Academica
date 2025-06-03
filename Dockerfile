# Imagen base oficial de Java 17 (ligera)
FROM openjdk:17-jdk-slim

# Carpeta de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo jar generado por Maven
COPY target/*.jar app.jar

# Expone el puerto que usará la app
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
