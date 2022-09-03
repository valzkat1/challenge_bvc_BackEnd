package com.bvc.backend.controladores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bvc.backend.modelos.Eventos;
import com.bvc.backend.repositorios.RepoEventos;

/**
 * @author Victor Ramirez
 * Controlador tipo Rest para consumir la informacion de los eventos y almacenar los mismos.
 *
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ControladorEventos {
	
	
	@Autowired
	RepoEventos EventoRepo;

	@GetMapping("/Eventos")
	//public List<Eventos> consultaEventos(){
		public ResponseEntity<List<Eventos>> getAllTutorials(@RequestParam(required = false) String title) {		
		
		List<Eventos> response=EventoRepo.findAll();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	 
	@PostMapping("/Eventos")
	public ResponseEntity<Eventos> createTutorial(@RequestBody Eventos evento) {
		try {
			Eventos _eve = EventoRepo
					.save(evento);
			return new ResponseEntity<>(_eve, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
