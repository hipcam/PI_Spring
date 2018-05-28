package com.tecsup.gestion.dao;

import java.sql.Date;
import java.util.List;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Pasantia;

public interface PasantiaDAO {
	
	Pasantia findPasantia(int id) throws DAOException, EmptyResultException;

	void create(String ubicacion, String nombre_emp, int id_alumno, Date fecha) throws DAOException;

	void delete(int id_alumno) throws DAOException;

	void update(String ubicacion, String nombre_emp, int id_alumno, Date fecha) throws DAOException;

	Pasantia findPasantiaByAlumno(int id_alumno) throws DAOException, EmptyResultException;

	List<Pasantia> findAllPasantias() throws DAOException, EmptyResultException;

    
}
