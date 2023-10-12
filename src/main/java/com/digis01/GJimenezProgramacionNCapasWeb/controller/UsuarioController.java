/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.GJimenezProgramacionNCapasWeb.controller;

import com.digis01.GJimenezProgramacionNCapasWeb.DAO.ColoniaDAOImplementation;
import com.digis01.GJimenezProgramacionNCapasWeb.DAO.DireccionDAOImplementation;
import com.digis01.GJimenezProgramacionNCapasWeb.DAO.EstadoDAOImplementation;
import com.digis01.GJimenezProgramacionNCapasWeb.DAO.MunicipioDAOImplementation;
import com.digis01.GJimenezProgramacionNCapasWeb.DAO.PaisDAOImplementation;
import com.digis01.GJimenezProgramacionNCapasWeb.DAO.RolDAOImplementation;
import com.digis01.GJimenezProgramacionNCapasWeb.DAO.UsuarioDAOImplementation;
import com.digis01.GJimenezProgramacionNCapasWeb.JPA.Colonia;
import com.digis01.GJimenezProgramacionNCapasWeb.JPA.Direccion;
import com.digis01.GJimenezProgramacionNCapasWeb.JPA.Estado;
import com.digis01.GJimenezProgramacionNCapasWeb.JPA.Municipio;
import com.digis01.GJimenezProgramacionNCapasWeb.JPA.Rol;
import com.digis01.GJimenezProgramacionNCapasWeb.JPA.Usuario;
import com.digis01.GJimenezProgramacionNCapasWeb.JPA.UsuarioDireccion;
import com.digis01.GJimenezProgramacionNCapasWeb.Util.ImageUtil;
import jakarta.validation.Valid;
import java.io.IOException;
import java.util.List;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author digis
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioDAOImplementation usuarioDAOImplementation;
    private DireccionDAOImplementation direccionDAOImplementation;
    private RolDAOImplementation rolDAOImplementation;
    private PaisDAOImplementation paisDAOImplementation;
    private EstadoDAOImplementation estadoDAOImplementation;
    private MunicipioDAOImplementation municipioDAOImplementation;
    private ColoniaDAOImplementation coloniaDAOImplementation;

    @Autowired
    public UsuarioController(UsuarioDAOImplementation usuarioDAOImplementation, 
                             DireccionDAOImplementation direccionDAOImplementation,
                             RolDAOImplementation rolDAOImplementation,
                             PaisDAOImplementation paisDAOImplementation,
                             EstadoDAOImplementation estadoDAOImplementation,
                             MunicipioDAOImplementation municipioDAOImplementation,
                             ColoniaDAOImplementation coloniaDAOImplementation) {
        this.usuarioDAOImplementation = usuarioDAOImplementation;
        this.direccionDAOImplementation = direccionDAOImplementation;
        this.rolDAOImplementation = rolDAOImplementation;
        this.paisDAOImplementation = paisDAOImplementation; 
        this.estadoDAOImplementation = estadoDAOImplementation;
        this.municipioDAOImplementation = municipioDAOImplementation;
        this.coloniaDAOImplementation = coloniaDAOImplementation;
    }

    @GetMapping("/listado")
    private String listadoUsuarios(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("");
        usuario.setApellidopaterno("");
        usuario.setApellidomaterno("");
        List<Usuario> usuarios = usuarioDAOImplementation.GetAll(usuario);
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("usuariobusqueda", new Usuario());
        return "listadousuarios";
    }
    
    @PostMapping("/listado")
    private String listadoUsuarios(Model model, @ModelAttribute("usuariobusqueda")Usuario usuariobusqueda) {
        List<Usuario> usuarios = usuarioDAOImplementation.GetAll(usuariobusqueda);
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("usuariobusqueda", usuariobusqueda);
        return "listadousuarios";
    }
    

    @GetMapping("/delete/{idusuario}")
    public String Delete(@PathVariable("idusuario") int idusuario, Model model) {
        usuarioDAOImplementation.Delete(idusuario);
        return "redirect:/usuario/listado";
    }

    @GetMapping("/form/{idusuario}")
    public String Form(@PathVariable int idusuario, Model model) {
//        List<Rol> roles = rolDAOImplementation.GetAll();
//        model.addAttribute("roles", roles);
        model.addAttribute("roles", rolDAOImplementation.GetAll());
        model.addAttribute("paises", paisDAOImplementation.GetAll());
        
        if (idusuario == 0) {
            model.addAttribute("usuariodireccion", new UsuarioDireccion());
            return "formusuarioeditable";
        } else {
            UsuarioDireccion usuarioDireccion = new UsuarioDireccion();
            
            usuarioDireccion.setUsuario(usuarioDAOImplementation.GetById(idusuario));
            usuarioDireccion.setDireccion(direccionDAOImplementation.GetByIdUsuario(idusuario));
            
            if (usuarioDireccion.getDireccion() != null && usuarioDireccion.getDireccion().getColonia() != null) {
                model.addAttribute("colonias", coloniaDAOImplementation.GetByIdMunicipio(usuarioDireccion.getDireccion().getColonia().getMunicipio().getIdmunicipio()));
                model.addAttribute("municipios", municipioDAOImplementation.GetByIdEstado(usuarioDireccion.getDireccion().getColonia().getMunicipio().getEstado().getIdestado()));
                model.addAttribute("estados", estadoDAOImplementation.GetByIdPais(usuarioDireccion.getDireccion().getColonia().getMunicipio().getEstado().getPais().getIdpais()));
            }
            
            model.addAttribute("usuariodireccion", usuarioDireccion);
            
            Usuario usuario = usuarioDAOImplementation.GetById(idusuario);
            model.addAttribute("usuario", usuario);
            return "formusuarioeditable";
        }
    }
    
    // VALIDACIÓN CON INFORMACIÓN DEL CLIENTE
    
