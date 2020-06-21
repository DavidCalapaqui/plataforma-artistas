package com.valencia.ejercicio.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valencia.ejercicio.models.dao.IArtista;
import com.valencia.ejercicio.models.entities.Artista;


@Service
public class ArtistaService implements IArtistaService {
	@Autowired //Inyeccion de dependencia.Permite instanciar un objeto de la dao
	private IArtista dao;
	
	@Override
	@Transactional
	public void save(Artista a) {
		dao.save(a);
	}

	@Override
	@Transactional
	public Artista findById(Integer id) {		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Artista> FindAll() {
		return (List<Artista>) dao.findAll();
	}
}
