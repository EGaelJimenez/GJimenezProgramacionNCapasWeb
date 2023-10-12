/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.GJimenezProgramacionNCapasWeb.service;

import com.digis01.GJimenezProgramacionNCapasWeb.entity.NumerosOperacion;
import com.digis01.GJimenezProgramacionNCapasWeb.entity.Resultado;

/**
 *
 * @author digis
 */
public interface IDemoServicio {
    Resultado Suma(NumerosOperacion numerosOperacion);
    
    Resultado Resta(NumerosOperacion numerosOperacion);
    
    Resultado Multi(NumerosOperacion numerosOperacion);
    
    Resultado Divi(NumerosOperacion numerosOperacion);
}
