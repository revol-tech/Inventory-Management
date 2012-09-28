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

public class NewVehicle extends JPanel {
	private final JLabel lblVehicleNumber = new JLabel("Vehicle Number");
	private final JLabel lblVehicleDescription = new JLabel("Vehicle Description");
	private final JButton btnSubmit = new JButton("Submit");
	private final JButton btnCancle = new JButton("Cancle");
	private final JTextField vehicleno = new JTextField();
	private final JTextField vehicledesc = new JTextField();
	private final JLabel lblVehicle = new JLabel("New Vehicle Information");

	/**
	 * Create the panel.
	 */
	public NewVehicle() {
		vehicledesc.setBounds(253, 104, 145, 19);
		vehicledesc.setColumns(10);
		vehicleno.setBounds(256, 60, 141, 19);
		vehicleno.setColumns(10);

		initGUI();
	}
	private void initGUI() {
		setLayout(null);
		lblVehicleNumber.setBounds(98, 62, 139, 15);
		
		add(lblVehicleNumber);
		lblVehicleDescription.setBounds(98, 103, 148, 15);
		
		add(lblVehicleDescription);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (vehicleno.getText()!=null && vehicledesc.getText()!=null){
					DatabaseHelper databaseHelper = new DatabaseHelper();
					if(databaseHelper.insertVehicle(vehicleno.getText().toString(),vehicledesc.getText().toString())>0){
						JOptionPane.showMessageDialog(null, "successfully added","succedd",JOptionPane.DEFAULT_OPTION);
					}
									
				}
			}
		});
		btnSubmit.setBounds(83, 211, 117, 25);
		
		add(btnSubmit);
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancle.setBounds(247, 211, 117, 25);
		
		add(btnCancle);
		
		add(vehicleno);
		
		add(vehicledesc);
		lblVehicle.setFont(new Font("Dialog", Font.BOLD, 14));
		lblVehicle.setVerticalAlignment(SwingConstants.TOP);
		lblVehicle.setBounds(114, 12, 250, 25);
		
		add(lblVehicle);
	}
}
