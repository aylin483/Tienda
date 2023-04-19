
package com.tienda.controller;

import com.tienda.domain.Articulo;
import com.tienda.service.ArticuloService;
import com.tienda.service.CarritoDetalleService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CarritoController {
    
    @Autowired
    CarritoDetalleService carritoDetailsService;
    
    @Autowired
    ArticuloService articuloService;
    
    @GetMapping("/carrito/agregar/idArticulo")
    public String agregar(Articulo articulo, HttpSession session) {
        Long idCarrito = (Long) session.getAttribute("idCarrito");
        articulo = articuloService.getArticulo(articulo);
        
        // verificar si existe en el carrito del cliente
        return null;
        
        
   }
    
}

    
    
    
    

