package com.tecsup.demo.services;

import com.tecsup.demo.domain.entities.Docente;
import com.tecsup.demo.domain.persistence.DocenteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DocenteServiceImpl implements DocenteService {

    @Autowired
    private DocenteDao dao;

    @Override
    @Transactional
    public void grabar(Docente docente) {
        dao.save(docente);
    }

    @Override
    @Transactional
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Docente buscar(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Docente> listar() {
        return (List<Docente>) dao.findAll();
    }

    @Override
    public List<Docente> buscarPorNombre(String nombre) {
        return dao.findByNombreContainingIgnoreCase(nombre);
    }

}
