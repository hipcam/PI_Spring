package com.tecsup.gestion.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tecsup.gestion.model.Pasantia;

public class PasantiaMapper implements RowMapper<Pasantia> {

	@Override
	public Pasantia mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Pasantia pas = new Pasantia();
		pas.setIdpasantia(rs.getInt("idpasantia"));
		pas.setFecha(rs.getDate("fecha"));
		pas.setNombre_empresa(rs.getString("nombre_empresa"));
		pas.setUbicacion(rs.getString("ubicacion"));
		pas.setAlumno_idalumno(rs.getInt("alumno_idalumno"));
		return pas;
	}

}
