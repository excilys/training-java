/**
 * 
 */
package com.excilys.formation.java.computerdatabase.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.excilys.formation.java.computerdatabase.model.Company;

/**
 * @author excilys
 *
 */
public enum CompanyMapper {

	INSTANCE;

	/**
	 * 
	 */

	public Company createCompany(ResultSet rs) throws SQLException {
		Company c = new Company();
		c.setId(rs.getLong("company_id"));
		c.setName(rs.getString("company_name"));
		return c;
	}

}
