package com.valencia.ejercicio.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.valencia.ejercicio.models.entities.Cliente;

public interface ICliente extends CrudRepository<Cliente, Integer> {

}
