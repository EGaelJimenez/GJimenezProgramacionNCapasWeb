/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.GJimenezProgramacionNCapasWeb.DAO;


import com.digis01.GJimenezProgramacionNCapasWeb.JPA.Rol;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digis
 */
@Repository
public interface IRolDAO {
    List<Rol> GetAll();
}
