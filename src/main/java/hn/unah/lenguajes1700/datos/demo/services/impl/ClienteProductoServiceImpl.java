package hn.unah.lenguajes1700.datos.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1700.datos.demo.entities.Cliente;
import hn.unah.lenguajes1700.datos.demo.entities.ClienteProducto;
import hn.unah.lenguajes1700.datos.demo.entities.Movimientos;
import hn.unah.lenguajes1700.datos.demo.entities.TipoProducto;
import hn.unah.lenguajes1700.datos.demo.repositories.ClienteProductoRepository;
import hn.unah.lenguajes1700.datos.demo.repositories.ClienteRepository;
import hn.unah.lenguajes1700.datos.demo.repositories.MovimientoRepository;
import hn.unah.lenguajes1700.datos.demo.repositories.TipoProductoRepository;
import hn.unah.lenguajes1700.datos.demo.services.ClienteProductoService;

@Service
public class ClienteProductoServiceImpl implements ClienteProductoService{

    @Autowired
    private ClienteProductoRepository clienteProductoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TipoProductoRepository tipoProductoRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Override
    public ClienteProducto crearClienteProducto(ClienteProducto clienteProducto) {
        Cliente nvoCliente = null;
        TipoProducto tipoProducto = null;

        if(null != clienteProducto.getCliente()){
            nvoCliente = clienteProducto.getCliente();            
            this.clienteRepository.save(nvoCliente);
        }


        if(null != clienteProducto.getTipoproducto()){
            tipoProducto = clienteProducto.getTipoproducto();
            this.tipoProductoRepository.save(tipoProducto);
        }

        clienteProducto.setCliente(nvoCliente);
        clienteProducto.setTipoproducto(tipoProducto);

        ClienteProducto clienteProducto2 = this.clienteProductoRepository.save(clienteProducto);

        if(null != clienteProducto.getMovimientos()){
            for (Movimientos movimiento:clienteProducto.getMovimientos()) {
                movimiento.setClienteProducto(clienteProducto2);
                this.movimientoRepository.save(movimiento);
            }
        }

        return clienteProducto2;
    }



    
    
}
