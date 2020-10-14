package model;
/**
 * 
 * @author 	  - Akash Rampura Dhananjaya
 * CWID: 	  - A20399053
 * Date 	  - Apr 17 2019
 * File name  - DBConnect.java
 * Lab number - Lab04
 */
import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.SQLException;
  
public class DBConnect {
 
	
	static final String DB_URL = "jdbc:mysql://www.papademas.net:3307/510labs?autoReconnect=true&useSSL=false";
	// Database credentials
	static final String USER = "db510", PASS = "510";
	
	


	public  Connection connect() throws SQLException {

		return DriverManager.getConnection(DB_URL, USER, PASS);

	}
}


