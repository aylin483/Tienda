
package com.tienda.service;

import com.tienda.domain.Cliente;
import java.util.List;

//métodos
public interface ClienteService {
    public List<Cliente> getClientes(); // para obtener todos los clientes
    
    public Cliente getCliente(Cliente cliente);
    
    public void save(Cliente cliente); //para insertar, salvar, modificar, no retorna nada ( si viene l idCliente o no)

    public void delete(Cliente cliente); //´para eliminar
    
}
