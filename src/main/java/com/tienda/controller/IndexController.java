package com.tienda.controller;

import com.tienda.dao.UsuarioDao;
import com.tienda.domain.CarritoDetalle;
import com.tienda.domain.Usuario;
import com.tienda.service.ArticuloService;
import com.tienda.service.CarritoDetalleService;
import com.tienda.service.CarritoService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//todo es para las rutas al navegar
@Slf4j
@Controller
public class IndexController {

    @Autowired
    ArticuloService articuloService;

    @Autowired
    UsuarioDao usuarioDao;

    @Autowired
    CarritoDetalleService carritoDetalleService;
    
    
    @GetMapping("/")
    public String inicio(Model model) {

        // Obtener el usuario lgueado
        var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails user = null;

        if (principal instanceof UserDetails) {
            user = (UserDetails) principal;

        }
        //validad si está logueado y si es usuario de un cliente
        boolean esCliente = false;

        //validar si es un usuario logueado
        if (user != null) {
            // consultar los detalles del usuario
            Usuario usuario = usuarioDao.findByUsername(user.getUsername());

            // validar si el usuario es de un cliente
            if (usuario.getIdCliente() != null && usuario.getIdCliente() != 0) {
                esCliente = true;
                //guardamos la sesion los valores importados

                // consutar itmes de carrito
                
            }
        }

        var articulos = articuloService.getArticulos(true);
        model.addAttribute("articulos", articulos);
        
        return "index";
    }
}
