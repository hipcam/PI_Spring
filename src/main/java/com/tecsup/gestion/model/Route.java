package com.tecsup.gestion.model;

import java.sql.Time;


public class Route {
	int idparadero;
	String nombre;
	String ubicacion;
	Time horapartida;
	public Route() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getIdparadero() {
		return idparadero;
	}

	public void setIdparadero(int idparadero) {
		this.idparadero = idparadero;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Time getHorapartida() {
		return horapartida;
	}
	public void setHorapartida(Time horapartida) {
		this.horapartida = horapartida;
	}

	
	public Route(int idparadero, String nombre, String ubicacion, Time horapartida) {
		super();
		this.idparadero = idparadero;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.horapartida = horapartida;
	}
	@Override
	public String toString() {
		return "Route [idparadero =" + idparadero + " + nombre=" + nombre + ", ubicacion=" + ubicacion + ", horapartida=" + horapartida
				+ "]";
	}
	
	

}
