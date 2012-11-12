package com.brick.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class Employee extends JPanel {
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JButton button = new JButton("");
	private final JLabel lblAddNewEmployee = new JLabel("Add New Employee");
	private final JLabel lblEmployeeName = new JLabel("Employee Name");
	private final JLabel lblPhoneNo = new JLabel("Phone No");
	private final JLabel lblPermanentAddress = new JLabel("Permanent Address");
	private final JLabel lblTemporaryAddress = new JLabel("Temporary Address");
	private final JLabel lblPost = new JLabel("Post");
	private final JLabel lblSalary = new JLabel("Salary");
	private final JTextField txtEmployeeName = new JTextField();
	private final JTextField txtPhoneNo = new JTextField();
	private final JTextField txtPermanentAddress = new JTextField();
	private final JTextField txtTemporaryAddress = new JTextField();
	private final JTextField txtPost = new JTextField();
	private final JTextField txtSalary = new JTextField();
	private final JButton btnCreate = new JButton("Create");

	/**
	 * Create the panel.
	 */
	public Employee() {
		txtSalary.setColumns(10);
		txtPost.setColumns(10);
		txtTemporaryAddress.setColumns(10);
		txtPermanentAddress.setColumns(10);
		txtPhoneNo.setColumns(10);
		txtEmployeeName.setColumns(10);

		initGUI();
	}
	private void initGUI() {
		setLayout(new BorderLayout(0, 0));
		
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{171, 180};
		gbl_panel.rowHeights = new int[]{45, 45, 45, 45, 45, 45, 45, 80};
		//gbl_panel.columnWidths = new int[]{0, 0, 0};
		//gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		GridBagConstraints gbc_lblEmployeeName = new GridBagConstraints();
		gbc_lblEmployeeName.anchor = GridBagConstraints.WEST;
		gbc_lblEmployeeName.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmployeeName.gridx = 0;
		gbc_lblEmployeeName.gridy = 0;
		lblEmployeeName.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblEmployeeName, gbc_lblEmployeeName);
		
		GridBagConstraints gbc_txtEmployeeName = new GridBagConstraints();
		gbc_txtEmployeeName.insets = new Insets(7, 0, 7, 0);
		gbc_txtEmployeeName.fill = GridBagConstraints.BOTH;
		gbc_txtEmployeeName.gridx = 1;
		gbc_txtEmployeeName.gridy = 0;
		panel.add(txtEmployeeName, gbc_txtEmployeeName);
		
		GridBagConstraints gbc_lblPhoneNo = new GridBagConstraints();
		gbc_lblPhoneNo.anchor = GridBagConstraints.WEST;
		gbc_lblPhoneNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNo.gridx = 0;
		gbc_lblPhoneNo.gridy = 1;
		lblPhoneNo.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblPhoneNo, gbc_lblPhoneNo);
		
		GridBagConstraints gbc_txtPhoneNo = new GridBagConstraints();
		gbc_txtPhoneNo.insets = new Insets(7, 0, 7, 0);
		gbc_txtPhoneNo.fill = GridBagConstraints.BOTH;
		gbc_txtPhoneNo.gridx = 1;
		gbc_txtPhoneNo.gridy = 1;
		panel.add(txtPhoneNo, gbc_txtPhoneNo);
		
		GridBagConstraints gbc_lblPermanentAddress = new GridBagConstraints();
		gbc_lblPermanentAddress.anchor = GridBagConstraints.WEST;
		gbc_lblPermanentAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblPermanentAddress.gridx = 0;
		gbc_lblPermanentAddress.gridy = 2;
		lblPermanentAddress.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblPermanentAddress, gbc_lblPermanentAddress);
		
		GridBagConstraints gbc_txtPermanentAddress = new GridBagConstraints();
		gbc_txtPermanentAddress.insets = new Insets(7, 0, 7, 0);
		gbc_txtPermanentAddress.fill = GridBagConstraints.BOTH;
		gbc_txtPermanentAddress.gridx = 1;
		gbc_txtPermanentAddress.gridy = 2;
		panel.add(txtPermanentAddress, gbc_txtPermanentAddress);
		
		GridBagConstraints gbc_lblTemporaryAddress = new GridBagConstraints();
		gbc_lblTemporaryAddress.anchor = GridBagConstraints.WEST;
		gbc_lblTemporaryAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblTemporaryAddress.gridx = 0;
		gbc_lblTemporaryAddress.gridy = 3;
		lblTemporaryAddress.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblTemporaryAddress, gbc_lblTemporaryAddress);
		
		GridBagConstraints gbc_txtTemporaryAddress = new GridBagConstraints();
		gbc_txtTemporaryAddress.insets = new Insets(7, 0, 7, 0);
		gbc_txtTemporaryAddress.fill = GridBagConstraints.BOTH;
		gbc_txtTemporaryAddress.gridx = 1;
		gbc_txtTemporaryAddress.gridy = 3;
		panel.add(txtTemporaryAddress, gbc_txtTemporaryAddress);
		
		GridBagConstraints gbc_lblPost = new GridBagConstraints();
		gbc_lblPost.anchor = GridBagConstraints.WEST;
		gbc_lblPost.insets = new Insets(0, 0, 5, 5);
		gbc_lblPost.gridx = 0;
		gbc_lblPost.gridy = 5;
		lblPost.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblPost, gbc_lblPost);
		
		GridBagConstraints gbc_txtPost = new GridBagConstraints();
		gbc_txtPost.insets = new Insets(7, 0, 7, 0);
		gbc_txtPost.fill = GridBagConstraints.BOTH;
		gbc_txtPost.gridx = 1;
		gbc_txtPost.gridy = 5;
		panel.add(txtPost, gbc_txtPost);
		
		GridBagConstraints gbc_lblSalary = new GridBagConstraints();
		gbc_lblSalary.anchor = GridBagConstraints.WEST;
		gbc_lblSalary.insets = new Insets(0, 0, 5, 5);
		gbc_lblSalary.gridx = 0;
		gbc_lblSalary.gridy = 6;
		lblSalary.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblSalary, gbc_lblSalary);
		
		GridBagConstraints gbc_txtSalary = new GridBagConstraints();
		gbc_txtSalary.insets = new Insets(7, 0, 7, 0);
		gbc_txtSalary.fill = GridBagConstraints.BOTH;
		gbc_txtSalary.gridx = 1;
		gbc_txtSalary.gridy = 6;
		panel.add(txtSalary, gbc_txtSalary);
		
		GridBagConstraints gbc_btnCreate = new GridBagConstraints();
		gbc_btnCreate.insets = new Insets(0, 100, 0, 100);
		gbc_btnCreate.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreate.anchor = GridBagConstraints.SOUTH;
		gbc_btnCreate.gridwidth = 2;
		gbc_btnCreate.gridx = 0;
		gbc_btnCreate.gridy = 7;
		btnCreate.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(btnCreate, gbc_btnCreate);
		
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_2.setBackground(Color.GRAY);
		
		panel_1.add(panel_2);
		lblAddNewEmployee.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAddNewEmployee.setForeground(new Color(0, 191, 255));
		
		panel_2.add(lblAddNewEmployee);
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_3.setBackground(Color.GRAY);
		
		panel_1.add(panel_3);
		button.setIcon(new ImageIcon("images/exit.png"));
		
		panel_3.add(button);
	}
}
