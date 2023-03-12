
package com.tienda.service;

import com.tienda.domain.Categoria;
import java.util.List;


public interface CategoriaService {
    public List<Categoria> getCategorias(boolean activos); // recibe parametro boleano para mandar una categoria activa si es true o inactivas y activas si es false
    
    public Categoria getCategoria(Categoria categoria);
    
    public void save(Categoria categoria); //para insertar, salvar, modificar, no retorna nada ( si viene l idCategoria o no)

    public void delete(Categoria categoria);
}
