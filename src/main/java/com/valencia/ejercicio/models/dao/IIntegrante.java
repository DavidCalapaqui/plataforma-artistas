package com.valencia.ejercicio.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.valencia.ejercicio.models.entities.Integrante;


public interface IIntegrante extends CrudRepository<Integrante, Integer> {

}
