package com.tecsup.demo.controllers;

import com.tecsup.demo.domain.entities.Docente;
import com.tecsup.demo.services.DocenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("docente")
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @GetMapping("/listar")
    public String listarDocente(Model model) {
        model.addAttribute("docentes", docenteService.listar());
        model.addAttribute("searchAction", "/docente/buscar");
        return "docente/listar";
    }

    @GetMapping("/buscar")
    public String buscarDocente(@RequestParam("q") String query, Model model) {
        List<Docente> resultados = docenteService.buscarPorNombre(query);
        model.addAttribute("docentes", resultados);
        model.addAttribute("searchAction", "/docente/buscar");
        return "docente/listar";
    }

    @GetMapping("/form")
    public String crear(Map<String, Object> model) {
        Docente docente = new Docente();
        model.put("docente", docente);
        return "docente/form";
    }

    @PostMapping("/form")
    public String guardar(@Valid Docente docente, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            return "docente/form";
        }

        docenteService.grabar(docente);
        status.setComplete();
        return "redirect:/docente/listar";
    }

    @GetMapping("/form/{id}")
    public String editar(@PathVariable("id") Integer id, Map<String, Object> model) {
        Docente docente = null;
        if (id > 0) {
            docente = docenteService.buscar(id);
        } else {
            return "redirect:/docente/listar";
        }
        model.put("docente", docente);
        return "docente/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        if (id > 0) {
            docenteService.eliminar(id);
        }
        return "redirect:/docente/listar";
    }

    // Ver docentes (para exportar PDF/XLS u otra vista)
    @RequestMapping(value = "/ver")
    public String verDocentes(Model model) {
        model.addAttribute("docentes", docenteService.listar());
        model.addAttribute("titulo", "Lista de docentes");
        return "docente/ver";
    }


}
