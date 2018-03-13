/**
 * 
 */
package com.excilys.formation.java.computerdatabase.persistence;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author excilys
 *
 */
public enum DBConnection {

	INSTANCE;

	/**
	 * 
	 */

	private Connection conn;
	private static final String PROPERTIES_FILE = "WebContent/WEB-INF/dao.properties";
	private static final String PROPERTY_URL = "url";
	private static final String PROPERTY_DRIVER = "driver";
	private static final String PROPERTY_NOM_UTILISATEUR = "utilisateur";
	private static final String PROPERTY_PASSWORD = "password";

	public Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
		String url;
		String driver;
		String utilisateur;
		String password;
		/* Chargement du driver JDBC pour MySQL */
		Properties properties = new Properties();
		InputStream fichierProperties = new FileInputStream(PROPERTIES_FILE);

		properties.load(fichierProperties);
		url = properties.getProperty(PROPERTY_URL);
		driver = properties.getProperty(PROPERTY_DRIVER);
		utilisateur = properties.getProperty(PROPERTY_NOM_UTILISATEUR);
		password = properties.getProperty(PROPERTY_PASSWORD);

		Class.forName(driver);
		conn = DriverManager.getConnection(url, utilisateur, password);

		return conn;
	}

	public static void closeConnection(ResultSet rs, Statement stat, Connection conn) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (stat != null) {
			stat.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
}
