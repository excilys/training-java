/**
 * 
 */
package com.excilys.formation.java.computer.database.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.excilys.formation.java.computerdatabase.model.Company;

/**
 * @author excilys
 *
 */
public class CompanyTest {
	
	private Company c;

	@Before
	public void setUp() {
		c = new Company();
	}
	
	@Test
	public void testCompany() {
		assertNotNull(c);
	}
	
	@Test
	public void testId() {
		c.setId((long) 5);
		assertNotNull(c.getId());
	}
	
	@Test
	public void testName() {
		c.setName("Jeanjacques");
		assertNotNull(c.getName());
	}

}
