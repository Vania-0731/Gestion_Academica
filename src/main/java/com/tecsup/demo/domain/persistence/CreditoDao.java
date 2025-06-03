package com.tecsup.demo.domain.persistence;

import com.tecsup.demo.domain.entities.Credito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditoDao extends JpaRepository<Credito, Integer> {
    List<Credito> findByNombreContainingIgnoreCase(String nombre);
}
