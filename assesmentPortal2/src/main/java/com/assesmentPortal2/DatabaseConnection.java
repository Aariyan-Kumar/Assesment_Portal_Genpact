package com.assesmentPortal2;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/assessmentportal2";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connection = null;
    
	public static Connection getConnection () throws SQLException {
		if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("DataBase Connection Successful: "+connection);
            } catch (ClassNotFoundException e) {
                System.out.println("MySQL JDBC Driver not found!");
                e.printStackTrace();
            }
        }
		return connection;
		
	}
}
