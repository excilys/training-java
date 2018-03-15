/**
 * 
 */
package com.excilys.formation.java.computerdatabase.service;

import java.time.LocalDate;
import java.util.List;

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
	private ValidatorComputer val = ValidatorComputer.INSTANCE;

	public void createComputer(String name, LocalDate introduced, LocalDate discontinued, Long company_id)
			throws NullNameException, DateMismatchException, MissingCompanyException {
		Computer c = createComputerFromSpecificCompanyId(name, introduced, discontinued, company_id);
		val.validateComputer(c);
		computerDAO.createComputer(c);
	}

	public List<Computer> getListComputers(int pageNumber, int eltNumber) {
		return computerDAO.getListComputers(pageNumber, eltNumber);
	}

	public int getPageCountComputers(int eltNumber) {
		return computerDAO.getPageCountComputers(eltNumber);
	}

	public Computer showDetails(Long id) {
		Computer c = createComputerWithOnlyId(id);
		return computerDAO.showDetails(c);
	}

	public void updateComputer(Long id, String name, LocalDate introduced, LocalDate discontinued, Long company_id)
			throws NullNameException, DateMismatchException, MissingCompanyException {
		Computer c = createComputerFromSpecificCompanyId(name, introduced, discontinued, company_id);
		c.setId(id);
		val.validateComputer(c);
		computerDAO.updateComputer(c);
	}

	private Computer createComputerFromSpecificCompanyId(String name, LocalDate introduced, LocalDate discontinued,
			Long company_id) {
		Company ca = new Company();
		ca.setId(company_id);
		Computer c = new Computer(name, introduced, discontinued, ca);
		return c;
	}

	public void deleteComputer(Long id) {
		Computer c = createComputerWithOnlyId(id);
		computerDAO.deleteComputer(c);
	}

	private Computer createComputerWithOnlyId(Long id) {
		Computer c = new Computer();
		c.setId(id);
		return c;
	}

}
