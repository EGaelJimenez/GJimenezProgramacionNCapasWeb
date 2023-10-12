/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.GJimenezProgramacionNCapasWeb.DAO;

import com.digis01.GJimenezProgramacionNCapasWeb.JPA.Empresa;
import java.util.List;

/**
 *
 * @author digis
 */
public interface IEmpresaDAO {
    List<Empresa> GetAll();
    
    int Add(Empresa empresa);
    
    Empresa GetById(int idempresaedit);
    
    void Update (Empresa empresa);
}
