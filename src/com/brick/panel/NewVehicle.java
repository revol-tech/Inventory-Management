package com.brick.panel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class NewVehicle extends JPanel {
	private final JLabel lblVehicleNumber = new JLabel("Vehicle Number");
	private final JLabel lblVehicleDescription = new JLabel("Vehicle Description");
	private final JButton btnSubmit = new JButton("Submit");
	private final JButton btnCancle = new JButton("Cancle");
	private final JTextField textField = new JTextField();
	private final JTextField textField_1 = new JTextField();
	private final JLabel lblVehicle = new JLabel("New Vehicle Information");

	/**
	 * Create the panel.
	 */
	public NewVehicle() {
		textField_1.setBounds(253, 104, 145, 19);
		textField_1.setColumns(10);
		textField.setBounds(256, 60, 141, 19);
		textField.setColumns(10);

		initGUI();
	}
	private void initGUI() {
		setLayout(null);
		lblVehicleNumber.setBounds(98, 62, 139, 15);
		
		add(lblVehicleNumber);
		lblVehicleDescription.setBounds(98, 103, 148, 15);
		
		add(lblVehicleDescription);
		btnSubmit.setBounds(83, 211, 117, 25);
		
		add(btnSubmit);
		btnCancle.setBounds(247, 211, 117, 25);
		
		add(btnCancle);
		
		add(textField);
		
		add(textField_1);
		lblVehicle.setFont(new Font("Dialog", Font.BOLD, 14));
		lblVehicle.setVerticalAlignment(SwingConstants.TOP);
		lblVehicle.setBounds(114, 12, 250, 25);
		
		add(lblVehicle);
	}
}
