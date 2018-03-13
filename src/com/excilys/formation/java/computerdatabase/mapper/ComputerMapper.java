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
public class ComputerMapper {

	/**
	 * 
	 */
	public ComputerMapper() {
		// TODO Auto-generated constructor stub
	}

	public static Computer createComputer(ResultSet rs) throws SQLException {
		Computer c = new Computer();
		c.setName(rs.getString(0));
		c.setIntroduced(rs.getDate(1).toLocalDate());
		c.setDiscontinued(rs.getDate(2).toLocalDate());
		c.setCompany_id(rs.getLong(3));
		return c;
	}

}
