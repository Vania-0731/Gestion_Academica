package com.tecsup.demo.services;

import com.tecsup.demo.domain.entities.Credito;
import java.util.List;

public interface CreditoService {

    List<Credito> buscarPorNombre(String nombre);

    void grabar(Credito credito);

    void eliminar(int id);

    Credito buscar(Integer id);

    List<Credito> listar();
}
