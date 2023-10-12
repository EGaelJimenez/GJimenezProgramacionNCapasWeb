/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.GJimenezProgramacionNCapasWeb.controller;

import com.digis01.GJimenezProgramacionNCapasWeb.DAO.EmpleadoDAOImplementation;
import com.digis01.GJimenezProgramacionNCapasWeb.DAO.EmpresaDAOImplementation;
import com.digis01.GJimenezProgramacionNCapasWeb.JPA.Empleado;
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
@RequestMapping("/empleado")
public class EmpleadoController {

    private EmpleadoDAOImplementation empleadoDAOImplementation;
    private EmpresaDAOImplementation empresaDAOImplementation;

    @Autowired
    public EmpleadoController(EmpleadoDAOImplementation empleadoDAOImplementation,
                              EmpresaDAOImplementation empresaDAOImplementation) {
        this.empleadoDAOImplementation = empleadoDAOImplementation;
        this.empresaDAOImplementation = empresaDAOImplementation;
    }

    @GetMapping("/listado")
    public String listadoEmpleados(Model model) {
        List<Empleado> empleados = empleadoDAOImplementation.GetAll();
        model.addAttribute("empleados", empleados);
        return "listadoempleados";

    }

    @GetMapping("/delete/{numeroempleado}")
    public String Delete(@PathVariable("numeroempleado") int numeroempleado, Model model) {
        empleadoDAOImplementation.Delete(numeroempleado);
        return "redirect:/empleado/listado";

    }

    @GetMapping("/form/{numeroempleado}")
    public String Form(@PathVariable int numeroempleado, Model model) {
        model.addAttribute("empresas", empresaDAOImplementation.GetAll());
        
        Empleado empleado;
        if (numeroempleado > 0) {
            empleado = empleadoDAOImplementation.GetById(numeroempleado);
        } else {
            empleado = new Empleado();
        }
        model.addAttribute("empleado", empleado);
        return "formempleadoeditable";
    }

    @PostMapping("/form")
    public String Update(@Valid @ModelAttribute("empleado") Empleado empleado, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "formempleadoeditable";
        }

        if (empleado.getNumeroempleado() == 0) {
            int numeroempleado = empleadoDAOImplementation.Add(empleado);
            if (numeroempleado > 0) {
                return "redirect:/empleado/listado";
            } else {
                model.addAttribute("error", "No se pudo agregar el empleado");
                return "formempleadoeditable";

            }
        } else {
            empleadoDAOImplementation.Update(empleado);
            return "redirect:/empleado/listado";
        }

    }

}
