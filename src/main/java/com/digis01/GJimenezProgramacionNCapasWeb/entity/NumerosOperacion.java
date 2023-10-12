/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.GJimenezProgramacionNCapasWeb.entity;

/**
 *
 * @author digis
 */
public class NumerosOperacion {
    
    private double numerouno;
    private double numerodos;
    
    private String nombre;

    public double getNumerouno() {
        return numerouno;
    }

    public void setNumerouno(double numerouno) {
        this.numerouno = numerouno;
    }

    public double getNumerodos() {
        return numerodos;
    }

    public void setNumerodos(double numerodos) {
        this.numerodos = numerodos;
    }

    public NumerosOperacion(double numerouno, double numerodos) {
        this.numerouno = numerouno;
        this.numerodos = numerodos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

    public NumerosOperacion() {
    }
    
    
    
}
