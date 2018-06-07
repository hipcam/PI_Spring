package com.tecsup.gestion.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.gestion.dao.PasantiaDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Pasantia;

@Service
public class PasantiaServiceImpl implements PasantiaService{
	
	@Autowired
	private PasantiaDAO pasantiaDAO;

	@Override
	public Pasantia find(int idpasantia) throws DAOException, EmptyResultException {
		
		Pasantia pas = pasantiaDAO.findPasantia(idpasantia);

		return pas;
	}

	@Override
	public List<Pasantia> findAll() throws DAOException, EmptyResultException {
		
		List<Pasantia> pasants = pasantiaDAO.findAllPasantias();
		return pasants;
	}

	@Override
	public void create(String ubicacion, String nombre_emp, int id_alumno, String fecha) throws DAOException {
		pasantiaDAO.create(ubicacion, nombre_emp, id_alumno, fecha);
		
	}

	@Override
	public void delete(int id_alumno) throws DAOException {
		pasantiaDAO.delete(id_alumno);
		
	}

	@Override
	public void update(String ubicacion, String nombre_emp, int id_alumno, String fecha) throws DAOException {
		pasantiaDAO.update(ubicacion, nombre_emp, id_alumno, fecha);
		
	}


}
