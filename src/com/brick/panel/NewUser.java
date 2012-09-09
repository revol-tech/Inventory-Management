package com.brick.panel;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NewUser extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblUsername, lblPassword, lblConfirmMsg;
	private JPasswordField txtPassword, txtCPassword;
	private JTextField txtUsername, txtName;
	private JButton btnSave, btnCancel;

	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

	public NewUser() {
		
		this.setSize(350, 270);
		this.setLocation((screen.width - 500) / 2, ((screen.height - 350) / 2));
		this.setLayout(null);

		lblUsername = new JLabel("Username");
		lblPassword = new JLabel("Password");
		lblConfirmMsg = new JLabel("Re-enter Password");
		txtName = new JTextField();

		txtUsername = new JTextField();
		txtPassword = new JPasswordField();
		txtCPassword = new JPasswordField();
		btnSave = new JButton("Save");
		btnCancel = new JButton("Cancel");

		lblUsername.setBounds(30, 30, 100, 25);
		this.add(lblUsername);
		txtUsername.setBounds(150, 30, 150, 25);
		this.add(txtUsername);
		lblPassword.setBounds(30, 70, 100, 25);
		this.add(lblPassword);
		txtPassword.setBounds(150, 70, 150, 25);
		this.add(txtPassword);
		lblConfirmMsg.setBounds(30, 110, 110, 25);
		this.add(lblConfirmMsg);
		txtCPassword.setBounds(150, 110, 150, 25);
		this.add(txtCPassword);
		btnSave.setBounds(60, 155, 100, 25);
		this.add(btnSave);
		btnCancel.setBounds(180, 155, 100, 25);
		this.add(btnCancel);

		txtName.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE)
						|| (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "Invalid Character",
							"ERROR", JOptionPane.ERROR_MESSAGE);
					e.consume();
				}
			}
		});
		txtUsername.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE)
						|| (Character.isDigit(c)) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "Invalid Character",
							"ERROR", JOptionPane.ERROR_MESSAGE);
					e.consume();
				}
			}
		});
		btnSave.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (txtUsername.getText() == null
						|| txtUsername.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter Username",
							"Missing fields", JOptionPane.DEFAULT_OPTION);
					txtUsername.requestFocus();
					return;
				}
				if (txtPassword.getPassword() == null
						|| txtPassword.getPassword().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter Password",
							"Missing fields", JOptionPane.DEFAULT_OPTION);
					txtPassword.requestFocus();
					return;
				}
				if (txtCPassword.getPassword() == null
						|| txtCPassword.getPassword().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Confirm your password", "Missing fields",
							JOptionPane.DEFAULT_OPTION);
					txtCPassword.requestFocus();
					return;
				}
				if (!txtPassword.getPassword().equals(txtPassword.getPassword())) {
					JOptionPane.showMessageDialog(null,
							"Passwords do not match.", "ERROR",
							JOptionPane.DEFAULT_OPTION);
					txtCPassword.requestFocus();
					return;
				}
				try {

					/*Statement stmt = DatabaseHelper.getDBConnection()
							.createStatement();
					String sql = "INSERT INTO login (id,name,pwd) VALUES ("
							+ new Random().nextInt(100) + ",'"
							+ txtUsername.getText() + "', '"
							+ txtPassword.getText() + "')";
					int result = stmt.executeUpdate(sql);*/
					int result=1;
					if (result > 0) {
						JOptionPane.showMessageDialog(null,
								"User details is succesfully added", "SUCCESS",
								JOptionPane.DEFAULT_OPTION);
						// dispose();
					}
				} catch (Exception in) {
					JOptionPane.showMessageDialog(null,
							"Error on database updation", "Updation failed",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnCancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// dispose();
			}
		});
	}// constructor closed
}// class closed

