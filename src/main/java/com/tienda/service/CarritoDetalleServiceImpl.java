
package com.tienda.service;

import com.tienda.domain.Articulo;
import com.tienda.domain.CarritoDetalle;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoDetalleServiceImpl implements CarritoDetalleService {
    
    @Autowired
    CarritoDetalleDao carritoDetalleDao;
    

    @Override
    public CarritoDetalle getCarritoDetalle(Long idCarrito, Articulo articulo) {
        
        return null;
        
    }

    @Override
    public List<CarritoDetalle> getCarritoDetalles(Long idCarrito) {
        
        return null;
        
    }

    @Override
    public void save(CarritoDetalle carritoDetalle) {
        
    }

    @Override
    public void delete(CarritoDetalle carritoDetalle) {
    }

    @Override
    public void deleteAll(Long idCarrito) {
    }
    
}
 