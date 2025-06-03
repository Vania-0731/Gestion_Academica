# 🎓 Gestión Académica - Proyecto Spring Boot

¡Bienvenidos al proyecto **Gestión Académica**! 🚀

Este proyecto es una aplicación web desarrollada con **Spring Boot** que permite gestionar alumnos, apoderados y otros datos académicos. Además, cuenta con funcionalidades de auditoría para monitorear las acciones realizadas en el sistema. 👩‍💻👨‍💻

---

## ⚙️ ¿Cómo correr el proyecto?

1. Clona este repositorio:
   ```bash
   git clone https://github.com/Vania-0731/Gestion_Academica.git
   ```

2. Navega a la carpeta del proyecto:
   ```bash
   cd Gestion_Academica
   ```

3. Asegúrate de tener instalado Java 17+ y Maven.

4. Ejecuta el proyecto con Maven:
   ```bash
   mvn spring-boot:run
   ```

5. Accede a la aplicación en tu navegador:
   ```arduino
   http://localhost:8086
   ```

## 📂 Estructura del proyecto

- `/src/main/java` — Código fuente Java.
- `/src/main/resources` — Configuraciones y recursos.
- `/src/main/resources/templates` — Plantillas Thymeleaf para vistas.
- `/src/main/resources/static` — Archivos estáticos (CSS, JS, imágenes).
- `/src/main/java/com/tecsup/demo/domain/entities` — Entidades del dominio.
- `/src/main/java/com/tecsup/demo/views` — Vistas para exportar PDFs y Excel.
- `/src/main/java/com/tecsup/demo/controllers` — Controladores Spring MVC.
- `/src/main/java/com/tecsup/demo/service` — Lógica del negocio.

## 🔐 Auditoría

El sistema cuenta con un módulo de auditoría para registrar y visualizar las acciones que realizan los usuarios dentro de la aplicación, tales como:

- Creación, actualización y eliminación de alumnos y apoderados.
- Acceso a vistas y reportes.
- Exportación de datos en PDF y Excel.

Puedes revisar estas actividades para mantener un control y seguimiento claro de las operaciones realizadas. 👀

## 📋 Funcionalidades principales

- Gestión de alumnos y apoderados.
- Exportar listas a PDF y Excel 📄📊.
- Vistas web amigables con Thymeleaf.
- Módulo de auditoría para supervisar acciones.
- Diseño modular y escalable.

## 🛠 Requisitos

- Java 17 o superior ☕
- Maven
- Base de datos configurada (ajustar en `application.properties`)
- IDE recomendado: IntelliJ IDEA, Eclipse o VSCode

## 🤝 Contribuciones

¡Las contribuciones son bienvenidas! Puedes abrir un issue o hacer un pull request para mejorar el proyecto.

## 📫 Contacto

Vania - https://github.com/Vania-0731 

¡Gracias por revisar este proyecto! 🌟
