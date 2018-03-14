/**
 * 
 */
package com.excilys.formation.java.computerdatabase.persistence.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.excilys.formation.java.computerdatabase.mapper.CompanyMapper;
import com.excilys.formation.java.computerdatabase.mapper.ComputerMapper;
import com.excilys.formation.java.computerdatabase.model.Company;
import com.excilys.formation.java.computerdatabase.model.Computer;
import com.excilys.formation.java.computerdatabase.persistence.DBConnection;

/**
 * @author excilys
 *
 */
public enum ComputerDAO implements IComputerDAO {

	INSTANCE;

	/**
	 * 
	 */

	private DBConnection dbConnection = DBConnection.INSTANCE;
	private ComputerMapper computerMapper = ComputerMapper.INSTANCE;
	private CompanyMapper companyMapper = CompanyMapper.INSTANCE;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.excilys.formation.java.computerdatabase.persistence.dao.IComputerDAO#
	 * createComputer(com.excilys.formation.java.computerdatabase.model.Computer)
	 */
	@Override
	public void createComputer(Computer c) {
		PreparedStatement stat = null;
		try (Connection conn = dbConnection.getConnection()) {
			stat = conn.prepareStatement(
					"INSERT INTO Computer (name, introduced, discontinued, company) VALUES (?, ?, ?, ?)");
			setStatementsSQL(c, stat);
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
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.excilys.formation.java.computerdatabase.persistence.dao.IComputerDAO#
	 * deleteComputer(com.excilys.formation.java.computerdatabase.model.Computer)
	 */
	@Override
	public void deleteComputer(Computer c) {
		PreparedStatement stat = null;
		try (Connection conn = dbConnection.getConnection()) {
			stat = conn.prepareStatement("DELETE FROM computer WHERE id = ?");
			stat.setLong(1, c.getId());
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

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.excilys.formation.java.computerdatabase.persistence.dao.IComputerDAO#
	 * getListComputers()
	 */
	@Override
	public List<Computer> getListComputers() {
		PreparedStatement stat = null;
		ResultSet rs = null;
		ArrayList<Computer> listComputers = new ArrayList<Computer>();
		try (Connection conn = dbConnection.getConnection()) {
			stat = conn.prepareStatement(
					"SELECT c1.id, c1.name, c1.introduced, c1.discontinued, c1.company_id, c2.id as company_id, c2.name as company_name FROM computer as c1 LEFT JOIN company as c2 on c1.id = c2.id ");
			rs = stat.executeQuery();

			while (rs.next()) {
				listComputers.add(computerMapper.createComputer(rs));
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
		return listComputers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.excilys.formation.java.computerdatabase.persistence.dao.IComputerDAO#
	 * showDetails(com.excilys.formation.java.computerdatabase.model.Computer)
	 */
	@Override
	public Computer showDetails(Computer c) {
		PreparedStatement stat = null;
		ResultSet rs = null;
		try (Connection conn = dbConnection.getConnection()) {
			stat = conn.prepareStatement(
					"SELECT c1.name, c1.introduced, c1.discontinued, c1.company, c2.id as company_id, c2.name as company_name FROM computer as c1 LEFT JOIN company as c2 ON c1.id = c2.id WHERE id = ?");
			stat.setLong(1, c.getId());
			rs = stat.executeQuery();
			c = computerMapper.fillFieldsForComputer(rs, c);
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
		return c;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.excilys.formation.java.computerdatabase.persistence.dao.IComputerDAO#
	 * updateComputer(com.excilys.formation.java.computerdatabase.model.Computer)
	 */
	@Override
	public void updateComputer(Computer c) {
		PreparedStatement stat = null;
		try (Connection conn = dbConnection.getConnection()) {
			stat = conn.prepareStatement(
					"UPDATE computer SET name = ?, introduced = ?, discontinued = ?, company_id = ? WHERE id = ?");
			setStatementsSQL(c, stat);
			stat.setLong(5, c.getId());
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

	}

	// Ici on oblige la vérification nulle pour éviter d'avoir un crash peu parlant
	// si on rentre des valeurs nulles (même si on fait la vérif avec un validator
	// avant)
	private void setStatementsSQL(Computer c, PreparedStatement stat) throws SQLException {
		if (c.getName() != null) {
			stat.setString(1, c.getName());
		} else {
			stat.setNull(1, java.sql.Types.VARCHAR);
		}
		if (c.getIntroduced() != null) {
			stat.setDate(2, Date.valueOf(c.getIntroduced()));
		} else {
			stat.setNull(2, java.sql.Types.DATE);
		}
		if (c.getDiscontinued() != null) {
			stat.setDate(3, Date.valueOf(c.getDiscontinued()));
		} else {
			stat.setNull(3, java.sql.Types.DATE);
		}
		if (c.getCompany() != null) {
			stat.setLong(4, c.getCompany().getId());
		} else {
			stat.setNull(4, java.sql.Types.BIGINT);
		}
	}

}
