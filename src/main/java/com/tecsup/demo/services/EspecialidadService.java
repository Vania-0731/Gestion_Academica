package com.tecsup.demo.services;

import com.tecsup.demo.domain.entities.Especialidad;
import java.util.List;

public interface EspecialidadService {

    List<Especialidad> buscarPorNombre(String nombre);

    void grabar(Especialidad especialidad);

    void eliminar(int id);

    Especialidad buscar(Integer id);

    List<Especialidad> listar();
}
