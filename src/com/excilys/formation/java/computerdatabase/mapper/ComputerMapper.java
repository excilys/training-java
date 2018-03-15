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

	private CompanyMapper companyMapper = CompanyMapper.INSTANCE;

	/**
	 * @throws SQLException
	 * 
	 */

	public Computer createComputer(ResultSet rs) throws SQLException {
		Computer c = new Computer();
		fillFieldsForComputer(rs, c);
		c.setId(rs.getLong("cu_id"));
		return c;
	}

	public Computer fillFieldsForComputer(ResultSet rs, Computer c) throws SQLException {
		c.setName(rs.getString("cu_name"));
		if (rs.getDate("cu_introduced") != null) {
			c.setIntroduced(rs.getDate("cu_introduced").toLocalDate());
		}
		if (rs.getDate("cu_discontinued") != null) {
			c.setDiscontinued(rs.getDate("cu_discontinued").toLocalDate());
		}
		c.setCompany(companyMapper.createCompany(rs));
		return c;
	}

}
