/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.GJimenezProgramacionNCapasWeb.DAO;

import com.digis01.GJimenezProgramacionNCapasWeb.JPA.Estado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digis
 */
@Repository
public class EstadoDAOImplementation implements IEstadoDAO{
    
    private EntityManager entityManager;
    
    @Autowired
    public EstadoDAOImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    @Override
    public List<Estado> GetByIdPais(int idpais){
        TypedQuery<Estado> query = entityManager.createQuery("SELECT e FROM Estado e JOIN e.pais p WHERE p.idpais = :id", Estado.class);
        query.setParameter("id",idpais);
        
        List<Estado> estados = query.getResultList();
         return estados;
    }
    
}
