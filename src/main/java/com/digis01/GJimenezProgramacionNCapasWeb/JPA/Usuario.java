/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.GJimenezProgramacionNCapasWeb.JPA;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;


/**
 *
 * @author digis
 */
@Entity
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idusuario;
    
    @NotEmpty
    @Size(min = 4, max = 15, message = "Cadena entre 4 y 15")
    private String username;
    
    @NotEmpty
    @Size(min = 4, max = 15, message = "Cadena entre 4 y 15")
    private String nombre;
    
    
    @NotEmpty
    @Size(min = 1, max = 15, message = "Cadena entre 1 y 15")
    private String apellidopaterno;
    
    @NotEmpty
    @Size(min = 4, max = 15, message = "Cadena entre 4 y 15")
    private String apellidomaterno;
    
    @NotEmpty
    @Email
    @Size(min = 4, max = 25, message = "Cadena entre 4 y 25")
    private String email;
    
    @NotEmpty
    @Size(min = 8, max = 25, message = "Cadena entre 8 y 25")
    private String password;
    
    @NotEmpty
    @Size(min = 1, max = 2, message = "Cadena entre 1 y 2")
    private String sexo;
    
    @NotEmpty
    @Size(min = 10, max = 12, message = "Cadena entre 10 y 12")
    private String telefono;
    
    @NotEmpty
    @Size(min = 10, max = 12, message = "Cadena entre 10 y 15")
    private String celular;
    
    @NotEmpty
    @Size(min = 18, max = 20, message = "Cadena entre 18 y 20")
    private String curp;
    
    @Lob
    private String imagen;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    
    @ManyToOne
    @JoinColumn(name = "idrol")
    private com.digis01.GJimenezProgramacionNCapasWeb.JPA.Rol rol;
    
    private String status;

    public Usuario(){
    }

    public Usuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(String nombre, String apellidopaterno, String apellidomaterno) {
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
    }

    
    
    public Usuario(String username, String nombre, String apellidopaterno, String apellidomaterno, String email, String password, String sexo, String telefono, String celular, String curp, Date fechanacimiento) {
        this.username = username;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.email = email;
        this.password = password;
        this.sexo = sexo;
        this.telefono = telefono;
        this.celular = celular;
        this.curp = curp;
        this.fechanacimiento = fechanacimiento;
    }

    public Usuario(int idusuario, String username, String nombre, String apellidopaterno, String apellidomaterno, String email, String password, String sexo, String telefono, String celular, String curp, Date fechanacimiento) {
        this.idusuario = idusuario;
        this.username = username;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.email = email;
        this.password = password;
        this.sexo = sexo;
        this.telefono = telefono;
        this.celular = celular;
        this.curp = curp;
        this.fechanacimiento = fechanacimiento;
    }

    public Usuario(int idusuario, String username, String nombre, String apellidopaterno, String apellidomaterno, String email, String password, String sexo, String telefono, String celular, String curp, Date fechanacimiento, Rol rol) {
        this.idusuario = idusuario;
        this.username = username;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.email = email;
        this.password = password;
        this.sexo = sexo;
        this.telefono = telefono;
        this.celular = celular;
        this.curp = curp;
        this.fechanacimiento = fechanacimiento;
        this.rol = rol;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
