package com.tecsup.gestion.dao.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tecsup.gestion.dao.BusDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.mapper.BusMapper;
import com.tecsup.gestion.model.Bus;


@Repository
public class BusDAOImpl implements BusDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(BusDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Bus findBus(int idbus) throws DAOException, EmptyResultException {

		String query = "SELECT * FROM tecsup_transport.bus WHERE idbus = ? ;";

		Object[] params = new Object[] { idbus };

		try {

			Bus bus = (Bus) jdbcTemplate.queryForObject(query, params, new BusMapper());
			//
			return bus;
			//return null;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public void create(String placa) throws DAOException {

		String query = "INSERT INTO tecsup_transport.bus (placa)  VALUES (?)";

		Object[] params = new Object[] { placa};

		Bus bus = null;
		
		try {
			// create
			jdbcTemplate.update(query, params);
			// search
			bus = this.findBusByPlaca(placa);

		} catch (EmptyResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public void delete(String placa) throws DAOException {
		
		String query = "DELETE FROM  tecsup_transport.bus WHERE placa= ?;  ";

		Object[] params = new Object[] { placa};

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public void update(int idbus, String placa) throws DAOException, DataAccessException {

		String query = "UPDATE tecsup_transport.bus SET placa= ? WHERE idbus = ? ;";

		Object[] params = new Object[] { idbus, placa};

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public Bus findBusByPlaca(String placa) throws DAOException, EmptyResultException {

		String query = "SELECT *  FROM tecsup_transport.bus WHERE placa = ? ;";

		Object[] params = new Object[] { placa };

		try {

			Bus bus = jdbcTemplate.queryForObject(query, params, new BusMapper());
			//
			return bus;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public List<Bus> findAllBuses() throws DAOException, EmptyResultException {


		String query = "SELECT idbus, placa FROM tecsup_transport.bus;";

		try {

			List<Bus> buses = jdbcTemplate.query(query, new BusMapper());
			//
			return buses;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

}
