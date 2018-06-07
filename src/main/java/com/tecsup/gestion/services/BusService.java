package com.tecsup.gestion.services;

import java.util.List;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Bus;

public interface BusService {

	Bus find(int idbus) throws DAOException, EmptyResultException;

	List<Bus> findAll() throws DAOException, EmptyResultException;
	
	public void update(int idbus,String placa) throws DAOException;
	
	public void delete(String placa) throws DAOException;
	
	public void create(String placa) throws DAOException;
}
