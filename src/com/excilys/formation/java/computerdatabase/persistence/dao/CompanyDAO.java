/**
 * 
 */
package com.excilys.formation.java.computerdatabase.persistence.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.excilys.formation.java.computerdatabase.mapper.CompanyMapper;
import com.excilys.formation.java.computerdatabase.model.Company;
import com.excilys.formation.java.computerdatabase.persistence.DBConnection;

/**
 * @author excilys
 *
 */
public enum CompanyDAO implements ICompanyDAO {

	INSTANCE;

	/**
	 * 
	 */
	private DBConnection dbConnection = DBConnection.INSTANCE;
	private CompanyMapper compMapper = CompanyMapper.INSTANCE;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.excilys.formation.java.computerdatabase.persistence.dao.ICompanyDAO#
	 * listCompanies()
	 */
	@Override
	public List<Company> getListCompanies() {
		ArrayList<Company> listCompanies = new ArrayList<Company>();
		PreparedStatement stat = null;
		ResultSet rs = null;
		try (Connection conn = dbConnection.getConnection()) {
			stat = conn.prepareStatement("SELECT id as company_id, name as company_name FROM company");
			rs = stat.executeQuery();

			while (rs.next()) {
				listCompanies.add(compMapper.createCompany(rs));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listCompanies;
	}

}
