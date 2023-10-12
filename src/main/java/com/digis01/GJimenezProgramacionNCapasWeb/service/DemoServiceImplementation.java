/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.GJimenezProgramacionNCapasWeb.service;

import com.digis01.GJimenezProgramacionNCapasWeb.entity.NumerosOperacion;
import com.digis01.GJimenezProgramacionNCapasWeb.entity.Resultado;

/**
 *
 * @author digis
 */
public class DemoServiceImplementation implements IDemoServicio{
    
    @Override
    public Resultado Suma(NumerosOperacion numerosOperacion){
        return new Resultado(numerosOperacion.getNumerouno() + numerosOperacion.getNumerodos());
    }
    
    @Override
    public Resultado Resta(NumerosOperacion numerosOperacion){
        return new Resultado(numerosOperacion.getNumerouno() - numerosOperacion.getNumerodos());
    }
    
    @Override
    public Resultado Multi(NumerosOperacion numerosOperacion){
        return new Resultado(numerosOperacion.getNumerouno() * numerosOperacion.getNumerodos());
    }
    
    @Override
    public Resultado Divi(NumerosOperacion numerosOperacion){
        return new Resultado(numerosOperacion.getNumerouno() / numerosOperacion.getNumerodos());
    }
    
    
}
