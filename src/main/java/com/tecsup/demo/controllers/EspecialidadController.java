package com.tecsup.demo.controllers;

import com.tecsup.demo.domain.entities.Especialidad;
import com.tecsup.demo.services.EspecialidadService;
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
@SessionAttributes("especialidad")
@RequestMapping("/especialidad")
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping("/listar")
    public String listarEspecialidad(Model model) {
        model.addAttribute("especialidades", especialidadService.listar());
        model.addAttribute("searchAction", "/especialidad/buscar");
        return "especialidad/listar";
    }

    @GetMapping("/buscar")
    public String buscarEspecialidad(@RequestParam("q") String query, Model model) {
        List<Especialidad> resultados = especialidadService.buscarPorNombre(query);
        model.addAttribute("especialidades", resultados);
        model.addAttribute("searchAction", "/especialidad/buscar");
        return "especialidad/listar";
    }

    @GetMapping("/form")
    public String crear(Map<String, Object> model) {
        Especialidad especialidad = new Especialidad();
        model.put("especialidad", especialidad);
        return "especialidad/form";
    }

    @PostMapping("/form")
    public String guardar(@Valid Especialidad especialidad, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            return "especialidad/form";
        }

        especialidadService.grabar(especialidad);
        status.setComplete();
        return "redirect:/especialidad/listar";
    }

    @GetMapping("/form/{id}")
    public String editar(@PathVariable("id") Integer id, Map<String, Object> model) {
        Especialidad especialidad = null;
        if (id > 0) {
            especialidad = especialidadService.buscar(id);
        } else {
            return "redirect:/especialidad/listar";
        }
        model.put("especialidad", especialidad);
        return "especialidad/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        if (id > 0) {
            especialidadService.eliminar(id);
        }
        return "redirect:/especialidad/listar";
    }

    @RequestMapping(value = "/ver")
    public String verEspecialidades(Model model) {
        model.addAttribute("especialidades", especialidadService.listar());
        model.addAttribute("titulo", "Lista de especialidades");
        return "especialidad/ver";
    }
}
