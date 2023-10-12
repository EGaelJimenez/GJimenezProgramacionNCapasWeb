/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.GJimenezProgramacionNCapasWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author digis
 */
@Controller
public class LoginController {

    @GetMapping("/")
    public String Login(@RequestParam(name = "name", required = false, defaultValue = "Digis01") String name, Model model) {
        model.addAttribute("name", name);
        return "login";
    }

    @GetMapping("/suma")
    public String Suma(@RequestParam int num1, @RequestParam int num2, Model model) {
        model.addAttribute("suma", num1 + num2);
        return "suma";
    }

}
