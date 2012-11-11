package com.brick.frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import com.brick.helper.ToolBarUtils;
import com.brick.panel.Labor;
import com.brick.panel.LaborWork;
import com.brick.panel.NewUser;
import com.brick.panel.NewVehicle;

import com.brick.panel.Order;

public class MainWindow extends JFrame implements WindowListener {

	private static final long serialVersionUID = 1L;
	JPanel cards; // a panel that uses CardLayout

	final static String USERADD = "Card with add user";
	final static String ADD_LABOUR = "Card with add Labour";
	final static String ADD_ORDER = "Card with add trip";
	final static String ADD_VEHICLE = "Card with add new vehicle";
	final static String ADD_LABOR_WORK = "Card with Labor work";
	public JMenu mnuOperations, mnuReports, mnuHelp;
	public JMenuItem mnuNewuser, mnuNewLabour, mnuOrder, mnuAddVehicle,
			mnuAddLaborWork, mnuItemReport, mnuExit, menuItemAbout;
	ToolBarUtils settings = new ToolBarUtils();
	Dimension screen;
	JPanel containerPanel;
	JPanel panel_Top = new JPanel();
	static Date td = new Date();
	static String sLogin = DateFormat.getDateTimeInstance().format(td);
	JPanel panel_Bottom = new JPanel();
	JLabel lblUsername = new JLabel("User Name:");
	JLabel lblLogDetails = new JLabel("Time Login :");
	JLabel lblTimeNow = new JLabel();
	// JPanel desktop = new JPanel();
	JFrame jFrame;
	Container cont;

	public MainWindow() {

		// Create and set up the window.
		super("Inventory Management System");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLayout(new BorderLayout(10, 10));
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("images/appicon.png").getImage());

		this.setJMenuBar(CreateJMenuBar());
		// Display the window.

		screen = Toolkit.getDefaultToolkit().getScreenSize();

		JTextField username = new JTextField();
		username.setEditable(false);
		JTextField logtime = new JTextField();
		logtime.setEditable(false);
		username.setText("krish");
		logtime.setText(sLogin);

		panel_Bottom.setLayout(new FlowLayout());
		panel_Bottom.setPreferredSize(new Dimension(10, 25));
		panel_Bottom.setBackground(Color.LIGHT_GRAY);
		panel_Bottom.add(lblUsername);
		panel_Bottom.add(username);
		panel_Bottom.add(lblLogDetails);
		panel_Bottom.add(logtime);

		NewUser newUser = new NewUser();
		Order order = new Order();
		NewVehicle newvehicle = new NewVehicle();
		LaborWork laborwork = new LaborWork();
		Labor newLabour = new Labor();
		// Create the panel that contains the "cards".
		cards = new JPanel();
		cards.setLayout(new CardLayout());
		cards.add(new JPanel(), "1");
		cards.add(newUser, USERADD);
		cards.add(order, ADD_ORDER);
		cards.add(newvehicle, ADD_VEHICLE);
		cards.add(laborwork, ADD_LABOR_WORK);
		cards.add(newLabour, ADD_LABOUR);

		getContentPane().setLayout(new BorderLayout(0, 0));
		panel_Top.setLayout(new BorderLayout(0, 0));

