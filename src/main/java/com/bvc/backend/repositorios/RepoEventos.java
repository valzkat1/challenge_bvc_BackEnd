package com.bvc.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bvc.backend.modelos.Eventos;

public interface RepoEventos extends JpaRepository<Eventos, Long>{

}
