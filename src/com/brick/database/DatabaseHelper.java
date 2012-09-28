package com.brick.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {
	private Connection connection = null;
	private PreparedStatement pst = null;
	private ResultSet rs=null;

	public DatabaseHelper() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/brick_inventory", "root",
					"shresthas");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean checkValidLogin(String userName, String password) {

		String query = "SELECT * From user";
		try {
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				if (userName.equals(rs.getString("username"))
						&& password.equals(rs.getString("password"))) {
					return true;
				}

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}
	public int addNewUser(String userName,String password){
		String query="INSERT INTO user (username,password) values ('"+userName +"','"+password+"');";
		Statement stmt=null;
		int result=-1;
		try{
			stmt=connection.createStatement();
			result=stmt.executeUpdate(query);
			return result;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public int insertVehicle(String number,String desc)
	{
		String query="insert into vehicle(vehicle_no,Vechile_desc ) values('"+number+"','"+desc+"');";
		Statement stmt = null;
		int result =-1;
		try {
			stmt=connection.createStatement();
			result= stmt.executeUpdate(query);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int insertLabour(String name,String type,String brick)
	{
		if (type=="Patheri")
		{
			brick="0";
		}
		String query="insert into labour(name,type,brick_amount ) values('"+name+"','"+type+"','"+brick+"');";
		Statement stmt = null;
		int result =-1;
		try {
			stmt=connection.createStatement();
			result= stmt.executeUpdate(query);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void insertOrder(String name){
		
		String query="";
	}
	

}
