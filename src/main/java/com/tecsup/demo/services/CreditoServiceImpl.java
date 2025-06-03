package com.tecsup.demo.services;

import com.tecsup.demo.domain.entities.Credito;
import com.tecsup.demo.domain.persistence.CreditoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CreditoServiceImpl implements CreditoService {

    @Autowired
    private CreditoDao dao;

    @Override
    @Transactional
    public void grabar(Credito credito) {
        dao.save(credito);
    }

    @Override
    @Transactional
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Credito buscar(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Credito> listar() {
        return (List<Credito>) dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Credito> buscarPorNombre(String nombre) {
        return dao.findByNombreContainingIgnoreCase(nombre);
    }
}
