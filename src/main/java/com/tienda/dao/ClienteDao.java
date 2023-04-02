
package com.tienda.dao;

import org.springframework.data.repository.CrudRepository;
import com.tienda.domain.Cliente;
import java.util.List;

public interface ClienteDao extends CrudRepository<Cliente, Long> {
    public List<Cliente> findByNombre(String nombre);
    public List<Cliente> findByTelefono(String telefobo);

    public List<Cliente> findByNombreOrApellidosOrTelefono(String nombre, String apellidos, String telefono);

}
