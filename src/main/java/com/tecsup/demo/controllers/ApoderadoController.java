package com.tecsup.demo.controllers;

import com.tecsup.demo.domain.entities.Apoderado;
import com.tecsup.demo.services.ApoderadoService;
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
@SessionAttributes("apoderado")
public class ApoderadoController {

    @Autowired
    private ApoderadoService apoderadoService;

    // Listar apoderados
    @RequestMapping(value = "/apoderado/listar", method = RequestMethod.GET)
    public String listarApoderado(Model model) {
        model.addAttribute("apoderados", apoderadoService.listar());
        model.addAttribute("searchAction", "/apoderado/buscar");
        return "apoderado/listar";
    }

    // Buscar apoderados por nombre
    @GetMapping("/apoderado/buscar")
    public String buscarApoderado(@RequestParam("q") String query, Model model) {
        List<Apoderado> resultados = apoderadoService.buscarPorNombre(query);
        model.addAttribute("apoderados", resultados);
        model.addAttribute("searchAction", "/apoderado/buscar");
        return "apoderado/listar";
    }

    // Formulario para crear apoderado
    @RequestMapping(value = "/apoderado/form")
    public String crear(Map<String, Object> model) {
        Apoderado apoderado = new Apoderado();
        model.put("apoderado", apoderado);
        return "apoderado/form";
    }

    // Guardar apoderado (POST)
    @RequestMapping(value = "/apoderado/form", method = RequestMethod.POST)
    public String guardar(@Valid Apoderado apoderado, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            return "apoderado/form";
        }
        apoderadoService.grabar(apoderado);
        status.setComplete();
        return "redirect:/apoderado/listar";
    }

    // Formulario para editar apoderado
    @RequestMapping(value = "/apoderado/form/{id}")
    public String editar(@PathVariable("id") Integer id, Map<String, Object> model) {
        Apoderado apoderado = null;
        if (id > 0) {
            apoderado = apoderadoService.buscar(id);
        } else {
            return "redirect:/apoderado/listar";
        }
        model.put("apoderado", apoderado);
        return "apoderado/form";
    }

    // Eliminar apoderado
    @RequestMapping(value = "/apoderado/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        if (id > 0) {
            apoderadoService.eliminar(id);
        }
        return "redirect:/apoderado/listar";
    }

    // Ver apoderados (vista alternativa)
    @RequestMapping(value = "/apoderado/ver")
    public String ver(Model model) {
        model.addAttribute("apoderados", apoderadoService.listar());
        model.addAttribute("titulo", "Lista de apoderados");
        return "apoderado/ver";
    }
}
