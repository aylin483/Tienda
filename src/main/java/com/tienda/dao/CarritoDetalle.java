
package com.tienda.dao;

import com.tienda.domain.Articulo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;



public interface CarritoDetalle extends CrudRepository<CarritoDetalle, Long>{
    
    List<CarritoDetalle> findByIdCarrito(Long idCarrito);
    
    CarritoDetalle findByIdCarritoAndArticulo( Articulo articulo);
    
    void deleteByIdCarrito(Long idCarrito);
    
}
