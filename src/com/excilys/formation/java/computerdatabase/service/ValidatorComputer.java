/**
 * 
 */
package com.excilys.formation.java.computerdatabase.service;

import com.excilys.formation.java.computerdatabase.model.Computer;

/**
 * @author excilys
 *
 */
public enum ValidatorComputer {

	INSTANCE;

	public void validateComputer(Computer c) throws NullNameException {
		if(c.getName() == null) {
			throw new NullNameException("Le nom de votre PC ne peut être nul !");
		}
		if(c.getDiscontinued() != null && c.getIntroduced() != null) {
			if (c.getDiscontinued().isBefore(c.getIntroduced())) {
				throw new DateMismatchException("La date discontinued ne peut être avant ou égal à la date introduced");
			}
		}
	}

}
