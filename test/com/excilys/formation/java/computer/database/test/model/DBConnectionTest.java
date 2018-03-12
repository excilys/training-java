package com.excilys.formation.java.computer.database.test.model;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.excilys.formation.java.computerdatabase.persistence.DBConnection;


public class DBConnectionTest {

	@Test
	public void test() throws ClassNotFoundException, SQLException, IOException {
		Connection conn = DBConnection.getConnection();
		assertNotNull(conn);
	}

}
