package com.tecsup.demo.controllers;

import com.tecsup.demo.domain.entities.Credito;
import com.tecsup.demo.services.CreditoService;
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
@SessionAttributes("credito")
public class CreditoController {

    @Autowired
    private CreditoService creditoService;

    @RequestMapping(value = "/credito/listar", method = RequestMethod.GET)
    public String listarCredito(Model model) {
        model.addAttribute("creditos", creditoService.listar());
        model.addAttribute("searchAction", "/credito/buscar");
        return "credito/listar";
    }

    @GetMapping("/credito/buscar")
    public String buscarCredito(@RequestParam("q") String query, Model model) {
        List<Credito> resultados = creditoService.buscarPorNombre(query);
        model.addAttribute("creditos", resultados);
        model.addAttribute("searchAction", "/credito/buscar");
        return "credito/listar";
    }

    @RequestMapping(value = "/credito/form")
    public String crear(Map<String, Object> model) {
        Credito credito = new Credito();
        model.put("credito", credito);
        return "credito/form";
    }

    @RequestMapping(value = "/credito/form", method = RequestMethod.POST)
    public String guardar(@Valid Credito credito, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            return "credito/form";
        }
        creditoService.grabar(credito);
        status.setComplete();
        return "redirect:/credito/listar";
    }

    @RequestMapping(value = "/credito/form/{id}")
    public String editar(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
        Credito credito = null;
        if (id > 0) {
            credito = creditoService.buscar(id);
        } else {
            return "redirect:/credito/listar";
        }
        model.put("credito", credito);
        return "credito/form";
    }

    @RequestMapping(value = "/credito/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Integer id) {
        if (id > 0) {
            creditoService.eliminar(id);
        }
        return "redirect:/credito/listar";
    }

    @RequestMapping(value = "/credito/ver")
    public String ver(Model model) {
        model.addAttribute("creditos", creditoService.listar());
        model.addAttribute("titulo", "Lista de créditos");
        return "credito/ver";
    }
}
