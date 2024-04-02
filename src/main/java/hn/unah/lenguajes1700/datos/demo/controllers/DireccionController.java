package hn.unah.lenguajes1700.datos.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1700.datos.demo.entities.Direccion;
import hn.unah.lenguajes1700.datos.demo.services.impl.DireccionServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class DireccionController {
    
    @Autowired
    private DireccionServiceImpl direccionServiceImpl;

    @PostMapping("/direccion/crear")
    public Direccion postMethodName(@RequestBody Direccion direccion) {
        return this.direccionServiceImpl.crearDireccion(direccion);
    }
    

}
