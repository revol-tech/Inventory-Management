package com.brick.frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
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

import com.brick.panel.LaborWork;
import com.brick.panel.NewUser;
import com.brick.panel.NewVehicle;
import com.brick.panel.Order;

public class MainWindow extends JFrame implements WindowListener {

	private static final long serialVersionUID = 1L;
	JPanel cards; // a panel that uses CardLayout
	final static String BUTTONPANEL = "Card with JButtons";
	final static String TEXTPANEL = "Card with JTextField";
	final static String USERADD = "Card with add user";
	final static String ADD_ORDER = "Card with add trip";
	final static String ADD_VEHICLE = "Card with add new vehicle";
	final static String ADD_LABOR_WORK = "Card with Labor work";
	public JMenu mnuOperations;
	public JMenuItem mnuNewuser, mnuVehicle,mnuAddVehicle,mnuAddLaborWork, mnuExit;
	Dimension screen;
	public MainWindow() {

		// Create and set up the window.
		super("Inventory Management System");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//this.setLayout(new GridBagLayout());

		// Create and set up the content pane.
		Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
		this.addComponentToPane(contentPane);
		this.setJMenuBar(CreateJMenuBar());
		// Display the window.
		this.pack();
		this.setVisible(true);
		 screen= Toolkit.getDefaultToolkit().getScreenSize();

	}

	public void addComponentToPane(Container pane) {

		NewUser newUser = new NewUser();
		Order order = new Order();
		NewVehicle newvehicle = new NewVehicle();
		LaborWork laborwork = new LaborWork();
		// Create the panel that contains the "cards".
		cards = new JPanel();
		cards.setLayout(new CardLayout(250,100));
		cards.add(new JPanel(), "1");
		cards.add(newUser, USERADD);
		cards.add(order, ADD_ORDER);
		cards.add(newvehicle, ADD_VEHICLE);
		cards.add(laborwork,ADD_LABOR_WORK);
		//this.add(cards,new GridBagConstraints());

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

		// Add vehicle
		mnuAddVehicle = new JMenuItem("Add New Vehicle");
		mnuAddVehicle.setForeground(Color.blue);
		mnuAddVehicle.setFont(new Font("monospaced", Font.PLAIN, 12));
		mnuAddVehicle.setMnemonic('e');
		// mnuVehicle.setIcon(new ImageIcon(ClassLoader
		// .getSystemResource("images/users.png")));
		mnuAddVehicle.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				ActionEvent.CTRL_MASK));
		mnuAddVehicle.setActionCommand("addVehicle");
		mnuAddVehicle.addActionListener(menulistener);
		
		// order
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
		
		// lobor work
		mnuAddLaborWork = new JMenuItem("Labor Work Account");
		mnuAddLaborWork.setForeground(Color.blue);
		mnuAddLaborWork.setFont(new Font("monospaced", Font.PLAIN, 12));
		mnuAddLaborWork.setMnemonic('a');
		// mnuVehicle.setIcon(new ImageIcon(ClassLoader
		// .getSystemResource("images/users.png")));
		mnuAddLaborWork.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				ActionEvent.CTRL_MASK));
		mnuAddLaborWork.setActionCommand("addLaborWork");
		mnuAddLaborWork.addActionListener(menulistener);
		
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
		mnuOperations.add(mnuAddVehicle);
		mnuOperations.addSeparator();
		mnuOperations.add(mnuVehicle);
		mnuOperations.addSeparator();
		mnuOperations.add(mnuAddLaborWork);
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
			}else if (ActCmd.equalsIgnoreCase("addVehicle")) {
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, ADD_VEHICLE);
			}else if (ActCmd.equalsIgnoreCase("addLaborWork")) {
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, ADD_LABOR_WORK);
			}else if (ActCmd.equalsIgnoreCase("exit")) {
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
