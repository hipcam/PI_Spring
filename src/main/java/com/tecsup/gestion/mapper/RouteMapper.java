package com.tecsup.gestion.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tecsup.gestion.model.Route;

public class RouteMapper implements RowMapper<Route>{

	@Override
	public Route mapRow(ResultSet rs, int rowNum) throws SQLException {

		Route rout = new Route();
		rout.setIdparadero(rs.getInt("idparadero"));
		rout.setHorapartida(rs.getTime("horapartida"));
		rout.setNombre(rs.getString("nombre"));
		rout.setUbicacion(rs.getString("ubicacion"));
		return rout;
	}

}
