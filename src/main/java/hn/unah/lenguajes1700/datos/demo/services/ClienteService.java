package hn.unah.lenguajes1700.datos.demo.services;

import java.util.List;
import java.util.Optional;


import hn.unah.lenguajes1700.datos.demo.entities.Cliente;

public interface ClienteService {
    
    public List<Cliente> obtenerClientes();

    public Cliente crearCliente(Cliente cliente);

    public Optional<Cliente> buscarClientePorDni(String dni);

    public Cliente actualizarCliente(String dni, Cliente cliente);

    public String eliminarCliente(String dni);

    public Cliente agregarProductoCliente(String dni, long codigoTipoProducto);

}
