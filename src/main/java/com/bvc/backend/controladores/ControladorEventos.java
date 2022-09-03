package com.bvc.backend.controladores;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		public ResponseEntity<List<Eventos>> getAllEventos(@RequestParam(required = false) String origenevento) {		
		List<Eventos> even = new ArrayList<Eventos>();
		if (origenevento == null)
			EventoRepo.findAll().forEach(even::add);
		else
			EventoRepo.findByOrigeneventoContaining(origenevento).forEach(even::add);
		//List<Eventos> response=EventoRepo.findAll();
		if (even.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(even, HttpStatus.OK);
		//return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	@GetMapping("/Eventos/fecha")
	//public List<Eventos> consultaEventos(){
		public ResponseEntity<List<Eventos>> getEventosFecha(@RequestParam(required = false) String fecha) {		
		List<Eventos> even = new ArrayList<Eventos>();
		if (fecha == null)
			EventoRepo.findAll().forEach(even::add);
		else
			//EventoRepo.findByOrigeneventoContaining(origenevento).forEach(even::add);
		    EventoRepo.findByFechaContaining(fecha).forEach(even::add);
		//List<Eventos> response=EventoRepo.findAll();
		if (even.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(even, HttpStatus.OK);
		//return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	//@CrossOrigin(origins = "*") 
	@PostMapping("/Eventos")
	public ResponseEntity<Eventos> createEvento(@RequestBody Eventos evento) {
		
		System.out.println(evento.toString()+"*******");
		
		try {
			if(evento.getTipoevento().equals("F001")) {
			 evento.setTotal(evento.getCantidad()*20.5);
			}else if(evento.getTipoevento().equals("F002")) {
			 evento.setTotal(evento.getCantidad()*200);
			}else if(evento.getTipoevento().equals("F003")) {
				evento.setTotal(evento.getCantidad()*55.9);
			}else if(evento.getTipoevento().equals("F004")) {
				evento.setTotal(evento.getCantidad()*100);
			}else if(evento.getTipoevento().equals("F005")) {
				evento.setTotal(evento.getCantidad()*32);
			}
			
			evento.setFecha(new Date());
			Eventos _eve = EventoRepo
					.save(evento);
			
			
			
			return new ResponseEntity<>(_eve, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
   // @CrossOrigin(origins = "*")
	@GetMapping("/Eventos/{id}")
	public ResponseEntity<Eventos> getEventoById(@PathVariable("id") long id) {
		Optional<Eventos> eventosData = EventoRepo.findById(id);

		if (eventosData.isPresent()) {
			return new ResponseEntity<>(eventosData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

    
  	//@CrossOrigin(origins = "*")
	@PutMapping("/Eventos/{id}")
	public ResponseEntity<Eventos> updateEvento(@PathVariable("id") long id, @RequestBody Eventos eves) {
		Optional<Eventos> evenData = EventoRepo.findById(id);

		System.out.println(eves.toString()+"*****");
		
		if (evenData.isPresent()) {
			Eventos eve = evenData.get();
			eve.setCantidad(eves.getCantidad());
			eve.setOrigenevento(eves.getOrigenevento());
			eve.setTipoevento(eves.getTipoevento());
			if(eves.getTipoevento().equals("F001")) {
				 eve.setTotal(eves.getCantidad()*20.5);
				}else if(eves.getTipoevento().equals("F002")) {
				 eve.setTotal(eves.getCantidad()*200);
				}else if(eves.getTipoevento().equals("F003")) {
					eve.setTotal(eves.getCantidad()*55.9);
				}else if(eves.getTipoevento().equals("F004")) {
					eve.setTotal(eves.getCantidad()*100);
				}else if(eves.getTipoevento().equals("F005")) {
					eve.setTotal(eves.getCantidad()*32);
				}	
			
			//eve.setFecha(eves.getFecha());
			return new ResponseEntity<>(EventoRepo.save(eve), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
    
    
  	
  	//@CrossOrigin(origins = "*")
	@DeleteMapping("/Eventos/{id}")
	public ResponseEntity<HttpStatus> deleteEvento(@PathVariable("id") long id) {
		try {
			EventoRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
  	
  	
}
