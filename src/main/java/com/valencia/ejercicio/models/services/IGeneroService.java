package com.valencia.ejercicio.models.services;

import java.util.List;

import com.valencia.ejercicio.models.entities.Genero;

public interface IGeneroService {
	public void save(Genero g);
	public Genero findById(Integer id);
	public void delete(Integer id);
	public List<Genero> FindAll();

}
