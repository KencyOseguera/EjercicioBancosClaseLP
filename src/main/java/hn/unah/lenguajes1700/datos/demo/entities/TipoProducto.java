package hn.unah.lenguajes1700.datos.demo.entities;

import java.util.List;

//import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tipoproducto")
@Data
public class TipoProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigotipoproducto")
    private long codigoTipoProducto;

    private String descripcion;

    @Column(name = "tasainteres")
    private double tasaInteres;
    

    @OneToMany(mappedBy = "tipoproducto")
    private List<ClienteProducto> clienteProducto;
}
    