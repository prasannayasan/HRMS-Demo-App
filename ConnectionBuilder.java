/**
 * 
 */
package com.ajg.employee;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionBuilder 
{
	private static Connection connection;
	private static String  url;
	private static String user;
	private static String pass;
	
	public static Connection getconnection()
	{
		try {
				FileReader filereader = new FileReader("C:\\Users\\yasan\\eclipse-workspace\\projectdb\\src\\com\\ajg\\employee\\JDBC.properties");
				Properties property = new Properties();
				property.load(filereader);
				url = property.getProperty("url");
				user = property.getProperty("user");
				pass = property.getProperty("pass");
				
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connection = DriverManager.getConnection(url, user, pass);
				
			}catch (Exception e) 
			{
				System.out.println("Error while connecting");
			}
		return connection;
	}

}