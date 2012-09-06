package com.brick;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class MainWindow extends JFrame implements WindowListener {

	private static final long serialVersionUID = 1L;
	public static JDesktopPane desktop;
	public JLabel welcome;
	public JMenu mnuOperations;
	public JMenuItem mnuNewuser, mnuVehicle, mnuExit;

	public MainWindow() {
		super("Brick Inventory System");

		this.setJMenuBar(CreateJMenuBar());
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setIconImage(new ImageIcon(ClassLoader
				.getSystemResource("images/appicon.png")).getImage());
		this.setLocation(0, 0);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.addWindowListener(this);

		welcome = new JLabel(
				"Welcome:  Today is " + new java.util.Date() + " ",
				JLabel.CENTER);
		welcome.setFont(new Font("monospaced", Font.PLAIN, 12));
		welcome.setForeground(Color.blue);
		desktop = new JDesktopPane();
		desktop.setBorder(BorderFactory.createEmptyBorder());
		desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
		getContentPane().add(welcome, BorderLayout.PAGE_END, JLabel.CENTER);
		getContentPane().add(desktop, BorderLayout.CENTER);

		setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		ConfirmExit();

	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	private void ConfirmExit() {
		String ObjButtons[] = { "Yes", "No" };
		int PromptResult = JOptionPane.showOptionDialog(null,
				"Are you sure to exit?", "Confirm exit",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
				ObjButtons, ObjButtons[1]);
		if (PromptResult == 0) {
			System.exit(0);
		}// if closed
	}// ConfirmExit() closed

	protected boolean isLoaded(String FormTitle) {
		JInternalFrame Form[] = desktop.getAllFrames();
		for (int i = 0; i < Form.length; i++) {
			if (Form[i].getTitle().equalsIgnoreCase(FormTitle)) {
				Form[i].show();
				try {
					Form[i].setIcon(true);
					Form[i].setSelected(true);
				} catch (Exception e) {
				}
				return true;
			}
		}
		return false;
	}// isLoaded() closed

	public JMenuBar CreateJMenuBar() {
		JMenuBar menubar = new JMenuBar();
		/********** CREATING OPERATIONS MENU ***********************/
		mnuOperations = new JMenu("Command");
		mnuOperations.setForeground((Color.blue));
		mnuOperations.setFont(new Font("monospaced", Font.PLAIN, 12));
		mnuOperations.setMnemonic('O');
		mnuOperations.setEnabled(true);

		mnuNewuser = new JMenuItem("AddNew User");
		mnuNewuser.setForeground(Color.blue);
		mnuNewuser.setFont(new Font("monospaced", Font.PLAIN, 12));
		mnuNewuser.setMnemonic('L');
		mnuNewuser.setIcon(new ImageIcon(ClassLoader
				.getSystemResource("images/users.png")));
		mnuNewuser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
				ActionEvent.CTRL_MASK));
		mnuNewuser.setActionCommand("newuser");
		mnuNewuser.addActionListener(menulistener);

		// vechile
		mnuVehicle = new JMenuItem("Add Vehicle Info");
		mnuVehicle.setForeground(Color.blue);
		mnuVehicle.setFont(new Font("monospaced", Font.PLAIN, 12));
		mnuVehicle.setMnemonic('v');
		mnuVehicle.setIcon(new ImageIcon(ClassLoader
				.getSystemResource("images/users.png")));
		mnuVehicle.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
				ActionEvent.CTRL_MASK));
		mnuVehicle.setActionCommand("addVehicleinfo");
		mnuVehicle.addActionListener(menulistener);
		// menu exit
		mnuExit = new JMenuItem("Exit");
		mnuExit.setForeground(Color.blue);
		mnuExit.setFont(new Font("monospaced", Font.PLAIN, 12));
		mnuExit.setMnemonic('E');
		mnuExit.setIcon(new ImageIcon(ClassLoader
				.getSystemResource("images/exit.png")));
		mnuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				ActionEvent.CTRL_MASK));
		mnuExit.setActionCommand("exit");
		mnuExit.addActionListener(menulistener);

		mnuOperations.add(mnuNewuser);
		mnuOperations.addSeparator();
		mnuOperations.add(mnuVehicle);
		mnuOperations.addSeparator();
		mnuOperations.add(mnuExit);
		menubar.add(mnuOperations);
		return menubar;
	}

	ActionListener menulistener = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			String ActCmd = e.getActionCommand();
			if (ActCmd.equalsIgnoreCase("newuser")) {
				NewUser frm = new NewUser();
				desktop.removeAll();
				desktop.add(frm);
				frm.setVisible(true);
			} else if (ActCmd.equalsIgnoreCase("addVehicleinfo")) {
				AddEntry vehicleForm = new AddEntry();
				desktop.removeAll();
				desktop.add(vehicleForm);
				vehicleForm.setVisible(true);
			} else if (ActCmd.equalsIgnoreCase("exit")) {
				ConfirmExit();
			}
		}
	};

}
