package hn.unah.lenguajes1700.datos.demo.entities;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Cliente {
    
    @Id
    private String dni;

    private String nombre;

    private String apellido;

    private String correo;

    private String telefono;

    //actualizacion en cascasda
    //JoinColumn para llave foranea
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="iddireccion", referencedColumnName = "iddireccion")
    private Direccion direccion; 

    //para que sea bidireccional 
    @OneToMany(mappedBy = "cliente")    
    private List<ClienteProducto> clienteProductos;

}
