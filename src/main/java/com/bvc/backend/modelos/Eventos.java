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

	
	//private enum plataforma{PACTO,DEPO,BAKO,PLATGI};
	
	@Override
	public String toString() {
		return "Eventos [id=" + id + ", origenevento=" + origenevento + ", cantidad=" + cantidad + ", fecha=" + fecha
				+ ", total=" + total + ", tipoevento=" + tipoevento + "]";
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;	
	private String origenevento;
	private int cantidad;
	private Date fecha;
	private  double total;
	private String tipoevento;
	
	
	
	public String getTipoevento() {
		return tipoevento;
	}
	public void setTipoevento(String tipoevento) {
		this.tipoevento = tipoevento;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Eventos() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOrigenevento() {
		return origenevento;
	}
	public void setOrigenevento(String origenevento) {
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
