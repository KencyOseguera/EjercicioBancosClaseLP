package hn.unah.lenguajes1700.datos.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1700.datos.demo.entities.Direccion;
import hn.unah.lenguajes1700.datos.demo.repositories.DireccionRepository;
import hn.unah.lenguajes1700.datos.demo.services.DireccionService;

@Service
public class DireccionServiceImpl implements DireccionService{

    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    public Direccion crearDireccion(Direccion direccion) {
        return this.direccionRepository.save(direccion);
    }
    
    

}
