
package com.tienda.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    //propiedades 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente; // hibernate lo transforma en id_cliente, no hay que poner raya baja
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    
    @JoinColumn(name="id_credito", referencedColumnName = "id_credito") //para hacer joins con otra tabla, el id_credito es el que está en la base de datos
    @ManyToOne // un credito puede estar mas de una vez 
    private Credito credito;
    

    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono, Credito credito) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.credito = credito;
    }

    
    
    
}
// acceder a propiedades mediante get y sets se puede hacer con Data tambien