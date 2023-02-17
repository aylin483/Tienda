
package com.tienda.dao;

import org.springframework.data.repository.CrudRepository;
import com.tienda.domain.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Long> {
    
}
