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
import java.util.List;

import com.excilys.formation.java.computerdatabase.mapper.ComputerMapper;
import com.excilys.formation.java.computerdatabase.model.Computer;
import com.excilys.formation.java.computerdatabase.persistence.DBConnection;

/**
 * @author excilys
 *
 */
public class ComputerDAO implements IComputerDAO {

	/**
	 * 
	 */
	public ComputerDAO() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.excilys.formation.java.computerdatabase.persistence.dao.IComputerDAO#createComputer(com.excilys.formation.java.computerdatabase.model.Computer)
	 */
	@Override
	public void createComputer(Computer c) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.INSTANCE.getConnection();
			stat = conn.prepareStatement("INSERT INTO Computer (name, introduced, discontinued, company_id) VALUES (?, ?, ?, ?)");
			if (c.getName() != null) {
				stat.setString(1, c.getName());
			} else {
				stat.setNull(1 , java.sql.Types.VARCHAR);
			}
			if (c.getIntroduced() != null) {
				stat.setDate(2, Date.valueOf(c.getIntroduced()));
			} else {
				stat.setNull(2, java.sql.Types.DATE);
			}
			if (c.getDiscontinued() != null) {
				stat.setDate(3, Date.valueOf(c.getDiscontinued()));
			} else {
				stat.setNull(3,  java.sql.Types.DATE);
			}
			if (c.getCompany_id() != null) {
				stat.setLong(4, c.getCompany_id());
			} else {
				stat.setNull(4,  java.sql.Types.BIGINT);
			}
			rs = stat.executeQuery();
			while(rs.next()) {
				ComputerMapper.createComputer(rs);
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
	}

	/* (non-Javadoc)
	 * @see com.excilys.formation.java.computerdatabase.persistence.dao.IComputerDAO#updateComputer(com.excilys.formation.java.computerdatabase.model.Computer)
	 */
	@Override
	public void updateComputer(Computer c) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.INSTANCE.getConnection();
			stat = conn.prepareStatement("INSERT INTO Computer (name, introduced, discontinued, company_id) VALUES (?, ?, ?, ?)");
			stat.setString(1, c.getName());
			stat.setDate(2, Date.valueOf(c.getIntroduced()));
			stat.setDate(3, Date.valueOf(c.getDiscontinued()));
			stat.setLong(4, c.getCompany_id());
			rs = stat.executeQuery();
			while(rs.next()) {
				ComputerMapper.createComputer(rs);
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

	}

	/* (non-Javadoc)
	 * @see com.excilys.formation.java.computerdatabase.persistence.dao.IComputerDAO#deleteComputer(com.excilys.formation.java.computerdatabase.model.Computer)
	 */
	@Override
	public void deleteComputer(Computer c) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.excilys.formation.java.computerdatabase.persistence.dao.IComputerDAO#showDetails(com.excilys.formation.java.computerdatabase.model.Computer)
	 */
	@Override
	public void showDetails(Computer c) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.excilys.formation.java.computerdatabase.persistence.dao.IComputerDAO#getListComputers()
	 */
	@Override
	public List<Computer> getListComputers() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		// TODO Auto-generated method stub
		return null;
	}

}
