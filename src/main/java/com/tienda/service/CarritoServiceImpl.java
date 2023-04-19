
package com.tienda.service;

import com.tienda.dao.CarritoDao;
import com.tienda.domain.Carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoServiceImpl implements CarritoService{

    @Autowired
    CarritoDao carritoDao;
    
    @Override
    public Carrito getCarrito(Carrito carrito) {
        return carritoDao.findById(carrito.getIdCarrito()).orElse(null);
    }

    @Override
    public Carrito getCarritoCliente(Long idCliente) {
        // Buscmos si existe el carrito para el cliente
        Carrito carritoCliente = carritoDao.findByIdCliente(idCliente).orElse(null);
        
        // si no existe el carrito, lo creamos
        if(carritoCliente ==null) {
            Carrito carritoNuevo = new Carrito(idCliente); //idCarrito= 0, idCliente = 2
            carritoDao.save(carritoNuevo); //se guarda en base de datos
        }
        return carritoCliente;
    }
     
}
