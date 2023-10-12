/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.GJimenezProgramacionNCapasWeb.restController;

import com.digis01.GJimenezProgramacionNCapasWeb.DAO.UsuarioDAOImplementation;
import com.digis01.GJimenezProgramacionNCapasWeb.JPA.Usuario;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digis
 */
@RestController
@RequestMapping("/usuarioAPI")
public class UsuarioRestController {
    
    private UsuarioDAOImplementation usuarioDAOImplementation;
    
    public UsuarioRestController(UsuarioDAOImplementation usuarioDAOImplementation){
        this.usuarioDAOImplementation = usuarioDAOImplementation;
    }
    
    @GetMapping("/GetAll")
    public ResponseEntity <List<Usuario>> GetAll(){
        List<Usuario> usuarios = usuarioDAOImplementation.GetAll(new Usuario("","",""));
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
    
    @PostMapping("/Add")
    public ResponseEntity<Integer> Add(Usuario usuario){
        
        int usuarioAdd = usuarioDAOImplementation.Add(usuario);
        
        if(usuarioAdd > 0){
            return new ResponseEntity<>(usuarioAdd,HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
