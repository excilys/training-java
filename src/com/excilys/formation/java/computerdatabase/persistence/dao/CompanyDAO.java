/**
 * 
 */
package com.excilys.formation.java.computerdatabase.persistence.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	private CompanyMapper companyMapper = CompanyMapper.INSTANCE;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.excilys.formation.java.computerdatabase.persistence.dao.ICompanyDAO#
	 * listCompanies()
	 */
	@Override
	public List<Company> getListCompanies(int pageNumber, int eltNumber) {
		int offset = pageNumber * eltNumber;
		ArrayList<Company> listCompanies = new ArrayList<Company>();
		PreparedStatement stat = null;
		ResultSet rs = null;
		try (Connection conn = dbConnection.getConnection()) {
			stat = conn.prepareStatement("SELECT * FROM company ORDER BY ca_id LIMIT ? OFFSET ?");
			stat.setInt(1, eltNumber);
			stat.setInt(2, offset);
			rs = stat.executeQuery();

			while (rs.next()) {
				listCompanies.add(companyMapper.createCompany(rs));
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

	@Override
	public int getPageCountCompanies(int eltNumber) {
		int pageNumber = 0;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try (Connection conn = dbConnection.getConnection()) {
			stat = conn.prepareStatement("SELECT count(*) FROM company");
			rs = stat.executeQuery();
			rs.next();
			int tailleListCompanies = rs.getInt(1);
			pageNumber = tailleListCompanies / eltNumber;
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
		return pageNumber;
	}

}
