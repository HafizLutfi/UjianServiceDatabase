package com.juaracoding.main.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BonusRowMapper implements RowMapper<Bonus> {

	@Override
	public Bonus mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return new Bonus(rs.getInt("worker_reff_id"), rs.getString("bonus_date"), rs.getInt("bonus_amount"));
	}
}
