package com.brick.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JButton;

public class MainEmployee extends JPanel {
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	EmployeeRecords records = new EmployeeRecords();

	/**
	 * Create the panel.
	 */
	public MainEmployee() {

		initGUI();
	}
	private void initGUI() {
		setLayout(new BorderLayout(0, 0));
		
		add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.addTab("Employee Records", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(records);
		
		tabbedPane.addTab("New Eployee", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
	}
}