//    @PostMapping("/form")
//    public String Update(@ModelAttribute UsuarioDireccion usuarioDireccion) {
//        Rol rol = new Rol();
//        rol.setIdrol(2);
//        usuarioDireccion.getUsuario().setRol(rol);
//        
//        List<Direccion> direcciones = direccionDAOImplementation.GetAll();
//        if (usuarioDireccion.getUsuario().getIdusuario() > 0) {
//            usuarioDAOImplementation.Update(usuarioDireccion.getUsuario());
//        } else {
//            int idusuario = usuarioDAOImplementation.Add(usuarioDireccion.getUsuario());
//            
//            usuarioDireccion.getDireccion().setUsuario(new Usuario(idusuario));
//            
//            direccionDAOImplementation.Add(usuarioDireccion.direccion);
//        }
//
//        return "redirect:/usuario/listado";
//    }
    
    
    // VALIDACIÓN CON CLIENTE Y SERVIDOR
    @PostMapping("/form")
    public String Update(@Valid @ModelAttribute("usuariodireccion") UsuarioDireccion usuarioDireccion, 
            BindingResult bindingResult,
            @RequestParam("imagenFile") MultipartFile imagenFile,
            Model model) {

                String imagenBase64 = ImageUtil.codificacionImagen(imagenFile);
                usuarioDireccion.getUsuario().setImagen(imagenBase64);

        if (bindingResult.hasErrors()) {

            model.addAttribute("usuariodireccion", usuarioDireccion);
            return "formusuarioeditable";
        }
        if (usuarioDireccion.getUsuario().getIdusuario() > 0) {//UPDATE
            usuarioDAOImplementation.Update(usuarioDireccion.getUsuario());
        } else {
            int idusuario = usuarioDAOImplementation.Add(usuarioDireccion.getUsuario());

            usuarioDireccion.getDireccion().setUsuario(new Usuario(idusuario));

            direccionDAOImplementation.Add(usuarioDireccion.direccion);
        }
        return "redirect:/usuario/listado";

    }
    
    @GetMapping("/GetEstadoByIdPais")
    @ResponseBody
    public List<Estado> GetEstadoByIdPais(@RequestParam("idpais")int idpais){
        List<Estado> estados = estadoDAOImplementation.GetByIdPais(idpais);
        return estados;
    }
    
    @GetMapping("/GetMunicipioByIdEstado")
    @ResponseBody
    public List<Municipio> GetMunicipioByIdEstado(@RequestParam("idestado")int idestado){
        List<Municipio> municipios = municipioDAOImplementation.GetByIdEstado(idestado);
        return municipios;
    }
    
    @GetMapping("/GetColoniaByIdMunicipio")
    @ResponseBody
    public List<Colonia>GetColoniaByIdMunicipio(@RequestParam("idmunicipio")int idmunicipio){
        List<Colonia> colonias = coloniaDAOImplementation.GetByIdMunicipio(idmunicipio);
        return colonias;
    }
    
    @GetMapping("/ChangeStatus")
    @ResponseBody
    public void ChangeStatus(@RequestParam("idusuario")int idusuario, @RequestParam("status")boolean status){
        usuarioDAOImplementation.ChangeStatus(idusuario, status);
    }
    
    
    

    //    @GetMapping("/add")
//    public String Add(Model model) {
//        model.addAttribute("usuario", new Usuario());
//        return "formusuario";
//    }
//    @PostMapping("/addusuario")
//    public String Add(@ModelAttribute Usuario usuario) {
//        usuarioDAOImplementation.Add(usuario);
//        return "redirect:/usuario/listado";
//
//    }
}
