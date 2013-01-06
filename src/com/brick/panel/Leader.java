package com.brick.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;

public class Leader extends JPanel {
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JLabel lblAddNewLeader = new JLabel("Add New Leader");
	private final JLabel lblLeaderName = new JLabel("Leader Name");
	private final JTextField textField = new JTextField();
	private final JLabel lblAddress = new JLabel("Address");
	private final JTextField textField_1 = new JTextField();
	private final JLabel lblMobileNo = new JLabel("Mobile No.");
	private final JTextField textField_2 = new JTextField();
	private final JLabel lblTelephoneNo = new JLabel("Telephone No.");
	private final JTextField textField_3 = new JTextField();
	private final JLabel lblRate = new JLabel("Rate");
	private final JTextField textField_4 = new JTextField();
	private final JButton btnAddLeader = new JButton("Add Leader");

	/**
	 * Create the panel.
	 */
	public Leader() {
		textField_4.setFont(new Font("Dialog", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField.setFont(new Font("Dialog", Font.PLAIN, 14));
		textField.setColumns(10);

		initGUI();
	}
	private void initGUI() {
		setLayout(new BorderLayout(0, 0));
		
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowHeights = new int[]{45, 45, 45, 45, 45, 80};
		gbl_panel.columnWidths = new int[]{160, 160};
		//gbl_panel.columnWidths = new int[]{164, 0, 0};
		//gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		GridBagConstraints gbc_lblLeaderName = new GridBagConstraints();
		gbc_lblLeaderName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLeaderName.anchor = GridBagConstraints.WEST;
		gbc_lblLeaderName.gridx = 0;
		gbc_lblLeaderName.gridy = 0;
		lblLeaderName.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblLeaderName, gbc_lblLeaderName);
		
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(7, 0, 7, 0);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.WEST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 1;
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblAddress, gbc_lblAddress);
		
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(7, 0, 7, 0);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		panel.add(textField_1, gbc_textField_1);
		
		GridBagConstraints gbc_lblMobileNo = new GridBagConstraints();
		gbc_lblMobileNo.anchor = GridBagConstraints.WEST;
		gbc_lblMobileNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblMobileNo.gridx = 0;
		gbc_lblMobileNo.gridy = 2;
		lblMobileNo.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblMobileNo, gbc_lblMobileNo);
		
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(7, 0, 7, 0);
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		panel.add(textField_2, gbc_textField_2);
		
		GridBagConstraints gbc_lblTelephoneNo = new GridBagConstraints();
		gbc_lblTelephoneNo.anchor = GridBagConstraints.WEST;
		gbc_lblTelephoneNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelephoneNo.gridx = 0;
		gbc_lblTelephoneNo.gridy = 3;
		lblTelephoneNo.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblTelephoneNo, gbc_lblTelephoneNo);
		
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(7, 0, 7, 0);
		gbc_textField_3.fill = GridBagConstraints.BOTH;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 3;
		panel.add(textField_3, gbc_textField_3);
		
		GridBagConstraints gbc_lblRate = new GridBagConstraints();
		gbc_lblRate.anchor = GridBagConstraints.WEST;
		gbc_lblRate.insets = new Insets(0, 0, 5, 5);
		gbc_lblRate.gridx = 0;
		gbc_lblRate.gridy = 4;
		lblRate.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblRate, gbc_lblRate);
		
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(7, 0, 7, 0);
		gbc_textField_4.fill = GridBagConstraints.BOTH;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 4;
		panel.add(textField_4, gbc_textField_4);
		
		GridBagConstraints gbc_btnAddLeader = new GridBagConstraints();
		gbc_btnAddLeader.anchor = GridBagConstraints.SOUTH;
		gbc_btnAddLeader.gridwidth = 2;
		gbc_btnAddLeader.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddLeader.gridx = 0;
		gbc_btnAddLeader.gridy = 5;
		panel.add(btnAddLeader, gbc_btnAddLeader);
		panel_1.setBackground(Color.GRAY);
		
		add(panel_1, BorderLayout.NORTH);
		lblAddNewLeader.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAddNewLeader.setForeground(new Color(0, 255, 255));
		
		panel_1.add(lblAddNewLeader);
	}

}
