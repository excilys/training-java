/**
 * 
 */
package com.excilys.formation.java.computerdatabase.persistence.dao;

import java.util.List;

import com.excilys.formation.java.computerdatabase.model.Computer;

/**
 * @author excilys
 *
 */
public interface IComputerDAO {

	public abstract void createComputer(Computer c);

	public abstract void updateComputer(Computer c);

	public abstract void deleteComputer(Computer c);

	public abstract Computer showDetails(Computer c);

	public abstract List<Computer> getListComputers(int pageNumber, int eltNumber);

	int getPageCountComputers(int eltNumber);

}
