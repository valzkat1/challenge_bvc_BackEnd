package com.bvc.backend.controladores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bvc.backend.modelos.Eventos;
import com.bvc.backend.repositorios.RepoEventos;

/**
 * @author Victor Ramirez
 * Controlador tipo Rest para consumir la informacion de los eventos y almacenar los mismos.
 *
 */
@RestController
@RequestMapping("/api")
public class ControladorEventos {
	
	
	@Autowired
	RepoEventos EventoRepo;

	@GetMapping("/Eventos")
	public List<Eventos> consultaEventos(){
		
		List<Eventos> response=EventoRepo.findAll();
		return response;
	}
	
	 
	@PostMapping("/Eventos")
	Eventos EventoNuevo(@RequestBody Eventos nuevoEvento) {		
	    return EventoRepo.save(nuevoEvento);
	}
	
	
	
}
