package com.brick.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.brick.helper.LaborHelper;
import com.brick.helper.VehicleInfo;

public class DatabaseHelper {
	private Connection connection = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	public DatabaseHelper() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/brick_inventory", "root",
					"admin");
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

	public int addNewUser(String userName, String password) {
		String query = "INSERT INTO user (username,password) values ('"
				+ userName + "','" + password + "');";
		Statement stmt = null;
		int result = -1;
		try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
	
	public int addNewEmployee(String name, int phone,String pAddress,String tAddress,String post,int salary) {
		String query = "INSERT INTO EMPLOYEE (E_Name,E_Type,PAddress,TAddress,Phone,Salary) values ('"
				+ name + "','" + post + "','" + pAddress + "','" + tAddress + "','" + phone + "','" + salary + "');";
		Statement stmt = null;
		int result = -1;
		try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}


	public int addBrickType(String brickType, String brickDesc,float brickRate) {
		String query = "INSERT INTO brick (brick_type,brick_desc,brick_amount) values ('"
				+ brickType + "','" + brickDesc + "','" + brickRate+ "');";
		Statement stmt = null;
		int result = -1;
		try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public ArrayList<LaborHelper> fetchLaborName() {
		ArrayList<LaborHelper> list = new ArrayList<LaborHelper>();
		String query = "SELECT * From labour";
		try {
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				LaborHelper labor = new LaborHelper();
				labor.id = rs.getInt("id");
				labor.name = rs.getString("name");
				list.add(labor);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<VehicleInfo> fetchVechileInfo() {
		ArrayList<VehicleInfo> list = new ArrayList<VehicleInfo>();
		String query = "SELECT * From vehicle";
		try {
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				VehicleInfo vehicleInfo = new VehicleInfo();
				vehicleInfo.vechileNo = rs.getString("vehicle_no");
				vehicleInfo.vechileId = rs.getInt("vechile_id");
				list.add(vehicleInfo);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public int addNewVechile(String vechileNo, String vechileDesc) {
		String query = "INSERT INTO vehicle (vehicle_no,vechile_desc) values ('"
				+ vechileNo + "','" + vechileDesc + "');";
		Statement stmt = null;
		int result = -1;
		try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public int insertLabour(String name, String type, String brick) {
		if (type == "Patheri") {
			brick = "0";
		}
		String query = "insert into labour(name,type,brick_amount ) values('"
				+ name + "','" + type + "','" + Integer.valueOf(brick) + "');";
		Statement stmt = null;
		int result = -1;
		try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int insertWorkEntry(int labourId, int brickID, int noOfBrick,
			float amount, String date) {

		String query = "insert into labour_transcation(l_id,bd_id,Number,Amount,transcation_date) values('"
				+ labourId
				+ "','"
				+ brickID
				+ "','"
				+ noOfBrick
				+ "','"
				+ amount + "','" + date + "');";
		int result = -1;
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int insertCustomer(String name,String pAddress,String tAddress,int Mobile,int Telephone)
	{
		
		String query="insert into customer(name,PAddress,TAddress,MobileNo,TelephoneNo ) values('"+name+"','"+pAddress+"','"+tAddress+"','"+Mobile+"','"+Telephone+"');";
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

	public float getRate(String type, int brickId) {
		float rate = -1;
		String query = "SELECT brick_distance_amount From brick_distance where Distance_Type='"
				+ type+"'" +"and brick_id='"+brickId+"'" ;
		try {
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()){
				rate = rs.getFloat("brick_distance_amount");
				
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		System.out.println(rate);
		return rate;
	}

}
