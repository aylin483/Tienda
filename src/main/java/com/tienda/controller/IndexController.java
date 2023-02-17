
package com.tienda.controller;

import com.tienda.domain.Cliente;
import com.tienda.dao.ClienteDao;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//todo es para las rutas al navegar
@Slf4j
@Controller
public class IndexController {
    
    @Autowired
    ClienteDao clienteDao;
    
    @GetMapping("/")
    public String inicio(Model model){
        //  log.info("Ahora desde MVC");
        //  model.addAttribute("Mensaje", "Hola desde el controlador");
        // Cliente cliente = new Cliente("Aylin", "Martínez Ruiz", "aylinth483@gmail.com", "86306889");
        // model.addAttribute("objetoCliente", cliente);
        //  Cliente cliente2 = new Cliente("Andy", "Martínez Ruiz", "aylinth483@gmail.com", "86306889");
        //  Cliente cliente3 = new Cliente("Payan", "Martínez Ruiz", "aylinth483@gmail.com", "86306889");
       // List<Cliente> clientes = Arrays.asList(cliente, cliente2, cliente3); 
       
       var clientes = clienteDao.findAll();
        model.addAttribute("clientes", clientes);
        return "index";
    }
}
        
    
        
    
       
    
    

