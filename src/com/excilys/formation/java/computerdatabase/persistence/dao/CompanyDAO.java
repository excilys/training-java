/**
 * 
 */
package com.excilys.formation.java.computerdatabase.persistence.dao;

import java.io.IOException;
import java.sql.Connection;
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
public class CompanyDAO implements ICompanyDAO {

	/**
	 * 
	 */
	
	private static final String SQL_LIST_COMPANIES = "SELECT * FROM Company";
	
	public CompanyDAO() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.excilys.formation.java.computerdatabase.persistence.dao.ICompanyDAO#listCompanies()
	 */
	@Override
	public List<Company> getListCompanies() {
		ArrayList<Company> listCompanies = new ArrayList<Company>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			stat= conn.createStatement();
			rs = stat.executeQuery(SQL_LIST_COMPANIES);
			
			while(rs.next()) {
				listCompanies.add(CompanyMapper.createCompany(rs));
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
		} finally {
			try {
				DBConnection.closeConnection(rs, stat, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listCompanies;
	}

}
