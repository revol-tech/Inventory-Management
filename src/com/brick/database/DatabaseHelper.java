package com.brick.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.brick.helper.BrickHelper;
import com.brick.helper.CustomerHelper;
import com.brick.helper.EmployeeHelper;
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

		public void insertOrder(String name) {

		String query = "";
	}

	public String fetchlabourtype(int id)
	{
		String result="";
		String query = "SELECT type From labour where id ='"+id+"'";
		try {
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				result = rs.getString("type");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return result;

		
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

	
	
	public ArrayList<EmployeeHelper> fetchDriverName() {
		ArrayList<EmployeeHelper> list = new ArrayList<EmployeeHelper>();
		String query = "SELECT * From employee where E_Type='driver'";
		System.out.println("check");
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

	public ArrayList<EmployeeHelper> fetchEmployeeName() {
		ArrayList<EmployeeHelper> list = new ArrayList<EmployeeHelper>();
		String query = "SELECT * From employee";
		System.out.println("check");
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

	
	public ResultSet fetchworkdetail(int labourid) throws SQLException {

		String query = "SELECT L.name, L.type, SUM(LT.Amount) ,B.brick_type, LT.transcation_date, BD.Distance_Type FROM labour L, labour_transcation LT,brick_distance BD,brick B WHERE L.id ='"+labourid+"' AND L.id=LT.l_id AND BD.bd_id = LT.bd_id AND B.brick_id=BD.brick_id group by L.name, L.type,B.brick_type, LT.transcation_date, BD.Distance_Type;";
		Statement stmt = null;
		String errorMessage = "";
		//int result = -1;
	
			stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(query);
			return result;
		//return new Object[] { result,errorMessage };


	}
	
	public ResultSet fetchpatheri(int labourid) throws SQLException {

		String query = "SELECT L.name, L.type, SUM(LT.Amount) , LT.transcation_date FROM labour L, labour_transcation LT WHERE L.id=LT.l_id AND L.id='"+labourid+"' group by L.name, L.type, LT.transcation_date ;";
		Statement stmt = null;
		String errorMessage = "";
		//int result = -1;
	
			stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(query);
			return result;
		//return new Object[] { result,errorMessage };


	}
	
	public ResultSet fetchattendance(int empid) throws SQLException {

		String query = "Select Date,Absent,Leaves,Reason From attendance WHERE MONTH((Date)) = 11 AND E_id='"+empid+"';";
		Statement stmt = null;
		String errorMessage = "";
	
			stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(query);
			return result;
		


	}


	
	public ResultSet fetchorder() throws SQLException {

		String query = "SELECT C.name,OE.destination,OE.no_of_brick,OE.no_of_halfbrick from order_entry OE,customer C where OE.customer_id=C.id;";
		Statement stmt = null;
		String errorMessage = "";
		//int result = -1;
	
			stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(query);
			return result;
		//return new Object[] { result,errorMessage };


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

	public int addNewEmployee(String name, int phone, String pAddress,
			String tAddress, String post, int salary) {
		String query = "INSERT INTO employee (E_Name,E_Type,PAddress,TAddress,Phone,Salary) values ('"
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
				labor.type = rs.getString("type");
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
	
	public int insertabsent(int e_id, Date date , int absent, int leave, String reason) {
System.err.println(date);
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
String currentDate = dateFormat.format(date);
		String query = "insert into attendance(`E_id`,`Date`,`Absent`,`Leaves`,`Reason`) values('"+e_id+"','"+currentDate+"','"+absent+"','"+leave+"','"+reason+"');";
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
	
	public ArrayList<CustomerHelper> getCustomer() {

		ArrayList<CustomerHelper> list = new ArrayList<CustomerHelper>();
		String query = "SELECT * From customer";
		try {
		pst = connection.prepareStatement(query);
		rs = pst.executeQuery();
		while (rs.next()) {
		CustomerHelper customerInfo = new CustomerHelper();
		customerInfo.id = rs.getInt("id");
		customerInfo.name = rs.getString("name");
		list.add(customerInfo);
		}
		} catch (SQLException e) {

		e.printStackTrace();
		}
		return list;

		}
	
	public int insertOrderEntry( int cust_id, String destination,
			int noOfBrick, int halfBrick) {
			String query = "insert into order_entry(customer_id,destination,no_of_brick,no_of_halfbrick ) values('"
			+ cust_id
			+ "','"
			+ destination
			+ "','"
			+ noOfBrick
			+ "','"
			+ halfBrick + "');";
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
