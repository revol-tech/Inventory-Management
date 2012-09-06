package com.brick.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseHelper {
	// connConnection connection=null;
	public static Connection getDBConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/BRICK", "root", "admin");
			return connection;
		} catch (Exception ex) {
			return null;
		}

	}

	public boolean checkValidLogin(String username, String passwd) {
		PreparedStatement pst = null;
		ResultSet rs;
		Connection connection = getDBConnection();
		String query = "SELECT * From login";
		try {
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				if (username.equals(rs.getString("name"))
						&& passwd.equals(rs.getString("pwd"))) {
					return true;
				}

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;

	}

}
