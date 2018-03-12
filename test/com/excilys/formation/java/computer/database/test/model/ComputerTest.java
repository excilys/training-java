/**
 * 
 */
package com.excilys.formation.java.computer.database.test.model;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.excilys.formation.java.computerdatabase.model.Computer;

/**
 * @author excilys
 *
 */
public class ComputerTest {

	private Computer c;
	
	@Before 
	public void setUp() {
		c= new Computer();
	}
	
	@Test
	public void testComputer() {
		assertNotNull(c);
	}
	
	@Test
	public void testSetId() {
		c.setId((long) 5);
		assertNotNull(c.getId());
	}
	
	@Test
	public void testSetCompanyId() {
		c.setCompany_id((long) 2);
		assertNotNull(c.getCompany_id());
	}
	
	@Test
	public void testSetName() {
		c.setName("Excilys");
		assertNotNull(c.getName());
	}
	
	@Test
	public void testSetIntroduced() {
		c.setIntroduced(LocalDate.of(2012,5,12));
		assertNotNull(c.getIntroduced());
	}
	
	@Test
	public void testSetDiscontinued() {
		c.setDiscontinued(LocalDate.of(2015,6,15));
		assertNotNull(c.getDiscontinued());
	}
	
	@Test
	public void testLocalDate() {
		c.setIntroduced(LocalDate.of(2012,5,12));
		c.setDiscontinued(LocalDate.of(2015,6,15));
		boolean tmp = c.getIntroduced().isBefore(c.getDiscontinued());
		assertTrue(tmp);
	}

}
