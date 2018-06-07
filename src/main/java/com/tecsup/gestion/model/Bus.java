package com.tecsup.gestion.model;

public class Bus {

	int idbus;
	String placa;

	
	public int getIdbus() {
		return idbus;
	}
	public void setIdbus(int idbus) {
		this.idbus = idbus;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	@Override
	public String toString() {
		return "Bus [ idbus=" + idbus + " placa=" + placa + "]";
	}
	public Bus(int idbus, String placa) {
		super();
		
		this.idbus = idbus;
		this.placa = placa;
	}
	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
