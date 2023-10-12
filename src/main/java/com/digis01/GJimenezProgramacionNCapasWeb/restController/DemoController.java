/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.GJimenezProgramacionNCapasWeb.restController;

import com.digis01.GJimenezProgramacionNCapasWeb.entity.NumerosOperacion;
import com.digis01.GJimenezProgramacionNCapasWeb.entity.Resultado;
import com.digis01.GJimenezProgramacionNCapasWeb.service.DemoServiceImplementation;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digis
 */

//@RestController
//@RequestMapping("/demoApi")
public class DemoController {
    
//    @PostMapping("/suma")
//    public Resultado suma(@RequestBody NumerosOperacion numerosOperacion){
//        DemoServiceImplementation demoServiceImplementation = new DemoServiceImplementation();
//        return demoServiceImplementation.Suma(numerosOperacion);
//    }
//    
//    @PostMapping("/resta")
//    public Resultado resta(@RequestBody NumerosOperacion numerosOperacion){
//        DemoServiceImplementation demoServiceImplementation = new DemoServiceImplementation();
//        return demoServiceImplementation.Resta(numerosOperacion);
//    }
//    
//    @PostMapping("/multi")
//    public Resultado multi(@RequestBody NumerosOperacion numerosOperacion){
//        DemoServiceImplementation demoServiceImplementation = new DemoServiceImplementation();
//        return demoServiceImplementation.Multi(numerosOperacion);
//    }
//    
//    @PostMapping("/divi")
//    public Resultado divi(@RequestBody NumerosOperacion numerosOperacion){
//        DemoServiceImplementation demoServiceImplementation = new DemoServiceImplementation();
//        return demoServiceImplementation.Divi(numerosOperacion);
//    }
//    
//    @GetMapping("/saludo")
//    public String holaMundo(){
//        return "Hola mundo";
//    }
//    
//    @GetMapping("/saludoo")
//    public Map<String, Object> Saludo(@RequestBody NumerosOperacion numerosOperacion){
//        Map<String, Object> response = new HashMap<>();
//        response.put("Saludo", "Hola mundo" + numerosOperacion.getNombre());
//        return response;
//    }
    
}
