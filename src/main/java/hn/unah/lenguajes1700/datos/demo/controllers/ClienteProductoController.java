package hn.unah.lenguajes1700.datos.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1700.datos.demo.entities.ClienteProducto;
import hn.unah.lenguajes1700.datos.demo.services.impl.ClienteProductoServiceImpl;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api")
public class ClienteProductoController {
    
    @Autowired
    private ClienteProductoServiceImpl clienteProductoServiceImpl;

    @PostMapping("/clienteproducto/crear")
    public ClienteProducto crearClienteProducto(@RequestBody ClienteProducto clienteProducto){
        return this.clienteProductoServiceImpl.crearClienteProducto(clienteProducto);
    }

}
