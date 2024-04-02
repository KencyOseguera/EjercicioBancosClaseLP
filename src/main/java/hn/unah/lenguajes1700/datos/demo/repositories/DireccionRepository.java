package hn.unah.lenguajes1700.datos.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.unah.lenguajes1700.datos.demo.entities.Direccion;

@Repository
public interface DireccionRepository extends CrudRepository<Direccion, Integer>{
    
}
