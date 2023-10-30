package com.spring.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

	  private static final Integer port = 5432;

	  /**
	   * Pour communiquer avec PostgresSql
	  */
	  private Connection connexion;

	  /**
	   * Constructeur sans connexion
	  */
	 public TestJdbc() throws ClassNotFoundException {
	        /* On commence par "charger" le pilote postgresql */
	        Class.forName("org.postgresql.Driver");
	  }
	 
	 public void connect(String server, String bd, String u, String p)
             throws SQLException {
		 //jdbc:postgresql://localhost:5432/springDemo
     String url = "jdbc:postgresql://" + server + ":" + port + "/" + bd;
     connexion = DriverManager.getConnection(url, u, p);
	 }
	 
	 public void disconnect()throws SQLException {
		 
		 if(connexion!=null) {
			 
			 connexion.close();
			 
		 }
	 }

	public Connection getConnexion() {
		return connexion;
	}
	 
}
