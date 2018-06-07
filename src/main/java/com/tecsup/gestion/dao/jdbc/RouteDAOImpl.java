package com.tecsup.gestion.dao.jdbc;

import java.sql.Time;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tecsup.gestion.dao.RouteDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.mapper.RouteMapper;
import com.tecsup.gestion.model.Route;

@Repository
public class RouteDAOImpl implements RouteDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(PasantiaDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public Route findRoute(int idparadero) throws DAOException, EmptyResultException {

		String query = "SELECT idparadero, ubicacion  FROM tecsup_transport.paradero WHERE idparadero = ? ;";

		Object[] params = new Object[] { idparadero };

		try {

			Route rout = (Route) jdbcTemplate.queryForObject(query, params, new RouteMapper());
			//
			return rout;
			//return null;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public void create(String nombre, String ubicacion, Time hora) throws DAOException {

		String query = "INSERT INTO tecsup_transport.paradero (nombre, ubicacion, horapartida)  VALUES ( ?,?,? ) ;";

		Object[] params = new Object[] { nombre, ubicacion, hora};

		Route rout = null;
		
		try {
			// create
			jdbcTemplate.update(query, params);
			// search
			rout = this.findRouteByName(nombre);

		} catch (EmptyResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public void delete(String nombre) throws DAOException, DataAccessException {

		String query = "DELETE FROM  tecsup_transport.paradero WHERE nombre = ? ;";

		Object[] params = new Object[] { nombre };

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public void update(String nombre, String ubicacion, Time hora) throws DAOException {

		String query = "UPDATE tecsup_transport.paradero SET ubicacion = ?, horapartida = ? WHERE nombre = ? ;";

		Object[] params = new Object[] { ubicacion, hora};

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public Route findRouteByName(String nombre) throws DAOException, EmptyResultException {
		
		String query = "SELECT * FROM tecsup_transport.paradero WHERE nombre = ? ;";

		Object[] params = new Object[] { nombre };

		try {

			Route route = jdbcTemplate.queryForObject(query, params, new RouteMapper());
			//
			return route;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public List<Route> findAllRoutes() throws DAOException, EmptyResultException {

		String query = "SELECT * FROM tecsup_transport.paradero ;";

		try {

			List<Route> routes = jdbcTemplate.query(query, new RouteMapper());
			//
			return routes;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

}
