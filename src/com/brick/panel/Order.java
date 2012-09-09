package com.brick.panel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Order extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JLabel lblVoucherNo = new JLabel("Voucher No");
	private final JLabel lblVehicleNo = new JLabel("Vehicle No");
	private final JLabel lblDriverName = new JLabel("Driver Name");
	private final JLabel lblBrickType = new JLabel("Brick Type");
	private final JTextField textField = new JTextField();
	private final JComboBox<String> comboBox = new JComboBox<String>();
	private final JComboBox<String> comboBox_1 = new JComboBox<String>();
	private final JComboBox<String> comboBox_2 = new JComboBox<String>();
	private final JCheckBox chckbxHalf = new JCheckBox("Half");
	private final JTextField textField_1 = new JTextField();
	private final JTextField textField_2 = new JTextField();
	private final JLabel lblCustomerName = new JLabel("Customer Name");
	private final JTextField textField_3 = new JTextField();
	private final JButton btnAddNewVehicle = new JButton("Add New Vehicle");
	private final JLabel lblTotal = new JLabel("Total");
	private final JLabel lblAdvance = new JLabel("Advance");
	private final JLabel lblRemainder = new JLabel("Remainder");
	private final JTextField textField_4 = new JTextField();
	private final JTextField textField_5 = new JTextField();
	private final JTextField textField_6 = new JTextField();
	private final JButton btnConfirmOrder = new JButton("Confirm Order");
	private final JButton btnAddAnotherType = new JButton("Add Another Type");

	/**
	 * Create the panel.
	 */
	public Order() {
		textField_4.setBounds(575, 243, 114, 19);
		textField_4.setColumns(10);
		textField.setBounds(182, 38, 114, 19);
		textField.setColumns(10);

		initGUI();
	}
	private void initGUI() {
		
		setLayout(null);
		setSize(500, 1500);
		lblVoucherNo.setBounds(59, 40, 111, 15);
		
		add(lblVoucherNo);
		lblVehicleNo.setBounds(59, 81, 111, 15);
		
		add(lblVehicleNo);
		lblDriverName.setBounds(59, 119, 111, 15);
		
		add(lblDriverName);
		lblBrickType.setBounds(59, 159, 111, 15);
		
		add(lblBrickType);
		
		add(textField);
		comboBox.setBounds(182, 76, 114, 24);
		
		add(comboBox);
		comboBox_1.setBounds(182, 114, 114, 24);
		
		add(comboBox_1);
		comboBox_2.setBounds(182, 154, 114, 24);
		
		add(comboBox_2);
		chckbxHalf.setBounds(54, 189, 116, 23);
		
		add(chckbxHalf);
		textField_1.setColumns(10);
		textField_1.setBounds(182, 190, 114, 19);
		
		add(textField_1);
		textField_2.setColumns(10);
		textField_2.setBounds(320, 157, 114, 19);
		
		add(textField_2);
		lblCustomerName.setBounds(439, 40, 126, 15);
		
		add(lblCustomerName);
		textField_3.setColumns(10);
		textField_3.setBounds(579, 38, 138, 19);
		
		add(textField_3);
		btnAddNewVehicle.setBounds(548, 81, 169, 25);
		
		add(btnAddNewVehicle);
		lblTotal.setBounds(467, 245, 70, 15);
		
		add(lblTotal);
		lblAdvance.setBounds(467, 282, 70, 15);
		
		add(lblAdvance);
		lblRemainder.setBounds(467, 316, 98, 15);
		
		add(lblRemainder);
		
		add(textField_4);
		textField_5.setColumns(10);
		textField_5.setBounds(575, 280, 114, 19);
		
		add(textField_5);
		textField_6.setColumns(10);
		textField_6.setBounds(575, 314, 114, 19);
		
		add(textField_6);
		btnConfirmOrder.setBounds(286, 391, 169, 25);
		
		add(btnConfirmOrder);
		btnAddAnotherType.setBounds(548, 154, 169, 25);
		
		add(btnAddAnotherType);
	}
}
