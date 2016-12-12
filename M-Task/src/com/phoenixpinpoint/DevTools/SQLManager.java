/*********************************************
 * SQLManager Version 1.0
 * Build:
 * 	Major: 4152016
 *  Minor: 134401
 * 
 * Created by phoenixpinpoint
 * 
 * 
 * Class: SQLManager
 * Version: 41520161344
 * 
 * SQLManager for ctlhelp database. 
 * 
 * Support: 
 * *********************************************/
package com.phoenixpinpoint.DevTools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLManager {
	//MySQL Driver information and Database URL 
	String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	String DB_URL = "jdbc:mysql://127.0.0.1:3306/mtask_db";
	
	//User Credentials for MySQL
	String USER = "root";
	String PASS = "iamroot";
	
	//Createing NULL Connection and statement ot filled later
	Connection conn = null;
	java.sql.Statement stmt;
	
	//Check to see if SQL driver and connection can be established and create connection.
	public void setupSQL()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public SQLManager()
	{
		setupSQL();
	}
}
