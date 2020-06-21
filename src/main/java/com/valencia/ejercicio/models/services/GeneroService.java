package com.valencia.ejercicio.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valencia.ejercicio.models.dao.IGenero;
import com.valencia.ejercicio.models.entities.Genero;

@Service
public class GeneroService implements IGeneroService {

	@Autowired
	private IGenero dao;
	
	@Override
	@Transactional
	public void save(Genero g) {
		dao.save(g);
	}

	@Override
	@Transactional
	public Genero findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Genero> FindAll() {
		return (List<Genero>) dao.findAll();
	}

	
}
