package com.juaracoding.main.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TitleRowMapper implements RowMapper<Title> {
	
	@Override
	public Title mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return new Title(rs.getInt("worker_reff_id"), rs.getString("worler_title"), rs.getString("affected_from"));
		
	}

}
