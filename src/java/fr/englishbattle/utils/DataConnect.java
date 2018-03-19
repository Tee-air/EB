package fr.englishbattle.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnect {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		String url = "jdbc:mysql://localhost:3306/englishbbattle?useSSL=false";
		String user = "root";
		String password = "";
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		return connection;
	}

	public static void closeConnection(Connection connection) throws SQLException {
		connection.close();
	}
}
