/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.GJimenezProgramacionNCapasWeb.DAO;

import com.digis01.GJimenezProgramacionNCapasWeb.JPA.Empleado;
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
public class EmpleadoDAOImplementation implements IEmpleadoDAO {

    private EntityManager entityManager;

    @Autowired
    public EmpleadoDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Empleado> GetAll() {
        TypedQuery<Empleado> query = entityManager.createQuery("FROM Empleado", Empleado.class);
        List<Empleado> empleados = query.getResultList();

        return empleados;
    }

    @Transactional
    public void Delete(int numeroempleado) {
        Empleado empleado = entityManager.find(Empleado.class, numeroempleado);
        if (empleado != null) {
            entityManager.remove(empleado);
        }
    }

    @Override
    @Transactional
    public int Add(Empleado empleado) {
        entityManager.persist(empleado);
        return empleado.getNumeroempleado();
    }

    @Override
    public Empleado GetById(int numeroempleadoedit) {
        TypedQuery<Empleado> query = entityManager.createQuery("FROM Empleado WHERE numeroempleado =:numeroempleadoedit", Empleado.class);
        query.setParameter("numeroempleadoedit", numeroempleadoedit);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;

        }
    }
    
    @Override
    @Transactional
    public void Update(Empleado empleado){
        entityManager.merge(empleado);
    }

}
