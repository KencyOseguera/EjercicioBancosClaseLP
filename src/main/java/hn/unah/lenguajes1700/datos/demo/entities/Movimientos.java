package hn.unah.lenguajes1700.datos.demo.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="movimientos")
@Data
public class Movimientos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmovimiento")
    private long idMovimiento;

    private double monto;
    
    private LocalDate fecha;
    
    //Relacion uno a muchos con clienteProducto
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="numeroproducto", referencedColumnName = "numeroproducto") //nombre de la llava en las tablas de la BD
    private ClienteProducto clienteProducto;

}
