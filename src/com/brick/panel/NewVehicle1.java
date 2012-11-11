package com.brick.panel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.brick.database.DatabaseHelper;

public class NewVehicle1 extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JLabel lblVehicleNumber = new JLabel("Vehicle Number");
	private final JLabel lblVehicleDescription = new JLabel(
			"Vehicle Description");
	private final JButton btnSubmit = new JButton("Submit");
	private final JButton btnCancel = new JButton("Cancel");
	private final JTextField txtVehicleNo = new JTextField();
	private final JTextField txtVechileDesc = new JTextField();
	private final JLabel lblVehicle = new JLabel("New Vehicle Information");

	/**
	 * Create the panel.
	 */
	public NewVehicle1() {
		txtVechileDesc.setBounds(253, 104, 145, 19);
		txtVechileDesc.setColumns(10);
		txtVehicleNo.setBounds(256, 60, 141, 19);
		txtVehicleNo.setColumns(10);

		initGUI();
	}

	private void initGUI() {
		setLayout(null);
		lblVehicleNumber.setBounds(98, 62, 139, 15);

		add(lblVehicleNumber);
		lblVehicleDescription.setBounds(98, 103, 148, 15);

		add(lblVehicleDescription);
		btnSubmit.setBounds(83, 211, 117, 25);
		btnSubmit.addActionListener(new ButtonListener());
		add(btnSubmit);

		btnCancel.setBounds(247, 211, 117, 25);
		btnCancel.addActionListener(new ButtonListener());
		add(btnCancel);

		add(txtVechileDesc);

		add(txtVehicleNo);
		lblVehicle.setFont(new Font("Dialog", Font.BOLD, 14));
		lblVehicle.setVerticalAlignment(SwingConstants.TOP);
		lblVehicle.setBounds(114, 12, 250, 25);

		add(lblVehicle);
	}

	private void resetField() {
		txtVechileDesc.setText("");
		txtVehicleNo.setText("");
	}

	private class ButtonListener implements ActionListener {
		DatabaseHelper databaseHelper = new DatabaseHelper();

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnSubmit) {
				if (txtVehicleNo.getText() == null
						|| txtVehicleNo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter Vechile no",
							"Missing field", JOptionPane.DEFAULT_OPTION);
					txtVehicleNo.requestFocus();
					return;
				}
				if (txtVechileDesc.getText() == null
						|| txtVechileDesc.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter password",
							"Missing field", JOptionPane.DEFAULT_OPTION);
					txtVehicleNo.requestFocus();
					return;
				}
				// login here
				if (databaseHelper.addNewVechile(txtVehicleNo.getText()
						.toString(), txtVehicleNo.getText().toString()) != -1) {

					JOptionPane.showMessageDialog(null,
							"successfuly added new vechile", "",
							JOptionPane.DEFAULT_OPTION);
					resetField();

				} else {
					JOptionPane.showMessageDialog(null, "error in connecton",
							"", JOptionPane.DEFAULT_OPTION);
				}

			} else if (e.getSource() == btnCancel) {
				resetField();
			}
		}
	}
}
