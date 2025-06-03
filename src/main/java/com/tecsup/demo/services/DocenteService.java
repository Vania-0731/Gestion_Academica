package com.tecsup.demo.services;

import com.tecsup.demo.domain.entities.Docente;
import java.util.List;

public interface DocenteService {
    public List<Docente> buscarPorNombre(String nombre);

    void grabar(Docente docente);

    void eliminar(int id);

    Docente buscar(Integer id);

    List<Docente> listar();
}
