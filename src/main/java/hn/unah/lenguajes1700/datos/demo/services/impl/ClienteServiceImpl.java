package hn.unah.lenguajes1700.datos.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1700.datos.demo.entities.Cliente;
import hn.unah.lenguajes1700.datos.demo.entities.ClienteProducto;
import hn.unah.lenguajes1700.datos.demo.repositories.ClienteProductoRepository;
import hn.unah.lenguajes1700.datos.demo.repositories.ClienteRepository;
import hn.unah.lenguajes1700.datos.demo.repositories.TipoProductoRepository;
import hn.unah.lenguajes1700.datos.demo.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TipoProductoRepository tipoProductoRepository;

    @Autowired
    private ClienteProductoRepository clienteProductoRepository;

    @Override
    public List<Cliente> obtenerClientes() {
        return (List<Cliente>) this.clienteRepository.findAll();
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> buscarClientePorDni(String dni) {
        return this.clienteRepository.findById(dni);
    }

    @Override
    public Cliente actualizarCliente(String dni, Cliente cliente) {
        Cliente clienteActualizar = this.clienteRepository.findById(dni).get();

        if(null != clienteActualizar){
            clienteActualizar.setCorreo(cliente.getCorreo());
            clienteActualizar.setApellido(cliente.getApellido());
            clienteActualizar.setNombre(cliente.getNombre());
            this.clienteRepository.save(clienteActualizar);
        }

        return clienteActualizar;
    }

    @Override
    public String eliminarCliente(String dni) {

        if(this.clienteRepository.existsById(dni)){
            this.clienteRepository.deleteById(dni);
            return "Cliente eliminado";
        }        

        return "No existe el cliente";
    }

    @Override
    public Cliente agregarProductoCliente(String dni, long codigoTipoProducto) {
        if(this.clienteRepository.existsById(dni)){
            Cliente clienteActualizar = this.clienteRepository.findById(dni).get();
            if(this.tipoProductoRepository.existsById(codigoTipoProducto)){
                ClienteProducto nvoClienteProducto = new ClienteProducto();
                nvoClienteProducto.setEstado('A');
                nvoClienteProducto.setSaldo(5000);
                nvoClienteProducto.setCliente(this.clienteRepository.findById(dni).get());
                nvoClienteProducto.setTipoproducto(this.tipoProductoRepository.findById(codigoTipoProducto).get());


                clienteActualizar.getClienteProductos().add(nvoClienteProducto);
                this.clienteProductoRepository.save(nvoClienteProducto);
                return clienteActualizar;
                /* 
                this.clienteProductoRepository.save(nvoClienteProducto);
                return nvoClienteProducto.getCliente();*/
            }
        }

        return null;
    }
    
}
