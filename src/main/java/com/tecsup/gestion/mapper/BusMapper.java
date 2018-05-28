package com.tecsup.gestion.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.tecsup.gestion.model.Bus;

public class BusMapper implements RowMapper<Bus> {

	@Override
	public Bus mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Bus bus = new Bus();
		bus.setIdbus(rs.getInt("idbus"));
		bus.setPlaca(rs.getString("placa"));
		return bus;
	}

}
