package com.brick;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.jws.Oneway;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;

import com.brick.database.DatabaseHelper;

public class AddEntry extends JInternalFrame {

	private JLabel lblVechileNo, lblCheatNo, lblCheatType, lblCapacity,
			lblEntryDate, lblPetrol, lblExitDate, lblName;
	private JTextField txtVechileNo, txtCheatNo, txtCheatType, txtCapacity,
			txtPetrol;
	private JButton btnAddNew, btnCancel, btnClear,btnAddNext;
	private JPanel fieldsPanel;
	private JComboBox<Object> cmbDriver,cmbVehicleNo;

	private JPanel buttonPanel;

	private DateButton date_entry;
	private DateButton date_exit;

	public AddEntry() {
		super("New Vehicle Entry", false, true, false, true);
		setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screen.width - 500) / 2, ((screen.height - 350) / 2));
		lblName = new JLabel("   Driver Name ");

		lblCheatNo = new JLabel("  cheat Number ");
		lblVechileNo = new JLabel("   Number ");
		lblCheatType = new JLabel("  cheat type ");
		lblCapacity = new JLabel("  Capacity ");
		lblEntryDate = new JLabel("  Entry date");
		lblPetrol = new JLabel("  petrol(ltr)");
		lblExitDate = new JLabel("  Exit Date");
		cmbDriver = new JComboBox<Object>();
		cmbVehicleNo=new JComboBox<Object>();
		txtCheatNo = new JTextField(10);
		txtVechileNo = new JTextField(10);
		txtCheatType = new JTextField(10);
		txtCapacity = new JTextField(10);
		txtPetrol = new JTextField(10);
		txtVechileNo.setForeground(Color.blue);
		btnAddNew = new JButton("Add Record");
		btnCancel = new JButton("Cancel");
		btnClear = new JButton("Clear");
		btnAddNext=new JButton("Add Next");
		date_entry = new DateButton();
		
		date_exit = new DateButton();
		
		try {
			Statement stmt1 = DatabaseHelper.getDBConnection().createStatement();
		String Sql="SELECT Driver_Name FROM Driver";
		ResultSet rs=stmt1.executeQuery(Sql);
		while(rs.next()){
			cmbDriver.addItem(rs.getString("Driver_Name"));
		}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Statement stmt1 = DatabaseHelper.getDBConnection().createStatement();
		String Sql="SELECT vehicle_no FROM vehicle";
		ResultSet rs=stmt1.executeQuery(Sql);
		while(rs.next()){
			Object[] cat={rs.getString("vehicle_no"),rs.getString("vehicle_no")};
			cmbVehicleNo.addItem(cat);
			cmbVehicleNo.setRenderer(new cbx());
		}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		//cmbDriver.addItem("ram");
		//cmbDriver.addItem("hari");
		//cmbDriver.addItem("shyam");
		

		date_exit.setForeground(Color.red);
		date_entry.setForeground(Color.blue);

		fieldsPanel = new JPanel(new GridLayout(8, 2));
		buttonPanel = new JPanel(new FlowLayout());

		fieldsPanel.setPreferredSize(new Dimension(400, 250));
		fieldsPanel.add(lblName);
		fieldsPanel.add(cmbDriver);
		fieldsPanel.add(lblCheatNo);
		fieldsPanel.add(txtCheatNo);
		fieldsPanel.add(lblVechileNo);
		fieldsPanel.add(cmbVehicleNo);
		fieldsPanel.add(lblCheatType);
		fieldsPanel.add(txtCheatType);
		fieldsPanel.add(lblCapacity);
		fieldsPanel.add(txtCapacity);
		fieldsPanel.add(lblEntryDate);
		fieldsPanel.add(date_entry);
		fieldsPanel.add(lblPetrol);
		fieldsPanel.add(txtPetrol);
		fieldsPanel.add(lblExitDate);
		fieldsPanel.add(date_exit);

		buttonPanel.add(btnAddNew);
		buttonPanel.add(btnCancel);
		buttonPanel.add(btnClear);
		buttonPanel.add(btnAddNext);

		getContentPane().add(fieldsPanel, BorderLayout.CENTER);
		getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
		pack();
		// generator();

		btnAddNew.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (txtVechileNo.getText() == null
						|| txtVechileNo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter vehicle number",
							"ERROR", JOptionPane.ERROR_MESSAGE);
					txtVechileNo.requestFocus();
					return;
				}

				if (txtCheatNo.getText() == null
						|| txtCheatNo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter Cheat Number",
							"ERROR", JOptionPane.ERROR_MESSAGE);
					txtCheatNo.requestFocus();
					return;
				}
				if (txtCheatType.getText() == null
						|| txtCheatType.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							" cheat type is required", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					txtCheatType.requestFocus();
					return;
				}
				if (txtCapacity.getText() == null
						|| txtCapacity.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							" Enter vehicle capacity", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					txtCapacity.requestFocus();
					return;
				}

				if (txtPetrol.getText() == null
						|| txtPetrol.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"petrol entry is required", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					txtPetrol.requestFocus();
					return;
				}

				try {
					Statement stmt = DatabaseHelper.getDBConnection()
							.createStatement();

					String sql = "INSERT INTO vechileInfo (id,busNo, cheatNo, cheatType, capacity, EntryDate,petrol,ExitDate) "
							+ "VALUES ("
							+ new Random().nextInt(100)
							+ ",'"
							+ txtVechileNo.getText()
							+ "', '"
							+ txtCheatNo.getText()
							+ "', '"
							+ txtCheatType.getText()
							+ "', '"
							+ txtCapacity.getText()
							+ "', '"
							+ date_entry.getText()
							+ "', '"
							+ txtPetrol.getText()
							+ "', '"
							+ date_exit.getText() + "')";

					int result = stmt.executeUpdate(sql);
					String ObjButtons[] = { "Yes", "No" };
					int PromptResult = JOptionPane
							.showOptionDialog(
									null,
									"Record succesfully added.Do you want to add another?",
									"Success", JOptionPane.INFORMATION_MESSAGE,
									JOptionPane.WARNING_MESSAGE, null,
									ObjButtons, ObjButtons[1]);
					if (PromptResult == 0) {
						
						txtVechileNo.setText("");
						txtCheatNo.setText("");
						txtCheatType.setText("");
						txtCapacity.setText("");
						txtPetrol.setText("");
								
					} else {
						dispose();
					}
				} catch (SQLException sqlex) {
					JOptionPane.showMessageDialog(null,
							"Error on database operation", "Failure",
							JOptionPane.ERROR_MESSAGE);
				}// try catch closed

			}
		});

		btnCancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnClear.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				txtVechileNo.setText("");
				txtCheatNo.setText("");
				txtCheatType.setText("");
				txtCapacity.setText("");
				txtPetrol.setText("");
			}
		});
	}
	public class cbx extends JLabel implements ListCellRenderer<Object>{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public Component getListCellRendererComponent(
				JList<? extends Object> list, Object value, int index,
				boolean isSelected, boolean cellHasFocus) {
			Object[] tt=(Object[])value;
			setText((String)tt[1]);
			return list;
		}
		
	}
}// class closed

