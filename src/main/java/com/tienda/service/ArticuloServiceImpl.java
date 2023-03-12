
package com.tienda.service;

import com.tienda.dao.ArticuloDao;
import com.tienda.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ArticuloServiceImpl implements ArticuloService {
    @Autowired
    ArticuloDao articuloDao;
    // esto va a estar entre el controlador y articulo dao
    
    @Override
    @Transactional(readOnly = true) //se hacen para metodos de obtener datos
    public List<Articulo> getArticulos(boolean activos) {
        List<Articulo>  lista = (List<Articulo>) articuloDao.findAll(); // 4 elemtos = 3activos y 1inactivo
       
        if(activos){ // si envian true, solo salen articulos activas
            lista.removeIf(e -> !e.isActivo()); // todos los elementos en donde e es activo sea falso, se elimina
            
        }
        return lista;
        
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }
     
 
    @Override
    @Transactional
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {
        articuloDao.deleteById(articulo.getIdArticulo());
    }
    
    
    
}
