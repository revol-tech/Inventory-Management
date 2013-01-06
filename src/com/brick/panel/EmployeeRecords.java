package com.brick.panel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import com.brick.database.DatabaseHelper;
import com.mysql.jdbc.ResultSetMetaData;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class EmployeeRecords extends JPanel {
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JLabel lblEmployeeRecords = new JLabel("Employee Records");
	private final JScrollPane scrollPane = new JScrollPane();
	JTable table;
	DatabaseHelper databaseHelper = new DatabaseHelper();
	Vector row;
	Vector columnNames = new Vector();
    Vector data = new Vector();
    DefaultTableModel test;

	/**
	 * Create the panel.
	 */
	public EmployeeRecords() {

		initGUI();
	}
	private void initGUI() {
		setLayout(new BorderLayout(0, 0));
		
		add(panel, BorderLayout.CENTER);
		panel_1.setBackground(Color.GRAY);
		
		add(panel_1, BorderLayout.NORTH);
		lblEmployeeRecords.setForeground(new Color(0, 191, 255));
		lblEmployeeRecords.setFont(new Font("Dialog", Font.BOLD, 16));
		
		panel_1.add(lblEmployeeRecords);
		
		add(scrollPane, BorderLayout.CENTER);
		try{
			ResultSet resultSet = databaseHelper.fetchEmployee();
			ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();
	        int columns = metaData.getColumnCount();
	        
	        for (int i = 1; i <= columns; i++) {
	            columnNames.addElement(metaData.getColumnName(i));
	        }
	        
	        data.removeAllElements();
	        while (resultSet.next()) {
	             row = new Vector(columns);
	            for (int i = 1; i <= columns; i++) {
	                row.addElement(resultSet.getObject(i));
	            }
	            
	            data.addElement(row);
	        }
			}catch (SQLException e) {

				e.printStackTrace();
			}
			
			
			test = new DefaultTableModel(data, columnNames);
		 table = new JTable(test);
			
		 int count =table.getRowCount();
		 System.err.println(count); 
		 int count1 =scrollPane.countComponents();
		 System.err.println(count1);
		 table.revalidate();
		 scrollPane.setViewportView(table);
		 

		
		scrollPane.setViewportView(table);

	}

}
