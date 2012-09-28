package com.brick.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LaborWork extends JPanel {
	String[] labortype = { "", "Madeshi", "Bokenya", "Patheri"};
	
	private final JLabel lblLaborName = new JLabel("Labor Name");
	private final JLabel lblLaborType = new JLabel("Labor Type");
	private final JTextField textField = new JTextField();
	private final JComboBox comboBox = new JComboBox(labortype);
	private final JPanel patheri = new JPanel();
	private final JLabel lblBrickAmount = new JLabel("Brick Amount");
	private final JTextField textField_1 = new JTextField();
	private final JPanel madhesi = new JPanel();
	private final JLabel label = new JLabel("Distance A");
	private final JLabel label_1 = new JLabel("Distance B");
	private final JLabel label_2 = new JLabel("Distance C");
	private final JTextField textField_5 = new JTextField();
	private final JTextField textField_6 = new JTextField();
	private final JTextField textField_7 = new JTextField();
	private final JTextField textField_8 = new JTextField();
	private final JTextField textField_9 = new JTextField();
	private final JTextField textField_10 = new JTextField();
	private final JLabel label_3 = new JLabel("Brick A(Transaction)");
	private final JLabel label_4 = new JLabel("Brick B(Transaction)");
	private final JPanel bokenya = new JPanel();
	private final JLabel label_5 = new JLabel("Distance A");
	private final JLabel label_6 = new JLabel("Distance B");
	private final JLabel label_7 = new JLabel("Distance C");
	private final JTextField textField_2 = new JTextField();
	private final JTextField textField_3 = new JTextField();
	private final JTextField textField_4 = new JTextField();
	private final JLabel label_8 = new JLabel("Transaction");
	private final JButton btnSubmit = new JButton("Submit");
	private final JButton btnCancle = new JButton("Cancel");
	
	
	/**
	 * Create the panel.
	 */
	public LaborWork() {
		textField_1.setBounds(142, 20, 145, 19);
		textField_1.setColumns(10);
		textField.setBounds(239, 65, 146, 19);
		textField.setColumns(10);

		initGUI();
	}
	private void initGUI() {
		setLayout(null);
		lblLaborName.setBounds(99, 67, 109, 15);
		
		add(lblLaborName);
		lblLaborType.setBounds(99, 120, 109, 15);
		
		add(lblLaborType);
		
		add(textField);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = comboBox.getSelectedItem().toString();
				if (name == "Bokenya")
				{
					patheri.setVisible(false);
					madhesi.setVisible(false);
					bokenya.setVisible(true);
				}
				else if(name == "Madeshi")
				{
					
						patheri.setVisible(false);
						bokenya.setVisible(false);
						madhesi.setVisible(true);
					
				}
				else if(name == "Patheri")
				{
						
						bokenya.setVisible(false);
						madhesi.setVisible(false);
						patheri.setVisible(true);
					
				}
				else
				{
					
					madhesi.setVisible(false);
					patheri.setVisible(false);
					bokenya.setVisible(false);
				}
				
			}
		});
		madhesi.setLayout(null);
		madhesi.setBounds(99, 161, 439, 137);
		
		add(madhesi);
		label.setBounds(0, 28, 91, 15);
		
		madhesi.add(label);
		label_1.setBounds(0, 66, 91, 15);
		
		madhesi.add(label_1);
		label_2.setBounds(0, 103, 91, 15);
		
		madhesi.add(label_2);
		textField_5.setColumns(10);
		textField_5.setBounds(109, 26, 114, 19);
		
		madhesi.add(textField_5);
		textField_6.setColumns(10);
		textField_6.setBounds(285, 24, 114, 19);
		
		madhesi.add(textField_6);
		textField_7.setColumns(10);
		textField_7.setBounds(109, 64, 114, 19);
		
		madhesi.add(textField_7);
		textField_8.setColumns(10);
		textField_8.setBounds(285, 62, 114, 19);
		
		madhesi.add(textField_8);
		textField_9.setColumns(10);
		textField_9.setBounds(109, 101, 114, 19);
		
		madhesi.add(textField_9);
		textField_10.setColumns(10);
		textField_10.setBounds(285, 99, 114, 19);
		
		madhesi.add(textField_10);
		label_3.setBounds(100, -1, 147, 15);
		
		madhesi.add(label_3);
		label_4.setBounds(271, -1, 141, 15);
		
		madhesi.add(label_4);
		comboBox.setBounds(239, 115, 147, 24);
		
		add(comboBox);
		patheri.setBounds(99, 161, 312, 80);
		
		add(patheri);
		patheri.setLayout(null);
		lblBrickAmount.setBounds(0, 22, 107, 15);
		
		patheri.add(lblBrickAmount);
		
		patheri.add(textField_1);
		bokenya.setLayout(null);
		bokenya.setBounds(99, 161, 459, 180);
		
		add(bokenya);
		label_5.setBounds(0, 35, 112, 15);
		
		bokenya.add(label_5);
		label_6.setBounds(0, 71, 112, 15);
		
		bokenya.add(label_6);
		label_7.setBounds(0, 107, 112, 15);
		
		bokenya.add(label_7);
		textField_2.setColumns(10);
		textField_2.setBounds(146, 33, 143, 19);
		
		bokenya.add(textField_2);
		textField_3.setColumns(10);
		textField_3.setBounds(145, 69, 144, 19);
		
		bokenya.add(textField_3);
		textField_4.setColumns(10);
		textField_4.setBounds(146, 105, 143, 19);
		
		bokenya.add(textField_4);
		label_8.setBounds(172, 6, 117, 15);
		
		bokenya.add(label_8);
		btnSubmit.setBounds(99, 385, 117, 25);
		
		add(btnSubmit);
		btnCancle.setBounds(258, 385, 117, 25);
		
		add(btnCancle);
		
		madhesi.setVisible(false);
		patheri.setVisible(false);
		bokenya.setVisible(false);
	}
}
