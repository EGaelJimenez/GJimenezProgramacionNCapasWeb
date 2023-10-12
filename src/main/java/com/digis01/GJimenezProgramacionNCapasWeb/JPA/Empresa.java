/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.GJimenezProgramacionNCapasWeb.JPA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 *
 * @author digis
 */
@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idempresa;
    
    @NotEmpty
    @Size(min = 1, max = 50, message = "Cadena entre 1 y 50")
    private String nombre;
    
    @NotEmpty
    @Size(min = 1, max = 50, message = "Cadena entre 1 y 50")
    private String telefono;
    
    @NotEmpty
    @Email
    @Size(min = 1, max = 254, message = "Cadena entre 1 y 254")
    private String email;  
    
    @NotEmpty
    @Size(min = 1, max = 100, message = "Cadena entre 1 y 100")
    private String direccionweb;

    public Empresa() {
    }

    public Empresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public Empresa(int idempresa, String nombre) {
        this.idempresa = idempresa;
        this.nombre = nombre;
    }

    public Empresa(int idempresa, String nombre, String telefono, String email, String direccionweb) {
        this.idempresa = idempresa;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccionweb = direccionweb;
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccionweb() {
        return direccionweb;
    }

    public void setDireccionweb(String direccionweb) {
        this.direccionweb = direccionweb;
    }
    
    
}
