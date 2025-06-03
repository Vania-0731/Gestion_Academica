package com.tecsup.demo.controllers;

import com.tecsup.demo.domain.entities.Alumno;
import com.tecsup.demo.services.AlumnoService;
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
@SessionAttributes("alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    // Listar alumnos
    @RequestMapping(value = "/alumno/listar", method = RequestMethod.GET)
    public String listarAlumno(Model model) {
        model.addAttribute("alumnos", alumnoService.listar());
        model.addAttribute("searchAction", "/alumno/buscar");
        return "alumno/listaralumno";
    }

    @GetMapping("/alumno/buscar")
    public String buscarAlumno(@RequestParam("q") String query, Model model) {
        List<Alumno> resultados = alumnoService.buscarPorNombre(query);
        model.addAttribute("alumnos", resultados);
        model.addAttribute("searchAction", "/alumno/buscar"); // Para que el form en el header tenga el action correcto
        return "alumno/listaralumno";  // Retorna la vista que lista los alumnos
    }


    // Formulario para crear alumno
    @RequestMapping(value = "/alumno/form")
    public String crear(Map<String, Object> model) {
        Alumno alumno = new Alumno();
        model.put("alumno", alumno);
        return "alumno/formalumno";
    }

    // Guardar alumno (POST)
    @RequestMapping(value = "/alumno/form", method = RequestMethod.POST)
    public String guardar(@Valid Alumno alumno, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            return "alumno/formalumno";
        }
        alumnoService.grabar(alumno);
        status.setComplete();
        return "redirect:/alumno/listar";
    }

    // Formulario para editar alumno
    @RequestMapping(value = "/alumno/form/{id}")
    public String editar(@PathVariable("id") Integer id, Map<String, Object> model) {
        Alumno alumno = null;
        if (id > 0) {
            alumno = alumnoService.buscar(id);
        } else {
            return "redirect:/alumno/listar";
        }
        model.put("alumno", alumno);
        return "alumno/formalumno";
    }

    // Eliminar alumno
    @RequestMapping(value = "/alumno/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        if (id > 0) {
            alumnoService.eliminar(id);
        }
        return "redirect:/alumno/listar";
    }

    // Ver alumnos (para exportar PDF/XLS u otra vista)
    @RequestMapping(value = "/alumno/ver")
    public String ver(Model model) {
        model.addAttribute("alumnos", alumnoService.listar());
        model.addAttribute("titulo", "Lista de alumnos");
        return "alumno/ver";
    }
}
