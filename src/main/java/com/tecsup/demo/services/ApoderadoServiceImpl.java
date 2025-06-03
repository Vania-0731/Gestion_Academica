package com.tecsup.demo.services;

import com.tecsup.demo.domain.entities.Apoderado;
import com.tecsup.demo.domain.persistence.ApoderadoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApoderadoServiceImpl implements ApoderadoService {

    @Autowired
    private ApoderadoDao dao;

    @Override
    @Transactional
    public void grabar(Apoderado apoderado) {
        dao.save(apoderado);
    }

    @Override
    @Transactional
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Apoderado buscar(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Apoderado> listar() {
        return (List<Apoderado>) dao.findAll();
    }

    @Override
    public List<Apoderado> buscarPorNombre(String nombre) {
        return dao.findByNombreContainingIgnoreCase(nombre);
    }

}
