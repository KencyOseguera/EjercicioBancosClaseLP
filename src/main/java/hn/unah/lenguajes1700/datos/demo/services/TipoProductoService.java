package hn.unah.lenguajes1700.datos.demo.services;

import java.util.List;

import hn.unah.lenguajes1700.datos.demo.entities.TipoProducto;

public interface TipoProductoService {

    public TipoProducto creaProducto(TipoProducto tipoProducto);

    public List<TipoProducto> obtenerTiposProductos();

    public String eliminarTipoProducto(long id);
    
} 