package com.tecsup.gestion.model;




public class Pasantia {
	
	int idpasantia;
	String ubicacion;
	String nombre_empresa;
	int alumno_idalumno;
	String fecha;
	
	

	public int getIdpasantia() {
		return idpasantia;
	}
	public void setIdpasantia(int idpasantia) {
		this.idpasantia = idpasantia;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getNombre_empresa() {
		return nombre_empresa;
	}
	public void setNombre_empresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa;
	}
	public int getAlumno_idalumno() {
		return alumno_idalumno;
	}
	public void setAlumno_idalumno(int alumno_idalumno) {
		this.alumno_idalumno = alumno_idalumno;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public String toString() {
		return "Pasantia [idpasantia=" + idpasantia + ", ubicacion=" + ubicacion + ", nombre_empresa=" + nombre_empresa
				+ ", alumno_idalumno=" + alumno_idalumno + ", fecha=" + fecha + "]";
	}
	
	public Pasantia(int idpasantia, String ubicacion, String nombre_empresa, int alumno_idalumno, String fecha) {
		super();
		this.idpasantia = idpasantia;
		this.ubicacion = ubicacion;
		this.nombre_empresa = nombre_empresa;
		this.alumno_idalumno = alumno_idalumno;
		this.fecha = fecha;
	}
	public Pasantia() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
