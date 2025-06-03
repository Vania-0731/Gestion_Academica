INSERT INTO cursos (nombre,creditos) VALUES('Programmer', 5);
INSERT INTO cursos (nombre,creditos) VALUES('Developer', 5);
INSERT INTO cursos (nombre,creditos) VALUES('Expert', 5);

INSERT INTO alumnos (nombre, apellido, edad, email) VALUES ('Juan', 'Pérez', 21, 'juan.perez@example.com');
INSERT INTO alumnos (nombre, apellido, edad, email) VALUES ('María', 'López', 23, 'maria.lopez@example.com');
INSERT INTO alumnos (nombre, apellido, edad, email) VALUES ('Carlos', 'Gómez', 20, 'carlos.gomez@example.com');

INSERT INTO docentes (nombre, apellido, edad, email, curso_que_dicta) VALUES ('Carlos', 'Gonzalez', 45, 'carlos.gonzalez@example.com', 'Matemáticas');
INSERT INTO docentes (nombre, apellido, edad, email, curso_que_dicta) VALUES ('Ana', 'Ramirez', 38, 'ana.ramirez@example.com', 'Física');
INSERT INTO docentes (nombre, apellido, edad, email, curso_que_dicta) VALUES ('Luis', 'Fernandez', 50, 'luis.fernandez@example.com', 'Química');
INSERT INTO docentes (nombre, apellido, edad, email, curso_que_dicta) VALUES ('María', 'Lopez', 42, 'maria.lopez@example.com', 'Literatura');
INSERT INTO docentes (nombre, apellido, edad, email, curso_que_dicta) VALUES ('Jorge', 'Martinez', 36, 'jorge.martinez@example.com', 'Historia');

INSERT INTO creditos (nombre, descripcion, valor, estado) VALUES ('Matemática Básica', 'Curso introductorio de álgebra y aritmética para estudiantes de ingeniería.', 4, true);
INSERT INTO creditos (nombre, descripcion, valor, estado) VALUES ('Comunicación Efectiva', 'Desarrollo de habilidades de expresión oral y escrita en el ámbito académico.', 3, true);
INSERT INTO creditos (nombre, descripcion, valor, estado) VALUES ('Programación I', 'Fundamentos de programación estructurada con énfasis en Java.', 5, true);
INSERT INTO creditos (nombre, descripcion, valor, estado) VALUES ('Responsabilidad Social', 'Curso sobre el impacto social de la ingeniería y proyectos comunitarios.', 2, true);
INSERT INTO creditos (nombre, descripcion, valor, estado) VALUES ('Base de Datos I', 'Diseño, modelado y normalización de bases de datos relacionales.', 4, true);
INSERT INTO creditos (nombre, descripcion, valor, estado) VALUES ('Gestión Empresarial', 'Introducción a conceptos administrativos y financieros en empresas tecnológicas.', 3, true);


INSERT INTO especialidades (nombre, descripcion, area_academica) VALUES ('Ingeniería de Software', 'Estudio del desarrollo y mantenimiento de sistemas de software.', 'Ingeniería');
INSERT INTO especialidades (nombre, descripcion, area_academica) VALUES ('Administración de Negocios', 'Formación orientada a la gestión empresarial y toma de decisiones.', 'Administración');
INSERT INTO especialidades (nombre, descripcion, area_academica) VALUES ('Enfermería', 'Preparación en el cuidado y atención integral de pacientes.', 'Salud');
INSERT INTO especialidades (nombre, descripcion, area_academica) VALUES ('Administración de Empresas', 'Enseña gestión empresarial, recursos humanos y finanzas', 'Ciencias Empresariales');
INSERT INTO especialidades (nombre, descripcion, area_academica) VALUES ('Contabilidad', 'Formación en contabilidad financiera y tributaria', 'Ciencias Empresariales');


INSERT INTO apoderados (nombre, apellido, dni, telefono, direccion) VALUES ('Juan', 'Pérez', '12345678', '987654321', 'Av. Siempre Viva 123');
INSERT INTO apoderados (nombre, apellido, dni, telefono, direccion) VALUES ('María', 'González', '87654321', '912345678', 'Calle Falsa 456');
INSERT INTO apoderados (nombre, apellido, dni, telefono, direccion) VALUES ('Carlos', 'Ramírez', '11223344', '999888777', 'Jr. Los Olivos 789');
INSERT INTO apoderados (nombre, apellido, dni, telefono, direccion) VALUES ('Luisa', 'Torres', '44332211', '987123456', 'Paseo Colón 101');
INSERT INTO apoderados (nombre, apellido, dni, telefono, direccion) VALUES ('Ana', 'Sánchez', '55667788', '976543210', 'Av. Central 202');
