package com.brick.panel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import com.brick.database.DatabaseHelper;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Labor extends JPanel {
	String[] labortype = { "", "Madeshi", "Bokenya", "Patheri"};
	
	private final JLabel lblNewLabel = new JLabel("Labor Name");
	private final JLabel lblLaborType = new JLabel("Labor Type");
	private final JTextField textField = new JTextField();
	private final JButton btnAddNewLabor = new JButton("Add New Labor");
	private final JComboBox comboBox = new JComboBox(labortype);
	private final JLabel lblBrickAmount = new JLabel("Brick Amount");
	private final JTextField textField_1 = new JTextField();

	/**
	 * Create the panel.
	 */
	public Labor() {
		textField_1.setBounds(226, 143, 114, 19);
		textField_1.setColumns(10);
		textField.setBounds(226, 47, 114, 19);
		textField.setColumns(10);
		lblBrickAmount.setVisible(false);
		textField_1.setVisible(false);
		initGUI();
	}
	private void initGUI() {
		setLayout(null);
		lblNewLabel.setBounds(96, 49, 98, 15);
		
		add(lblNewLabel);
		lblLaborType.setBounds(96, 93, 98, 15);
		
		add(lblLaborType);
		
		add(textField);
		btnAddNewLabor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText()!=null && comboBox.getSelectedItem().toString()!=null){
					
				System.out.println("here1");
				DatabaseHelper databaseHelper = new DatabaseHelper();
					if(databaseHelper.insertLabour(textField.getText().toString(),comboBox.getSelectedItem().toString(),textField_1.getText().toString())>0){
						JOptionPane.showMessageDialog(null, "successfully added","succedd",JOptionPane.DEFAULT_OPTION);
					}
									
				}
				
			}
		});
		btnAddNewLabor.setBounds(146, 199, 176, 25);
		
		add(btnAddNewLabor);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = comboBox.getSelectedItem().toString();
				if (name == "Bokenya" || name== "Madeshi")
				{
					lblBrickAmount.setVisible(true);
					textField_1.setVisible(true);
					
				}
				else
				{
					lblBrickAmount.setVisible(false);
					textField_1.setVisible(false);
					
				}
			}
		});
		comboBox.setBounds(226, 88, 114, 24);
		
		add(comboBox);
		lblBrickAmount.setBounds(96, 145, 98, 15);
		
		add(lblBrickAmount);
		
		add(textField_1);
	}
}
