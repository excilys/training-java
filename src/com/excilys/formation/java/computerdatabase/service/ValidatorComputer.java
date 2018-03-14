/**
 * 
 */
package com.excilys.formation.java.computerdatabase.service;

import com.excilys.formation.java.computerdatabase.model.Company;
import com.excilys.formation.java.computerdatabase.model.Computer;
import com.excilys.formation.java.computerdatabase.persistence.dao.CompanyDAO;

/**
 * @author excilys
 *
 */
public enum ValidatorComputer {

	INSTANCE;
	
	private CompanyDAO companyDAO = CompanyDAO.INSTANCE;

	public void validateComputer(Computer c) throws NullNameException, DateMismatchException, MissingCompanyException {
		if(c.getName() == null) {
			throw new NullNameException("Le nom de votre PC ne peut être nul !");
		}
		if(c.getDiscontinued() != null && c.getIntroduced() != null) {
			if (c.getDiscontinued().isBefore(c.getIntroduced())) {
				throw new DateMismatchException("La date discontinued ne peut être avant ou égal à la date introduced");
			}
		}
		if(c.getCompany().getId() != null) {
			Company ca = new Company();
			ca.setId(c.getCompany().getId());
			if (companyDAO.showDetails(ca) == null) {
				throw new MissingCompanyException("L'id de company que vous avez donné n'existe pas !");
			}
		}
	}

}
