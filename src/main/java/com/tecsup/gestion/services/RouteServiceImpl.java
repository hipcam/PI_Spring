package com.tecsup.gestion.services;

import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.gestion.dao.RouteDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Route;

@Service
public class RouteServiceImpl implements RouteService{
	
	@Autowired
	private RouteDAO routeDAO;

	@Override
	public Route findRoute(int idparadero) throws DAOException, EmptyResultException {
		
		Route rout = routeDAO.findRoute(idparadero);
		return rout;
	}

	@Override
	public List<Route> findAll() throws DAOException, EmptyResultException {
		List<Route> routs = routeDAO.findAllRoutes();
		return routs;
	}

	@Override
	public void create(String nombre, String ubicacion, Time hora) throws DAOException {
		routeDAO.create(nombre, ubicacion, hora);
		
	}

	@Override
	public void delete(String nombre) throws DAOException {
		routeDAO.delete(nombre);
		
	}

	@Override
	public void update(String nombre, String ubicacion, Time hora) throws DAOException {
		routeDAO.update(nombre, ubicacion, hora);
		
	}

}
