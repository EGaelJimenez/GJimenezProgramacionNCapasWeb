/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.GJimenezProgramacionNCapasWeb.DAO;

import com.digis01.GJimenezProgramacionNCapasWeb.JPA.Empleado;
import java.util.List;

/**
 *
 * @author digis
 */
public interface IEmpleadoDAO {
    List<Empleado> GetAll();
    
    int Add(Empleado empleado);
    
    Empleado GetById(int numeroempleadoedit);
    
    void Update(Empleado empleado);
}
