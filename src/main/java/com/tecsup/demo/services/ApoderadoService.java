package com.tecsup.demo.services;

import com.tecsup.demo.domain.entities.Apoderado;
import java.util.List;

public interface ApoderadoService {

    List<Apoderado> buscarPorNombre(String nombre);

    void grabar(Apoderado apoderado);

    void eliminar(int id);

    Apoderado buscar(Integer id);

    List<Apoderado> listar();
}
