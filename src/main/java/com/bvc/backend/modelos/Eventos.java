package com.bvc.backend.modelos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Victor Ramirez
 * Modelo para almacenamiento de eventos digitales BVC Challenge
 * Se define la plataforma de tipo Enum, junto a los atributos que han sido especificados en el documento 
 * de la prueba tecnica.
 */
@Entity
@Table(name = "eventos_digitales")
public class Eventos {

	
	private enum plataforma{PACTO,DEPO,BAKO,PLATGI};
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;	
	private plataforma origenevento;
	private int cantidad;
	private Date fecha;
	
	
	
	public Eventos() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public plataforma getOrigenevento() {
		return origenevento;
	}
	public void setOrigenevento(plataforma origenevento) {
		this.origenevento = origenevento;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
