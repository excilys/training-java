/**
 * 
 */
package com.excilys.formation.java.computerdatabase.model;

import java.time.LocalDate;

/**
 * @author excilys
 *
 */
public class Computer {

	/**
	 * 
	 */
	
	private Long id;
	private String name;
	private LocalDate introduced;
	private LocalDate discontinued;
	private Long company_id;
	
	
	public Computer() {
		// TODO Auto-generated constructor stub
	}

	
	public Computer(Long id, String name, LocalDate introduced, LocalDate discontinued, Long company_id) {
		super();
		this.id = id;
		this.name = name;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.company_id = company_id;
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the introduced
	 */
	public LocalDate getIntroduced() {
		return introduced;
	}


	/**
	 * @param introduced the introduced to set
	 */
	public void setIntroduced(LocalDate introduced) {
		this.introduced = introduced;
	}


	/**
	 * @return the discontinued
	 */
	public LocalDate getDiscontinued() {
		return discontinued;
	}


	/**
	 * @param discontinued the discontinued to set
	 */
	public void setDiscontinued(LocalDate discontinued) {
		this.discontinued = discontinued;
	}


	/**
	 * @return the company_id
	 */
	public Long getCompany_id() {
		return company_id;
	}


	/**
	 * @param company_id the company_id to set
	 */
	public void setCompany_id(Long company_id) {
		this.company_id = company_id;
	}
	
	

}
