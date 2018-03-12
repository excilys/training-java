/**
 * 
 */
package com.excilys.formation.java.computer.database.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.excilys.formation.java.computerdatabase.model.Company;
import com.excilys.formation.java.computerdatabase.persistence.dao.CompanyDAO;

/**
 * @author excilys
 *
 */
public class CompanyDAOTest {

	@Test
	public void testGetListCompanies() {
		CompanyDAO newDAO = new CompanyDAO();
		List<Company> listCompanies = new ArrayList<>();
		listCompanies = newDAO.getListCompanies();
		assertNotNull(listCompanies);
	}

}
