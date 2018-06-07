package com.tecsup.gestion.services;

import java.sql.Date;
import java.util.List;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Pasantia;

public interface PasantiaService {
	
	Pasantia find(int idpasantia) throws DAOException, EmptyResultException;

	List<Pasantia> findAll() 
			throws DAOException, EmptyResultException;
	
	public void create(String ubicacion, String nombre_emp, int id_alumno, String fecha) throws DAOException;

	public void delete(int id_alumno) throws DAOException;

	public void update(String ubicacion, String nombre_emp, int id_alumno, String fecha) throws DAOException;

}
