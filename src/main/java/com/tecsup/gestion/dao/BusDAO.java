package com.tecsup.gestion.dao;

import java.util.List;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Bus;

public interface BusDAO {

	Bus findBus(int id) throws DAOException, EmptyResultException;

	void create(String placa) throws DAOException;

	void delete(String placa) throws DAOException;

    void update(int idbus, String placa) throws DAOException;

	Bus findBusByPlaca(String placa) throws DAOException, EmptyResultException;

	List<Bus> findAllBuses() throws DAOException, EmptyResultException;

}
