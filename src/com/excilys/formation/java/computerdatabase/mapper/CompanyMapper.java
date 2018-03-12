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
public class CompanyMapper {

	/**
	 * 
	 */
	public CompanyMapper() {
		// TODO Auto-generated constructor stub
	}

	public static Company createCompany(ResultSet rs) throws SQLException {
		Long id = rs.getLong("id");
		String name = rs.getString("name");
		return new Company(id, name);
	}

}
