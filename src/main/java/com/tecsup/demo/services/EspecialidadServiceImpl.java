package com.tecsup.demo.services;

import com.tecsup.demo.domain.entities.Especialidad;
import com.tecsup.demo.domain.persistence.EspecialidadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    @Autowired
    private EspecialidadDao dao;

    @Override
    @Transactional
    public void grabar(Especialidad especialidad) {
        dao.save(especialidad);
    }

    @Override
    @Transactional
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Especialidad buscar(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Especialidad> listar() {
        return (List<Especialidad>) dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Especialidad> buscarPorNombre(String nombre) {
        return dao.findByNombreContainingIgnoreCase(nombre);
    }
}
