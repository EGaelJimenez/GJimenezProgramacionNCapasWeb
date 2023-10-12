/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.GJimenezProgramacionNCapasWeb.controller;

import com.digis01.GJimenezProgramacionNCapasWeb.DAO.EmpresaDAOImplementation;
import com.digis01.GJimenezProgramacionNCapasWeb.JPA.Empresa;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author digis
 */
@Controller
@RequestMapping("/aseguradora")
public class AseguradoraController {

    private EmpresaDAOImplementation empresaDAOImplementation;

    @Autowired
    public AseguradoraController(EmpresaDAOImplementation empresaDAOImplementation) {
        this.empresaDAOImplementation = empresaDAOImplementation;
    }

    @GetMapping("/listado")
    public String listadoAseguradora(Model model) {
        List<Empresa> empresas = empresaDAOImplementation.GetAll();
        model.addAttribute("empresas", empresas);
        return "listadoaseguradoras";

    }

    @GetMapping("/delete/{idempresa}")
    public String Delete(@PathVariable("idempresa") int idempresa, Model model) {
        empresaDAOImplementation.Delete(idempresa);
        return "redirect:/aseguradora/listado";
    }

    @GetMapping("/form/{idempresa}")
    public String Form(@PathVariable int idempresa, Model model) {
        Empresa empresa;
        if (idempresa > 0) {
            empresa = empresaDAOImplementation.GetById(idempresa);
        } else {
            empresa = new Empresa();
        }
        model.addAttribute("empresa", empresa);
        return "formempresaeditable";

    }

    @PostMapping("/form")
    public String Update(@Valid @ModelAttribute("empresa") Empresa empresa, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "formempresaeditable";
        }

        if (empresa.getIdempresa() == 0) {
            int idempresa = empresaDAOImplementation.Add(empresa);
            if (idempresa > 0) {
                return "redirect:/aseguradora/listado";
            } else {
                model.addAttribute("error", "No se pudo agregar la empresa");
                return "formempresaeditable";
            }
        } else {
            empresaDAOImplementation.Update(empresa);
            return "redirect:/aseguradora/listado";
        }
    }

}
