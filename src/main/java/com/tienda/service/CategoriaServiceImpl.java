
package com.tienda.service;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    CategoriaDao categoriaDao;
    // esto va a estar entre el controlador y categoria dao
    
    @Override
    @Transactional(readOnly = true) //se hacen para metodos de obtener datos
    public List<Categoria> getCategorias(boolean activos) {
        List<Categoria>  lista = (List<Categoria>) categoriaDao.findAll(); // 4 elemtos = 3activos y 1inactivo
       
        if(activos){ // si envian true, solo salen categorias activas
            lista.removeIf(e -> !e.isActivo()); // todos los elementos en donde e es activo sea falso, se elimina
            
        }
        return lista;
        
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }
     
 
    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.deleteById(categoria.getIdCategoria());
    }
    
    
    
}
