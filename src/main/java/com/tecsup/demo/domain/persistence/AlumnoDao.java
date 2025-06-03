package com.tecsup.demo.domain.persistence;

import com.tecsup.demo.domain.entities.Alumno;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlumnoDao extends CrudRepository<Alumno,Integer> {
    List<Alumno> findByNombreContainingIgnoreCase(String nombre);

}
