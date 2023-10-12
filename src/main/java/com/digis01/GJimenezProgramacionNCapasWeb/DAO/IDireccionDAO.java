/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.GJimenezProgramacionNCapasWeb.DAO;

import com.digis01.GJimenezProgramacionNCapasWeb.JPA.Direccion;
import com.digis01.GJimenezProgramacionNCapasWeb.JPA.Usuario;
import java.util.List;

/**
 *
 * @author digis
 */
public interface IDireccionDAO {
    List<Direccion> GetAll();
    
    Direccion GetByIdUsuario (int idusuario);
    
    void Add(Direccion direccion);
}
