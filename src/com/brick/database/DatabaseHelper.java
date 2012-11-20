package com.brick.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.brick.helper.BrickHelper;
import com.brick.helper.CustomerHelper;
import com.brick.helper.EmployeeHelper;
import com.brick.helper.LaborHelper;
import com.brick.helper.VehicleInfo;
import com.brick.panel.Customer;

public class DatabaseHelper {
	private Connection connection = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

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

	public int addNewEmployee(String name, int phone, String pAddress,
			String tAddress, String post, int salary) {
		String query = "INSERT INTO EMPLOYEE (E_Name,E_Type,PAddress,TAddress,Phone,Salary) values ('"
				+ name
				+ "','"
				+ post
				+ "','"
				+ pAddress
				+ "','"
				+ tAddress
				+ "','" + phone + "','" + salary + "');";
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

	public void insertOrder(String name) {

		String query = "";
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

	public ArrayList<CustomerHelper> fetchCustomerName() {
		ArrayList<CustomerHelper> list = new ArrayList<CustomerHelper>();
		String query = "SELECT * From customer";
		try {
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				CustomerHelper customer = new CustomerHelper();
				customer.id = rs.getInt("id");
				customer.name = rs.getString("name");
				list.add(customer);
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

	public ArrayList<EmployeeHelper> fetchDriverName() {
		ArrayList<EmployeeHelper> list = new ArrayList<EmployeeHelper>();
		String query = "SELECT * From EMPLOYEE where E_Type='driver'";
		try {
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				EmployeeHelper driverName = new EmployeeHelper();
				driverName.id = rs.getInt("E_id");
				driverName.name = rs.getString("E_Name");
				list.add(driverName);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<BrickHelper> fetchBrickName() {
		ArrayList<BrickHelper> list = new ArrayList<BrickHelper>();
		String query = "SELECT * From brick";
		try {
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				BrickHelper brickName = new BrickHelper();
				brickName.id = rs.getInt("brick_id");
				brickName.name = rs.getString("brick_type");
				list.add(brickName);
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

	public int insertCustomer(String name, String pAddress, String tAddress,
			int Mobile, int Telephone) {

		String query = "insert into customer(name,PAddress,TAddress,MobileNo,TelephoneNo ) values('"
				+ name
				+ "','"
				+ pAddress
				+ "','"
				+ tAddress
				+ "','"
				+ Mobile
				+ "','" + Telephone + "');";
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

	public Object insertOrderDelivery(String voucher, int vehicle, int driver,
			int brick, int half, int customer, String destination) {

		String query = "insert into OrderDelivery(VoucherNo,vechile_id,E_id,brick_id,id,destination,HalfBrick) values('"
				+ voucher
				+ "','"
				+ vehicle
				+ "','"
				+ driver
				+ "','"
				+ brick
				+ "','" + customer + "','" + destination + "','" + half + "');";
		Statement stmt = null;
		String errorMessage = "";
		int result = -1;
		try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
		} catch (Exception e) {
			errorMessage = e.getMessage();
			e.printStackTrace();
		}
		return new Object[] { result,errorMessage };
	}

}
