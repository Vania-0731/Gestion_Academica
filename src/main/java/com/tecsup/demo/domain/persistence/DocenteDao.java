package com.tecsup.demo.domain.persistence;

import com.tecsup.demo.domain.entities.Docente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DocenteDao extends CrudRepository<Docente, Integer> {
    List<Docente> findByNombreContainingIgnoreCase(String nombre);

}
