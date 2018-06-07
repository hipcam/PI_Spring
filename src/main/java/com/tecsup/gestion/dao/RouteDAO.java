package com.tecsup.gestion.dao;

import java.sql.Time;
import java.util.List;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Route;

	public interface RouteDAO {
	
	Route findRoute(int id) throws DAOException, EmptyResultException;

	void create(String nombre, String ubicacion, Time hora) throws DAOException;

	void delete(String nombre) throws DAOException;

	void update(String nombre, String ubicacion, Time hora) throws DAOException;

	Route findRouteByName(String nombre) throws DAOException, EmptyResultException;

	List<Route> findAllRoutes() throws DAOException, EmptyResultException;


}
