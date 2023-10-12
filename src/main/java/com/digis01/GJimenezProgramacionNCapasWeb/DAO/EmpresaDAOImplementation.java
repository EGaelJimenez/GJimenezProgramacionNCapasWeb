/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.GJimenezProgramacionNCapasWeb.DAO;

import com.digis01.GJimenezProgramacionNCapasWeb.JPA.Empresa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
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
public class EmpresaDAOImplementation implements IEmpresaDAO {
    
    private EntityManager entityManager;
    
    @Autowired
    public EmpresaDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public List<Empresa> GetAll() {
        TypedQuery<Empresa> query = entityManager.createQuery("FROM Empresa", Empresa.class);
        List<Empresa> empresas = query.getResultList();
        
        return empresas;
    }
    
    @Override
    @Transactional
    public int Add(Empresa empresa) {
        entityManager.persist(empresa);
        return empresa.getIdempresa();
    }
    
    @Override
    public Empresa GetById(int idempresaedit) {
        TypedQuery<Empresa> query = entityManager.createQuery("FROM Empresa WHERE idempresa = :idempresaedit", Empresa.class);
        query.setParameter("idempresaedit", idempresaedit);

        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null; 
        }
    }
    
    @Override
    @Transactional
    public void Update(Empresa empresa) {
        entityManager.merge(empresa);
    }
    
    @Transactional
    public void Delete(int idempresa){
        Empresa empresa = entityManager.find(Empresa.class, idempresa);
        if(empresa != null){
            entityManager.remove(empresa);
        }
    }
}
