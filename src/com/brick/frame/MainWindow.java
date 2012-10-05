package com.brick.frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.util.Date;

<<<<<<< HEAD
import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
=======
>>>>>>> 80bf514e5c3b84150451067da1ede41e310c71c9
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

<<<<<<< HEAD
import com.brick.helper.clsSettings;
=======
import com.brick.panel.Labor;
>>>>>>> 80bf514e5c3b84150451067da1ede41e310c71c9
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
	final static String ADD_LABOR = "Card to add new Labor";
	public JMenu mnuOperations;
<<<<<<< HEAD
	public JMenuItem mnuNewuser, mnuVehicle, mnuAddVehicle, mnuAddLaborWork,
			mnuExit;
	clsSettings settings = new clsSettings();
	Dimension screen;
	JPanel containerPanel;
	JPanel panel_Top=new JPanel();
	static Date td  = new Date();
	static String sLogin 	= DateFormat.getDateTimeInstance().format(td);
	JPanel panel_Bottom = new JPanel();
	JLabel lblUsername = new JLabel("User Name:");
	JLabel lblLogDetails = new JLabel("Time Login :");
	JLabel lblTimeNow = new JLabel();
	JPanel desktop = new JPanel();
	JFrame jFrame;
	Container cont;
	
=======

	public JMenuItem mnuNewuser, mnuVehicle,mnuAddVehicle,mnuAddLaborWork, mnuExit,mnuAddLabor;
>>>>>>> 80bf514e5c3b84150451067da1ede41e310c71c9

	public MainWindow() {

		// Create and set up the window.
		super("Inventory Management System");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLayout(new BorderLayout(10,10));
		this.setLocationRelativeTo(null);

		// Create and set up the content pane.
		// Container contentPane = this.getContentPane();

		// addComponentToPane(contentPane);
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
	     panel_Bottom.setPreferredSize(new Dimension(10,25));
	     panel_Bottom.setBackground(Color.blue);
	    // panel_Bottom.add(lblUserIcon);
	     panel_Bottom.add(lblUsername);
	     panel_Bottom.add(username);
	     panel_Bottom.add(lblLogDetails);
	     panel_Bottom.add(logtime);
		
	    LaborWork jj=new LaborWork();
	   
	    desktop.setLayout(new BorderLayout());
	    panel_Top.setPreferredSize(new Dimension(10, 65));
	    desktop.add(jj);
	    NewUser newUser = new NewUser();
		Order order = new Order();
		NewVehicle newvehicle = new NewVehicle();
		LaborWork laborwork = new LaborWork();
		// Create the panel that contains the "cards".
		cards = new JPanel();
		cards.setLayout(new CardLayout());
		cards.add(new JPanel(), "1");
		cards.add(newUser, USERADD);
		cards.add(order, ADD_ORDER);
		cards.add(newvehicle, ADD_VEHICLE);
		cards.add(laborwork, ADD_LABOR_WORK);
	   // desktop.setBackground(Color.WHITE);
	    // desktop.setAutoscrolls(true);
	    // desktop.setBorder(BorderFactory.createLoweredBevelBorder());
	    // desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);

		panel_Top.setLayout(new BorderLayout());
		panel_Top.setPreferredSize(new Dimension(10, 65));
		panel_Top.add(createJToolBar(), BorderLayout.PAGE_START);
		getContentPane().add(panel_Top, BorderLayout.PAGE_START);
		 getContentPane().add(cards,BorderLayout.CENTER);
	     getContentPane().add(panel_Bottom,BorderLayout.PAGE_END);
	     cont=getContentPane();
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
		Labor labor = new Labor();
		// Create the panel that contains the "cards".
		cards = new JPanel(new CardLayout());
		cards.add(new JPanel(), "1");
		cards.add(newUser, USERADD);
		cards.add(order, ADD_ORDER);
		cards.add(newvehicle, ADD_VEHICLE);
<<<<<<< HEAD
		cards.add(laborwork, ADD_LABOR_WORK);
		// this.add(cards,new GridBagConstraints());
=======
		cards.add(laborwork,ADD_LABOR_WORK);
		cards.add(labor,ADD_LABOR);
>>>>>>> 80bf514e5c3b84150451067da1ede41e310c71c9

		// pane.add(cards, BorderLayout.CENTER);
		// JButton nextButton = new JButton("Next");
		// JPanel btnHolder=new JPanel();
		// pane.add(btnHolder,BorderLayout.SOUTH);
	}

	public JMenuBar CreateJMenuBar() {
		JMenuBar menubar = new JMenuBar();
		/********** CREATING OPERATIONS MENU ***********************/
		mnuOperations = new JMenu("Command");
		mnuOperations.setForeground((Color.blue));
		mnuOperations.setActionCommand("men");
		mnuOperations.setFont(new Font("monospaced", Font.PLAIN, 12));
		mnuOperations.setMnemonic('O');
		mnuOperations.setEnabled(true);

		mnuNewuser = new JMenuItem("Add New User");
		mnuNewuser.setForeground(Color.blue);
		mnuNewuser.setFont(new Font("monospaced", Font.PLAIN, 12));
		mnuNewuser.setMnemonic('L');
		// mnuNewuser.setIcon(new
		// ImageIcon(getClass().getResource("images/users.png")));
		mnuNewuser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
				ActionEvent.CTRL_MASK));
		mnuNewuser.setActionCommand("newuser");
		mnuNewuser.addActionListener(menulistener);
		
		//new labor
		mnuAddLabor = new JMenuItem("Add New Labor");
		mnuAddLabor.setForeground(Color.blue);
		mnuAddLabor.setFont(new Font("monospaced", Font.PLAIN, 12));
		mnuAddLabor.setMnemonic('L');
		//mnuNewuser.setIcon(new ImageIcon(getClass().getResource("images/users.png")));
		mnuAddLabor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
				ActionEvent.CTRL_MASK));
		mnuAddLabor.setActionCommand("newlabor");
		mnuAddLabor.addActionListener(menulistener);

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
		mnuOperations.add(mnuAddLabor);
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

	ActionListener JToolBarActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String source = e.getActionCommand();
			 if (source == "File_Exit")
	            {
				 CardLayout cl = (CardLayout) (cards.getLayout());
					cl.show(cards, USERADD);
	                }else if(source == "Emp_Add"){
	                	CardLayout cl = (CardLayout) (cards.getLayout());
						cl.show(cards, ADD_ORDER);
	                	
	                }else if(source == "Emp_Edit"){
	                	CardLayout cl = (CardLayout) (cards.getLayout());
						cl.show(cards, ADD_VEHICLE);
	                	
	                }else if(source == "Emp_Delete"){
	                	CardLayout cl = (CardLayout) (cards.getLayout());
						cl.show(cards, ADD_LABOR_WORK);
	                	
	                }else if(source == "Emp_Add"){
	                	CardLayout cl = (CardLayout) (cards.getLayout());
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
			} else if (ActCmd.equalsIgnoreCase("addVehicleinfo")) {
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, ADD_ORDER);
			} else if (ActCmd.equalsIgnoreCase("addVehicle")) {
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, ADD_VEHICLE);
<<<<<<< HEAD
			} else if (ActCmd.equalsIgnoreCase("addLaborWork")) {
=======
			}else if (ActCmd.equalsIgnoreCase("newlabor")) {
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, ADD_LABOR);
			}else if (ActCmd.equalsIgnoreCase("addLaborWork")) {
>>>>>>> 80bf514e5c3b84150451067da1ede41e310c71c9
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
