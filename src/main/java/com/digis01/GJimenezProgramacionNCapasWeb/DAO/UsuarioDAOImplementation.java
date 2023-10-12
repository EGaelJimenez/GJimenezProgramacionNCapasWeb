/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.GJimenezProgramacionNCapasWeb.DAO;

import com.digis01.GJimenezProgramacionNCapasWeb.JPA.Rol;
import com.digis01.GJimenezProgramacionNCapasWeb.JPA.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author digis
 */
@Repository
public class UsuarioDAOImplementation implements IUsuarioDAO {

    private EntityManager entityManager;

    @Autowired
    public UsuarioDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Usuario> GetAll(Usuario usuario) {
        TypedQuery<Usuario> query = entityManager.createQuery(
                "FROM Usuario WHERE LOWER(TRIM(nombre)) LIKE LOWER(:nombreUser) "
                + "AND LOWER(TRIM(apellidopaterno)) LIKE LOWER(:apellidoPaternoUser) "
                + "AND LOWER(TRIM(apellidomaterno)) LIKE LOWER(:apellidoMaternoUser)", Usuario.class);

        query.setParameter("nombreUser", '%' + usuario.getNombre().trim().toLowerCase() + '%');
        query.setParameter("apellidoPaternoUser", '%' + usuario.getApellidopaterno().trim().toLowerCase() + '%');
        query.setParameter("apellidoMaternoUser", '%' + usuario.getApellidomaterno().trim().toLowerCase() + '%');

        List<Usuario> usuarios = query.getResultList();

        return usuarios;
    }

    @Override
    @Transactional
    public int Add(Usuario usuario) {
        usuario.setFechanacimiento(new Date());
//        Rol rol = new Rol();
//        rol.setIdrol(1);
//        usuario.setRol(rol);
        usuario.setStatus("Y");
        entityManager.persist(usuario);
        return usuario.getIdusuario();

    }

    @Transactional
    public void Delete(int idusuario) {
        Usuario usuario = entityManager.find(Usuario.class, idusuario);
        if (usuario != null) {
            entityManager.remove(usuario);
        }
    }

    @Override
    public Usuario GetById(int idusuarioedit) {
        TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario WHERE idusuario=:idusuarioedit", Usuario.class);
        query.setParameter("idusuarioedit", idusuarioedit);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void Update(Usuario usuario) {
        entityManager.merge(usuario);
    }
    
    @Override
    @Transactional
    public void ChangeStatus (int idusuario, boolean status){
        Usuario usuario = entityManager.find(Usuario.class, idusuario);
        
        String statusString = (status)? "Y" : "N";
        usuario.setStatus(statusString);
        
        entityManager.merge(usuario);
    }

}
