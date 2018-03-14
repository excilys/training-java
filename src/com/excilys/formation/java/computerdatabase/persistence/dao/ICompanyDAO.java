/**
 * 
 */
package com.excilys.formation.java.computerdatabase.persistence.dao;

import java.util.List;

import com.excilys.formation.java.computerdatabase.model.Company;

/**
 * @author excilys
 *
 */
public interface ICompanyDAO {

	public abstract List<Company> getListCompanies();

}
