package hn.unah.lenguajes1700.datos.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1700.datos.demo.entities.TipoProducto;
import hn.unah.lenguajes1700.datos.demo.services.impl.TipoProductoServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api")
public class TipoProductoController {

    @Autowired
    private TipoProductoServiceImpl tipoProductoServiceImpl;

    @PostMapping("/tipoproducto/crear")
    public TipoProducto crearTipoProducto(@RequestBody TipoProducto tipoProducto){
        return this.tipoProductoServiceImpl.creaProducto(tipoProducto);
    }

    @GetMapping({"/tipoproducto/obtener"})
    public List<TipoProducto> obtenerTiposProductos() {
        return this.tipoProductoServiceImpl.obtenerTiposProductos();
    }
}
