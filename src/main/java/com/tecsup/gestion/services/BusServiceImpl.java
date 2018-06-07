package com.tecsup.gestion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.gestion.dao.BusDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Bus;

@Service
public class BusServiceImpl implements BusService {
	
	@Autowired
	private BusDAO busDAO;

	@Override
	public Bus find(int idbus) throws DAOException, EmptyResultException {
	
		Bus bus = busDAO.findBus(idbus);
		return bus;
	}

	@Override
	public List<Bus> findAll() throws DAOException, EmptyResultException {
	 
		List<Bus> buses = busDAO.findAllBuses();
		return buses;
	}

	@Override
	public void update(int idbus, String placa) throws DAOException {
		busDAO.update(idbus, placa);
		
	}

	@Override
	public void delete(String placa) throws DAOException {
		busDAO.delete(placa);		
	}

	@Override
	public void create(String placa) throws DAOException {
		busDAO.create(placa);
		
	}

}
