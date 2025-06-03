package com.tecsup.demo.domain.persistence;


import com.tecsup.demo.domain.entities.Curso;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CursoDao extends CrudRepository<Curso,Integer> {
    List<Curso> findByNombreContainingIgnoreCase(String nombre);

}



