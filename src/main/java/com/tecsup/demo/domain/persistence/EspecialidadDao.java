package com.tecsup.demo.domain.persistence;

import com.tecsup.demo.domain.entities.Especialidad;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EspecialidadDao extends CrudRepository<Especialidad, Integer> {

    List<Especialidad> findByNombreContainingIgnoreCase(String nombre);
}
