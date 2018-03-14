/**
 * 
 */
package com.excilys.formation.java.computerdatabase.ui;

import java.io.*;

/**
 * @author excilys
 *
 */
public class CommandLineInterface {

	private String res;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public String menuCLI() {
		StringBuilder strb = new StringBuilder();
		res = strb.append("******************************\n").append("Que souhaitez-vous effectuer ?\n\n")
				.append("******************************\n\n").append("1) Lister les ordinateurs\n")
				.append("2) Lister les entreprises\n").append("3) Obtenir le détail d'un ordinateur\n")
				.append("4) Ajouter un ordinateur\n").append("5) Mettre à jour/Supprimer un ordinateur\n").toString();
		return res;
	}

	private static void updateordelComputer() {

	}

	private static void createComputer() {
		// TODO Auto-generated method stub

	}

	private static void showdetails() {
		// TODO Auto-generated method stub

	}

	private static void getListCompanies() {
		// TODO Auto-generated method stub

	}

	private static void getListComputers() {
		// TODO Auto-generated method stub

	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CommandLineInterface cli = new CommandLineInterface();
		System.out.println(cli.menuCLI());
		String s = cli.br.readLine();
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

}
