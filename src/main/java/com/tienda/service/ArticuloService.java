
package com.tienda.service;

import com.tienda.domain.Articulo;
import java.util.List;


public interface ArticuloService {
    public List<Articulo> getArticulos(boolean activos); // recibe parametro boleano para mandar una articulo activa si es true o inactivas y activas si es false
    
    public Articulo getArticulo(Articulo articulo);
    
    public void save(Articulo articulo); //para insertar, salvar, modificar, no retorna nada ( si viene l idArticulo o no)

    public void delete(Articulo articulo);
}
