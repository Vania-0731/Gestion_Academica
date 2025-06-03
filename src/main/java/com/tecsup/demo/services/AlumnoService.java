package com.tecsup.demo.services;

import com.tecsup.demo.domain.entities.Alumno;
import java.util.List;

public interface AlumnoService {
    public List<Alumno> buscarPorNombre(String nombre);
    void grabar(Alumno alumno);
    void eliminar(int id);
    Alumno buscar(Integer id);
    List<Alumno> listar();
}
