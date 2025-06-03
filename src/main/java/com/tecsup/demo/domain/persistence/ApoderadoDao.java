package com.tecsup.demo.domain.persistence;

import com.tecsup.demo.domain.entities.Apoderado;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApoderadoDao extends CrudRepository<Apoderado, Integer> {
    List<Apoderado> findByNombreContainingIgnoreCase(String nombre);
}
