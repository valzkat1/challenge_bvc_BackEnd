package com.bvc.backend.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bvc.backend.modelos.Eventos;

public interface RepoEventos extends JpaRepository<Eventos, Long>{
	List<Eventos> findByOrigeneventoContaining(String origenevento);
	List<Eventos> findByFechaContaining(String fecha);
	
}
