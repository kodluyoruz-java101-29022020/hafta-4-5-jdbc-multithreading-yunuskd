package db.connection.mysql.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	private final static String dbHost = "jdbc:mysql://remotemysql.com:3306/S9HHYQdP81?useSSL=false";
	private final static String userName = "S9HHYQdP81";
	private final static String password = "7mR2jSrEgT";
	private final static String jdbcDriver = "com.mysql.jdbc.Driver";
	
	private static Connection connection = null;
	
	public static Connection getDbConnection() {
		
		try {
			if(connection == null) {
				
				Class.forName(jdbcDriver);
				connection = DriverManager.getConnection(dbHost, userName, password);
			}
			return connection;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
