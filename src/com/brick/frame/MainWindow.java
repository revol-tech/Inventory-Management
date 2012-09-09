package com.brick.frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import com.brick.panel.NewUser;
import com.brick.panel.Order;

public class MainWindow extends JFrame implements WindowListener {

	private static final long serialVersionUID = 1L;
	JPanel cards; // a panel that uses CardLayout
	final static String BUTTONPANEL = "Card with JButtons";
	final static String TEXTPANEL = "Card with JTextField";
	final static String USERADD = "Card with add user";
	final static String ADD_ORDER = "Card with add trip";
	public JMenu mnuOperations;
	public JMenuItem mnuNewuser, mnuVehicle, mnuExit;

	public MainWindow() {

		// Create and set up the window.
		super("Inventory Management System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		// Create and set up the content pane.
		this.addComponentToPane(this.getContentPane());
		this.setJMenuBar(CreateJMenuBar());
		// Display the window.
		this.pack();
		this.setVisible(true);

	}

	public void addComponentToPane(Container pane) {

		NewUser newUser = new NewUser();
		Order order = new Order();

		// Create the panel that contains the "cards".
		cards = new JPanel(new CardLayout());
		cards.add(new JPanel(), "1");
		cards.add(newUser, USERADD);
		cards.add(order, ADD_ORDER);

		pane.add(cards, BorderLayout.CENTER);
	}


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
		//mnuNewuser.setIcon(new ImageIcon(getClass().getResource("images/users.png")));
		mnuNewuser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
				ActionEvent.CTRL_MASK));
		mnuNewuser.setActionCommand("newuser");
		mnuNewuser.addActionListener(menulistener);

		// vechile
		mnuVehicle = new JMenuItem("Order");
		mnuVehicle.setForeground(Color.blue);
		mnuVehicle.setFont(new Font("monospaced", Font.PLAIN, 12));
		mnuVehicle.setMnemonic('o');
		// mnuVehicle.setIcon(new ImageIcon(ClassLoader
		// .getSystemResource("images/users.png")));
		mnuVehicle.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				ActionEvent.CTRL_MASK));
		mnuVehicle.setActionCommand("addVehicleinfo");
		mnuVehicle.addActionListener(menulistener);
		// menu exit
		mnuExit = new JMenuItem("Exit");
		mnuExit.setForeground(Color.blue);
		mnuExit.setFont(new Font("monospaced", Font.PLAIN, 12));
		mnuExit.setMnemonic('E');
		// mnuExit.setIcon(new ImageIcon(ClassLoader
		// .getSystemResource("images/exit.png")));
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
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, USERADD);
			} else if (ActCmd.equalsIgnoreCase("addVehicleinfo")) {
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, ADD_ORDER);
			} else if (ActCmd.equalsIgnoreCase("exit")) {
				 ConfirmExit();
			}
		}
	};

	private void ConfirmExit() {
		String ObjButtons[] = { "Yes", "No" };
		int PromptResult = JOptionPane.showOptionDialog(null,
				"Are you sure to exit?", "Confirm exit",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
				ObjButtons, ObjButtons[1]);
		if (PromptResult == 0) {
			System.exit(0);
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {

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

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}
}
