/**
 * 
 */
package com.excilys.formation.java.computerdatabase.service;

import com.excilys.formation.java.computerdatabase.model.Computer;
import com.excilys.formation.java.computerdatabase.persistence.dao.ComputerDAO;

/**
 * @author excilys
 *
 */
public enum ComputerService {
	
	INSTANCE;
	
	private ComputerDAO computerDAO = ComputerDAO.INSTANCE;
	
	public void createComputer(Computer c) {
		computerDAO.createComputer(c);
	}

}
