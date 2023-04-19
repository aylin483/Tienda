
package com.tienda.service;

import com.tienda.domain.Articulo;
import com.tienda.domain.CarritoDetalle;
import java.util.List;


public interface CarritoDetalleService {
    
    public CarritoDetalle getCarritoDetalle(Long idCarrito, Articulo articulo);
    
    public List<CarritoDetalle> getCarritoDetalles(Long idCarrito); //metodos que devuelven mas de un objeto de pone el plural
    
    public void save(CarritoDetalle carritoDetalle); //salva objeto de carrito

    public void delete(CarritoDetalle carritoDetalle); //borra 1 obj

    public void deleteAll(Long idCarrito); //borra todos

}
