package com.tecsup.demo.services;

import com.tecsup.demo.domain.entities.Curso;

import java.util.List;

public interface CursoService {
    public List<Curso> buscarPorNombre(String nombre);
    public void grabar(Curso curso);
    public void eliminar(int id);
    public Curso buscar(Integer id);
    public List<Curso> listar();
}





