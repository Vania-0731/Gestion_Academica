package com.tecsup.demo.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "docentes")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    @NotEmpty
    private String nombre;

    @Column
    @NotEmpty
    private String apellido;

    @Column
    @Min(22)
    @Max(70)
    private int edad;

    @Column
    @NotEmpty
    private String email;

    @Column(name = "curso_que_dicta")
    @NotEmpty(message = "El curso que dicta no puede estar vacío")
    private String cursoQueDicta;

    public Docente() {
    }

    public Docente(int id, String nombre, String apellido, int edad, String email, String cursoQueDicta) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.email = email;
        this.cursoQueDicta = cursoQueDicta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCursoQueDicta() {
        return cursoQueDicta;
    }

    public void setCursoQueDicta(String cursoQueDicta) {
        this.cursoQueDicta = cursoQueDicta;
    }

    @Override
    public String toString() {
        return "Docente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", email='" + email + '\'' +
                ", cursoQueDicta='" + cursoQueDicta + '\'' +
                '}';
    }
}
