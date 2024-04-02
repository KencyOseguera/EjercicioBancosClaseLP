package hn.unah.lenguajes1700.datos.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1700.datos.demo.entities.TipoProducto;
import hn.unah.lenguajes1700.datos.demo.repositories.TipoProductoRepository;
import hn.unah.lenguajes1700.datos.demo.services.TipoProductoService;

@Service
public class TipoProductoServiceImpl implements TipoProductoService{

    @Autowired
    private TipoProductoRepository tipoProductoRepository;


    @Override
    public TipoProducto creaProducto(TipoProducto tipoProducto) {
        return this.tipoProductoRepository.save(tipoProducto);
        
    }

    @Override
    public List<TipoProducto> obtenerTiposProductos() {
        return (List<TipoProducto>) this.tipoProductoRepository.findAll();
    }

    @Override
    public String eliminarTipoProducto(long id) {
        if (this.tipoProductoRepository.existsById(id)) {
            this.tipoProductoRepository.deleteById(id);
            return "Producto eliminado";
        } else {
            return "No existe el Producto";
        }
    }

    
}