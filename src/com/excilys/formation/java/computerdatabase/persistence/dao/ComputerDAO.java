/**
 * 
 */
package com.excilys.formation.java.computerdatabase.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.excilys.formation.java.computerdatabase.model.Computer;

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
		Statement stat = null;
		ResultSet rs = null;
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.excilys.formation.java.computerdatabase.persistence.dao.IComputerDAO#updateComputer(com.excilys.formation.java.computerdatabase.model.Computer)
	 */
	@Override
	public void updateComputer(Computer c) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		// TODO Auto-generated method stub

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