		panel_Top.add(createJToolBar());
		getContentPane().add(panel_Top, BorderLayout.NORTH);
		getContentPane().add(cards, BorderLayout.CENTER);
		getContentPane().add(panel_Bottom, BorderLayout.PAGE_END);
		cont = getContentPane();
		this.pack();
		this.setVisible(true);
	}

	protected JToolBar createJToolBar() {
		JToolBar toolbar = new JToolBar("Toolbar");

		toolbar.add(settings.CreateJToolbarButton("Exit", "images/exit.png",
				"File_Exit", JToolBarActionListener));
		toolbar.addSeparator();
		toolbar.addSeparator();

		toolbar.add(settings.CreateJToolbarButton("Add - Employee",
				"images/employee.png", "Emp_Add", JToolBarActionListener));

		toolbar.add(settings.CreateJToolbarButton("Edit - Employee",
				"images/edit.png", "Emp_Edit", JToolBarActionListener));
		toolbar.addSeparator();

		toolbar.add(settings.CreateJToolbarButton("Delete - Employee",
				"images/delete.png", "Emp_Delete", JToolBarActionListener));
		toolbar.addSeparator();
		toolbar.addSeparator();

		toolbar.add(settings.CreateJToolbarButton("Employee Position Settings",
				"images/setting.png", "Settings", JToolBarActionListener));
		toolbar.add(settings.CreateJToolbarButton("Calculator",
				"images/calc.png", "Tools_Calculator", JToolBarActionListener));
		toolbar.add(settings.CreateJToolbarButton("NotePad",
				"images/notepad.png", "Tools_NotePad", JToolBarActionListener));
		toolbar.addSeparator();
		toolbar.addSeparator();

		toolbar.add(settings.CreateJToolbarButton("Employee - Report",
				"images/emp_rpt.png", "Reports_Employee",
				JToolBarActionListener));

		toolbar.add(settings.CreateJToolbarButton("Help - Author",
				"images/xp.png", "Help_Author", JToolBarActionListener));

		toolbar.add(settings.CreateJToolbarButton("Help - Help",
				"images/help.png", "Help_Help", JToolBarActionListener));
		return toolbar;

	}

	public void addComponentToPane(Container pane) {

		NewUser newUser = new NewUser();
		Order order = new Order();
		NewVehicle newvehicle = new NewVehicle();
		LaborWork laborwork = new LaborWork();
		Labor newLabor = new Labor();
		// Create the panel that contains the "cards".
		cards = new JPanel(new CardLayout());
		cards.add(new JPanel(), "1");
		cards.add(newUser, USERADD);
		cards.add(newLabor,ADD_LABOUR);
		cards.add(order, ADD_ORDER);
		cards.add(newvehicle, ADD_VEHICLE);
		cards.add(laborwork, ADD_LABOR_WORK);

	}

	public JMenuBar CreateJMenuBar() {
		JMenuBar menubar = new JMenuBar();
		/********** CREATING OPERATIONS MENU ***********************/
		mnuOperations = new JMenu("Master   ");
		mnuOperations.setForeground((Color.blue));
		mnuOperations.setActionCommand("men");
		mnuOperations.setFont(new Font("monospaced", Font.PLAIN, 14));
		mnuOperations.setMnemonic('O');
		mnuOperations.setEnabled(true);

		/******************* menu report *****************************/
		mnuReports = new JMenu("Reports   ");
		mnuReports.setForeground((Color.blue));
		mnuReports.setActionCommand("men");
		mnuReports.setFont(new Font("monospaced", Font.PLAIN, 14));
		mnuReports.setMnemonic('O');

		/********************* menu help *****************************/
		mnuHelp = new JMenu("help   ");
		mnuHelp.setForeground((Color.blue));
		mnuHelp.setActionCommand("men");
		mnuHelp.setFont(new Font("monospaced", Font.PLAIN, 14));
		mnuHelp.setMnemonic('O');

		/*********************** menuitem ************************************/
		mnuNewuser = new JMenuItem("AddNew User");
		mnuNewuser.setForeground(Color.blue);
		mnuNewuser.setFont(new Font("monospaced", Font.PLAIN, 14));
		mnuNewuser.setMnemonic('L');
		mnuNewuser.setIcon(new ImageIcon("images/user.png"));
		mnuNewuser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
				ActionEvent.CTRL_MASK));
		mnuNewuser.setActionCommand("newuser");
		mnuNewuser.addActionListener(menulistener);

		// mnuNewLabour
		mnuNewLabour = new JMenuItem("Add new Labour");
		mnuNewLabour.setForeground(Color.blue);
		mnuNewLabour.setFont(new Font("monospaced", Font.PLAIN, 14));
		mnuNewLabour.setMnemonic('E');
		mnuNewLabour.setIcon(new ImageIcon("images/user.png"));
		mnuNewLabour.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				ActionEvent.CTRL_MASK));
		mnuNewLabour.setActionCommand("addLabour");
		mnuNewLabour.addActionListener(menulistener);

		// Add vehicle
		mnuAddVehicle = new JMenuItem("Add New Vehicle");
		mnuAddVehicle.setForeground(Color.blue);
		mnuAddVehicle.setFont(new Font("monospaced", Font.PLAIN, 14));
		mnuAddVehicle.setMnemonic('e');
		mnuAddVehicle.setIcon(new ImageIcon("images/print.png"));
		mnuAddVehicle.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				ActionEvent.CTRL_MASK));
		mnuAddVehicle.setActionCommand("addVehicle");
		mnuAddVehicle.addActionListener(menulistener);

		// order
		mnuOrder = new JMenuItem("Order");
		mnuOrder.setForeground(Color.blue);
		mnuOrder.setFont(new Font("monospaced", Font.PLAIN, 14));
		mnuOrder.setMnemonic('o');
		mnuOrder.setIcon(new ImageIcon("images/products.png"));
		mnuOrder.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				ActionEvent.CTRL_MASK));
		mnuOrder.setActionCommand("addVehicleinfo");
		mnuOrder.addActionListener(menulistener);

		// lobor work
		mnuAddLaborWork = new JMenuItem("Labor Work Account");
		mnuAddLaborWork.setForeground(Color.blue);
		mnuAddLaborWork.setFont(new Font("monospaced", Font.PLAIN, 14));
		mnuAddLaborWork.setMnemonic('a');
		mnuAddLaborWork.setIcon(new ImageIcon("images/mspaint.png"));
		mnuAddLaborWork.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				ActionEvent.CTRL_MASK));
		mnuAddLaborWork.setActionCommand("addLaborWork");
		mnuAddLaborWork.addActionListener(menulistener);

		// menu exit
		mnuExit = new JMenuItem("Exit");
		mnuExit.setForeground(Color.blue);
		mnuExit.setFont(new Font("monospaced", Font.PLAIN, 14));
		mnuExit.setMnemonic('E');
		mnuExit.setIcon(new ImageIcon("images/exit.png"));
		mnuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				ActionEvent.CTRL_MASK));
		mnuExit.setActionCommand("exit");
		mnuExit.addActionListener(menulistener);

		mnuItemReport = new JMenuItem("generate reports");
		mnuItemReport.setForeground(Color.blue);
		mnuItemReport.setFont(new Font("monospaced", Font.PLAIN, 14));
		mnuItemReport.setMnemonic('L');
		mnuItemReport.setIcon(new ImageIcon("images/report.png"));
		mnuItemReport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
				ActionEvent.CTRL_MASK));
		mnuItemReport.setActionCommand("report");
		mnuItemReport.addActionListener(menulistener);

		menuItemAbout = new JMenuItem("about");
		menuItemAbout.setForeground(Color.blue);
		menuItemAbout.setFont(new Font("monospaced", Font.PLAIN, 14));
		menuItemAbout.setMnemonic('A');
		menuItemAbout.setIcon(new ImageIcon("images/help.png"));
		menuItemAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				ActionEvent.CTRL_MASK));
		menuItemAbout.setActionCommand("about");
		menuItemAbout.addActionListener(menulistener);

		/******************* add menu item to master ***************************/

		mnuOperations.add(mnuNewuser);
		mnuOperations.addSeparator();
		mnuOperations.add(mnuNewLabour);
		mnuOperations.addSeparator();
		mnuOperations.add(mnuAddVehicle);
		mnuOperations.addSeparator();
		mnuOperations.add(mnuOrder);
		mnuOperations.addSeparator();
		mnuOperations.add(mnuAddLaborWork);
		mnuOperations.addSeparator();
		mnuOperations.add(mnuExit);

		/******************* add menu item to reports ***************************/
		mnuReports.add(mnuItemReport);

		mnuHelp.add(menuItemAbout);

		menubar.add(mnuOperations);
		menubar.add(mnuReports);
		menubar.add(mnuHelp);
		return menubar;
	}

	ActionListener JToolBarActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String source = e.getActionCommand();
			CardLayout cl = (CardLayout) (cards.getLayout());
			if (source == "File_Exit") {
				cl.show(cards, USERADD);
			} else if (source == "Emp_Add") {

				cl.show(cards, ADD_ORDER);

			} else if (source == "Emp_Edit") {

				cl.show(cards, ADD_VEHICLE);

			} else if (source == "Emp_Delete") {

				cl.show(cards, ADD_LABOR_WORK);

			} else if (source == "Emp_Add") {

				cl.show(cards, ADD_ORDER);

			}
		}

	};
	ActionListener menulistener = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			String ActCmd = e.getActionCommand();
			if (ActCmd.equalsIgnoreCase("newuser")) {
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, USERADD);
			} else if (ActCmd.equalsIgnoreCase("addLabour")) {
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, ADD_LABOUR);
			} else if (ActCmd.equalsIgnoreCase("addVehicleinfo")) {
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, ADD_ORDER);
			} else if (ActCmd.equalsIgnoreCase("addVehicle")) {
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, ADD_VEHICLE);
			} else if (ActCmd.equalsIgnoreCase("addLaborWork")) {
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, ADD_LABOR_WORK);
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
