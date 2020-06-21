package com.valencia.ejercicio.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.valencia.ejercicio.models.entities.Artista;
import com.valencia.ejercicio.models.entities.Genero;
import com.valencia.ejercicio.models.services.IArtistaService;
import com.valencia.ejercicio.models.services.IGeneroService;
	

@Controller
@RequestMapping(value = "/artista")
public class ArtistaController {

	@Autowired
	private IArtistaService srvArtista;
	
	@Autowired
	private IGeneroService srvGenero;
	
	@GetMapping(value = "/create")
	public String create(Model model) {
		Artista artista = new Artista();
		model.addAttribute("title", "Registro de nuevo Artista");
		model.addAttribute("artista", artista);
		
		//para el combo box de generos del artista
		List<Genero> generos = srvGenero.FindAll();
		model.addAttribute("generos",generos);

		return "artista/form";
	}

	
	@PostMapping(value="/save")
	public String save(Artista artista, Model model, @RequestParam("file") MultipartFile foto) {
		
		if(!foto.isEmpty()) {
			Path directorioRecursos = Paths.get("src//main//resources//static//uploads");
			String rootPath = directorioRecursos.toFile().getAbsolutePath();
			try {
				byte[] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "//"+foto.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				
				artista.setFoto(foto.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		}
		
		srvArtista.save(artista);
		
		return "redirect:/artista/list";	
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Artista> artistas = this.srvArtista.FindAll();
		model.addAttribute("artistas", artistas);
		model.addAttribute("title", "Listado de alumnos registrados");
		return "alumno/list";
	}
	
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Artista artista = srvArtista.findById(id);
		model.addAttribute("artista", artista 	);
		model.addAttribute("title","Actualizando el registro de "+ artista);
		return "artista/form";
	}
	
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Artista artista = this.srvArtista.findById(id);
		model.addAttribute("artista", artista);
		return "artista	/card"; 
	}
	
	
	
	
}
