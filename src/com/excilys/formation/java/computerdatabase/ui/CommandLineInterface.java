/**
 * 
 */
package com.excilys.formation.java.computerdatabase.ui;

import java.io.*;
import java.util.List;

import com.excilys.formation.java.computerdatabase.model.Company;
import com.excilys.formation.java.computerdatabase.model.Computer;
import com.excilys.formation.java.computerdatabase.service.CompanyService;
import com.excilys.formation.java.computerdatabase.service.ComputerService;

/**
 * @author excilys
 *
 */

public class CommandLineInterface {

	private String res;
	private BufferedReader br;
	private ComputerService computerService = ComputerService.INSTANCE;
	private CompanyService companyService = CompanyService.INSTANCE;
	private int taillePage;

	public CommandLineInterface() {
		br = new BufferedReader(new InputStreamReader(System.in));
		taillePage = 20;
	}

	public String menuCLI() {
		StringBuilder strb = new StringBuilder();
		res = strb.append("******************************\n").append("Que souhaitez-vous effectuer ?\n\n")
				.append("******************************\n\n").append("1) Lister les ordinateurs\n")
				.append("2) Lister les entreprises\n").append("3) Obtenir le détail d'un ordinateur\n")
				.append("4) Ajouter un ordinateur\n").append("5) Mettre à jour/Supprimer un ordinateur\n").toString();
		return res;
	}

	/**
	 * @param cli
	 * @param s
	 */
	public void mainLoop(String s) {
		switch (s) {
		case "1":
			getListComputers();

			break;
		case "2":
			getListCompanies();

			break;
		case "3":
			showdetails();

			break;
		case "4":
			createComputer();

			break;
		case "5":
			updateordelComputer();

			break;

		default:
			throw new ArrayIndexOutOfBoundsException("Votre chiffre ne correspond à rien :D");
		}
	}

	private void updateordelComputer() {

	}

	private void createComputer() {

	}

	private void showdetails() {
		System.out.println("Donnez l'id du PC que vous souhaitez consulter");
		String s = getLineInString();
		if (s != null) {
			Long id = Long.parseLong(s);
			Computer computer = computerService.showDetails(id);
			System.out.println(computer.toString());
		} else {

		}

	}

	private void getListCompanies() {
		int nombreResCompanies = companyService.getPageCountCompanies(taillePage);
		for (int j = 0; j < nombreResCompanies + 1; j++) {
			List<Company> listCompanies = companyService.getListCompanies(j, taillePage);
			listCompanies.forEach(company -> System.out.println(company.toString()));
			getLine();
		}
	}

	private void getListComputers() {
		int nombreResComputers = computerService.getPageCountComputers(taillePage);
		for (int j = 0; j < nombreResComputers + 1; j++) {
			List<Computer> listComputers = computerService.getListComputers(j, taillePage);
			listComputers.forEach(computer -> System.out.println(computer.toString()));
			getLine();
		}

	}

	/**
	 * 
	 */
	private void getLine() {
		try {
			br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getLineInString() {
		String s = new String();
		try {
			s = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CommandLineInterface cli = new CommandLineInterface();
		while (true) {
			System.out.println(cli.menuCLI());
			String s = cli.getLineInString();
			cli.mainLoop(s);
		}
	}

}
