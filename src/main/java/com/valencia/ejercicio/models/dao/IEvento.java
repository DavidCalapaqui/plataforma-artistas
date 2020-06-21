package com.valencia.ejercicio.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.valencia.ejercicio.models.entities.Evento;

public interface IEvento extends CrudRepository<Evento, Integer>{
	
}
