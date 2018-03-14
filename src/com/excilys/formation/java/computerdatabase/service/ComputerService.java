/**
 * 
 */
package com.excilys.formation.java.computerdatabase.service;

import java.time.LocalDate;

import com.excilys.formation.java.computerdatabase.model.Company;
import com.excilys.formation.java.computerdatabase.model.Computer;
import com.excilys.formation.java.computerdatabase.persistence.dao.ComputerDAO;



/**
 * @author excilys
 *
 */
public enum ComputerService {
	
	INSTANCE;
	
	private ComputerDAO computerDAO = ComputerDAO.INSTANCE;
	
	public void createComputer(String name, LocalDate introduced, LocalDate discontinued, Long company_id) {
		Company ca = new Company();
		ca.setId(company_id);
		Computer c = new Computer(name, introduced, discontinued, ca);
		computerDAO.createComputer(c);
	}

}
