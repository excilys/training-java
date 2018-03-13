/**
 * 
 */
package com.excilys.formation.java.computerdatabase.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.excilys.formation.java.computerdatabase.model.Computer;

/**
 * @author excilys
 *
 */
public enum ComputerMapper {

	INSTANCE;

	/**
	 * @throws SQLException
	 * 
	 */

	public Computer createComputer(ResultSet rs) throws SQLException {
		Computer c = new Computer();
		fillFieldsForComputer(rs, c);
		return c;
	}

	public Computer fillFieldsForComputer(ResultSet rs, Computer c) throws SQLException {
		c.setName(rs.getString(0));
		c.setIntroduced(rs.getDate(1).toLocalDate());
		c.setDiscontinued(rs.getDate(2).toLocalDate());
		c.setCompany_id(rs.getLong(3));
		return c;
	}

}
