package com.tecsup.gestion.dao.jdbc;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tecsup.gestion.dao.PasantiaDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.mapper.PasantiaMapper;
import com.tecsup.gestion.model.Pasantia;
 
@Repository 
public class PasantiaDAOImpl implements PasantiaDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(PasantiaDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Pasantia findPasantia(int idpasantia) throws DAOException, EmptyResultException {


		String query = "SELECT *  FROM  tecsup_transport.pasantia WHERE idpasantia = ? ;";

		Object[] params = new Object[] { idpasantia };

		try {

			Pasantia pas = (Pasantia) jdbcTemplate.queryForObject(query, params, new PasantiaMapper());
			//
			return pas;
			//return null;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public void create(String ubicacion, String nombre_emp, int id_alumno, Date fecha) throws DAOException {

		String query = "INSERT INTO  tecsup_transport.pasantia (ubicacion, nombre_empresa, alumno_idalumno, fecha)  VALUES ( ?,?,?,? ) ;";

		Object[] params = new Object[] { ubicacion, nombre_emp, id_alumno, fecha};

		Pasantia pas = null;
		
		try {
			// create
			jdbcTemplate.update(query, params);
			// search
			pas = this.findPasantiaByAlumno(id_alumno);

		} catch (EmptyResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public void delete(int id_alumno) throws DAOException {


		String query = "DELETE FROM  tecsup_transport.pasantia WHERE alumno_idalumno = ? ;";

		Object[] params = new Object[] { id_alumno };

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public void update(String ubicacion, String nombre_emp, int id_alumno, Date fecha) throws DAOException, DataAccessException {
		
		String query = "UPDATE tecsup_transport.pasantia SET ubicacion = ?, nombre_empresa =?, fecha = ? WHERE alumno_idalumno = ? ;";

		Object[] params = new Object[] { ubicacion,  nombre_emp, fecha};

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public Pasantia findPasantiaByAlumno(int id_alumno) throws DAOException, EmptyResultException {

		String query = "SELECT * FROM tecsup_transport.pasantia WHERE alumno_idalumno = ? ;";

		Object[] params = new Object[] { id_alumno };

		try {

			Pasantia pasantia = jdbcTemplate.queryForObject(query, params, new PasantiaMapper());
			//
			return pasantia;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public List<Pasantia> findAllPasantias() throws DAOException, EmptyResultException {

		String query = "SELECT * FROM tecsup_transport.pasantia; ";

		try {

			List<Pasantia> pasantias = jdbcTemplate.query(query, new PasantiaMapper());
			//
			return pasantias;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

}
