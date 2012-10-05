package com.brick.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class Order extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JLabel lblVoucherNo = new JLabel("Voucher No");
	private final JLabel lblVehicleNo = new JLabel("Vehicle No");
	private final JLabel lblDriverName = new JLabel("Driver Name");
	private final JLabel lblBrickType = new JLabel("Brick Type");
	private final JTextField txtVoucherNo = new JTextField();
	private final JComboBox cmbVechile = new JComboBox();
	private final JComboBox comboBox_driver = new JComboBox();
	private final JComboBox comboBox_brick_type = new JComboBox();
	private final JCheckBox chckbxHalf = new JCheckBox("Half");
	private final JTextField txtHalfBrickAmount = new JTextField();

	private final JTextField txtBrickAmount = new JTextField();
	private final JLabel lblCustomerName = new JLabel("Customer Name");
	private final JTextField txtCustomerName = new JTextField();
	private final JButton btnAddNewVehicle = new JButton("Add New Vehicle");
	private final JLabel lblTotal = new JLabel("Total");
	private final JLabel lblAdvance = new JLabel("Advance");
	private final JLabel lblRemainder = new JLabel("Remainder");
	private final JTextField txtTotal = new JTextField();
	private final JTextField txtAdvance = new JTextField();
	private final JTextField txtRemainder = new JTextField();
	private final JButton btnConfirmOrder = new JButton("Confirm Order");
	private final JButton btnAddAnotherType = new JButton("Add Another Type");

	/**
	 * Create the panel.
	 */
	public Order() {

		txtTotal.setBounds(575, 243, 114, 19);
		txtTotal.setColumns(10);
		txtVoucherNo.setBounds(182, 38, 114, 19);
		txtVoucherNo.setColumns(10);
		// add vehicle from database
		cmbVechile.addItem("ba 12 kha 12345");
		cmbVechile.addItem("ba 12 kha 12345");
		cmbVechile.addItem("ba 12 kha 12345");
		cmbVechile.addItem("ba 12 kha 12345");
		cmbVechile.addItem("ba 12 kha 12345");
		cmbVechile.addItem("ba 12 kha 12345");

		// iterate to add driver name from database
		comboBox_driver.addItem("ram hari");
		comboBox_driver.addItem("shyam hari");
		comboBox_driver.addItem("salman khan");
		comboBox_driver.addItem("sharukh khan");
		comboBox_driver.addItem("aamir khan");
		comboBox_driver.addItem("salim khan");
		comboBox_driver.addItem("faijal khan");
		comboBox_driver.addItem("saif ali khan");

		// iterate for addin brick type
		comboBox_brick_type.addItem("kancho");
		comboBox_brick_type.addItem("pako");
		comboBox_brick_type.addItem("class a");
		comboBox_brick_type.addItem("class b");

		// add listner
		txtAdvance.addCaretListener(onTxtAdvanceChangeListner);
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

		add(txtVoucherNo);
		cmbVechile.setBounds(182, 76, 114, 24);

		add(cmbVechile);
		comboBox_driver.setBounds(182, 114, 114, 24);

		add(comboBox_driver);
		comboBox_brick_type.setBounds(182, 154, 114, 24);

		add(comboBox_brick_type);
		chckbxHalf.setBounds(54, 189, 116, 23);

		add(chckbxHalf);
		txtHalfBrickAmount.setColumns(10);
		txtHalfBrickAmount.setBounds(182, 190, 114, 19);

		add(txtHalfBrickAmount);
		txtBrickAmount.setColumns(10);
		txtBrickAmount.setBounds(320, 157, 114, 19);

		add(txtBrickAmount);
		lblCustomerName.setBounds(439, 40, 126, 15);

		add(lblCustomerName);
		txtCustomerName.setColumns(10);
		txtCustomerName.setBounds(579, 38, 138, 19);

		add(txtCustomerName);
		btnAddNewVehicle.setBounds(548, 81, 169, 25);

		add(btnAddNewVehicle);
		lblTotal.setBounds(467, 245, 70, 15);

		add(lblTotal);
		lblAdvance.setBounds(467, 282, 70, 15);

		add(lblAdvance);
		lblRemainder.setBounds(467, 316, 98, 15);

		add(lblRemainder);

		add(txtTotal);
		txtAdvance.setColumns(10);
		txtAdvance.setBounds(575, 280, 114, 19);

		add(txtAdvance);
		txtRemainder.setColumns(10);
		txtRemainder.setBounds(575, 314, 114, 19);

		add(txtRemainder);
		btnConfirmOrder.setBounds(286, 391, 169, 25);

		add(btnConfirmOrder);
		btnConfirmOrder.addActionListener(onConfirmButtonClickListener);
		btnAddAnotherType.setBounds(548, 154, 169, 25);

		add(btnAddAnotherType);
	}

	// add text changelister for txtAdvance
	private CaretListener onTxtAdvanceChangeListner = new CaretListener() {

		@Override
		public void caretUpdate(CaretEvent e) {
			int remainder = Integer.valueOf(txtTotal.getText().toString())
					- Integer.valueOf(txtAdvance.getText().toString());
			txtRemainder.setText(String.valueOf(remainder));

		}
	};
	// add action listner for confirmButton
	private ActionListener onConfirmButtonClickListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			validateField();

		}
	};

	private void validateField() {

		if (txtVoucherNo.getText() == null || txtVoucherNo.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Enter voucher Number",
					"ERROR", JOptionPane.ERROR_MESSAGE);
			txtVoucherNo.requestFocus();
			return;
		}
		if (txtCustomerName.getText() == null
				|| txtCustomerName.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Enter Customer Name", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			txtCustomerName.requestFocus();
			return;
		}
		if (txtBrickAmount.getText() == null
				|| txtBrickAmount.getText().equals("")) {
			JOptionPane.showMessageDialog(null, " Enter no of brik", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			txtBrickAmount.requestFocus();
			return;
		}
		if (chckbxHalf.isSelected()
				&& (txtHalfBrickAmount.getText() == null || txtHalfBrickAmount
						.getText().equals(""))) {
			JOptionPane.showMessageDialog(null, " Enter no of half brick",
					"ERROR", JOptionPane.ERROR_MESSAGE);
			txtHalfBrickAmount.requestFocus();
			return;
		}

	}
}
