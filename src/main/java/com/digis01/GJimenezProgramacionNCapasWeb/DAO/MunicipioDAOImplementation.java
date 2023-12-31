/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.GJimenezProgramacionNCapasWeb.DAO;

import com.digis01.GJimenezProgramacionNCapasWeb.JPA.Estado;
import com.digis01.GJimenezProgramacionNCapasWeb.JPA.Municipio;
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
public class MunicipioDAOImplementation implements IMunicipioDAO{
    
    private EntityManager entityManager;
    
    @Autowired
    public MunicipioDAOImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    @Override
    public List <Municipio> GetByIdEstado(int idestado){
        TypedQuery<Municipio> query = entityManager.createQuery("SELECT m FROM Municipio m JOIN m.estado e WHERE e.idestado = :id",Municipio.class);
        query.setParameter("id", idestado);
        
        List<Municipio> municipios = query.getResultList();
        return municipios;
    }
    
}
