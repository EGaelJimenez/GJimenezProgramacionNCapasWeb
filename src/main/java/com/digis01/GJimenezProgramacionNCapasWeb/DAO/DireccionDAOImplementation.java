/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.GJimenezProgramacionNCapasWeb.DAO;

import com.digis01.GJimenezProgramacionNCapasWeb.JPA.Direccion;
import com.digis01.GJimenezProgramacionNCapasWeb.JPA.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author digis
 */
@Repository
public class DireccionDAOImplementation implements IDireccionDAO{
    
    private EntityManager entityManager;
    
    @Autowired
    public DireccionDAOImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    @Override
    public List<Direccion> GetAll(){
        TypedQuery<Direccion> query = entityManager.createQuery("FROM Direccion", Direccion.class);
        List<Direccion> direcciones = query.getResultList();
        
        return direcciones;
        
    }
    
    @Override
    @Transactional
    public void Add(Direccion direccion){
        entityManager.persist(direccion);
    }
    
    @Override
    public Direccion GetByIdUsuario (int idusuario){
        TypedQuery<Direccion> query = entityManager.createQuery("FROM Direccion WHERE usuario.idusuario=:idUsuario",Direccion.class);
        query.setParameter("idUsuario", idusuario);
        Direccion direccion;
        try{
            direccion = query.getSingleResult();
        }catch(Exception ex){
            direccion = new Direccion();
        }
        
        return direccion;
        
    }
    
}
