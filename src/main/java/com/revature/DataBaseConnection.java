package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	 
	 private static Connection con = null;
	 private DataBaseConnection() {
		 
	 }

	public static Connection getConnection()
	{
		if(con==null){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/p0_brms","root","root08");
		} 
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		}		
		return con;
	}
	
}