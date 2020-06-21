package com.valencia.ejercicio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.valencia.ejercicio.models.entities.Genero;
import com.valencia.ejercicio.models.services.IGeneroService;

@Controller
@RequestMapping(value="/materia")
public class GeneroController {

	@Autowired
	private IGeneroService srvGenero;
	
	@GetMapping(value="/create")
	private String save(Model model) {
		Genero genero = new Genero();
		model.addAttribute("title", "Registro de un nuevo genero");
		model.addAttribute("genero", genero);
		
		return "genero/form";
		
	}
	
	
	
	@PostMapping(value="/save")
	public String save(Genero genero, Model model) {
		this.srvGenero.save(genero);
		return "redirect:/genero/list";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Genero genero = srvGenero.findById(id);
		model.addAttribute("genero", genero);
		model.addAttribute("title","Actualizando el registro de "+ genero);	
		return "genero/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		this.srvGenero.delete(id);
		return "redirect:/genero/list";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Genero> generos = srvGenero.FindAll();
		model.addAttribute("generos", generos);
		model.addAttribute("title", "Listado de generos registradas");
		return "genero/list";
	}
	
	
}
