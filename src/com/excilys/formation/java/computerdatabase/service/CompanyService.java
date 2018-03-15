/**
 * 
 */
package com.excilys.formation.java.computerdatabase.service;

import java.util.List;

import com.excilys.formation.java.computerdatabase.model.Company;
import com.excilys.formation.java.computerdatabase.persistence.dao.CompanyDAO;

/**
 * @author excilys
 *
 */
public enum CompanyService {

	INSTANCE;

	private CompanyDAO companyDAO = CompanyDAO.INSTANCE;

	public List<Company> getListCompanies(int pageNumber, int eltNumber) {
		return companyDAO.getListCompanies(pageNumber, eltNumber);
	}

	public int getPageCountCompanies(int eltNumber) {
		return companyDAO.getPageCountCompanies(eltNumber);
	}

}
