package com.tecsup.gestion.services;

import java.sql.Time;
import java.util.List;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Route;

public interface RouteService {
	
	Route findRoute(int idparadero) throws DAOException, EmptyResultException;

	List<Route> findAll() 
			throws DAOException, EmptyResultException;

	public void create(String nombre, String ubicacion, Time hora) throws DAOException;

	public void delete(String nombre) throws DAOException;

	public void update(String nombre, String ubicacion, Time hora) throws DAOException;
}
