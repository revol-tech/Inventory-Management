package com.brick.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import com.brick.database.DatabaseHelper;
import com.brick.helper.BrickHelper;
import com.brick.helper.CustomerHelper;
import com.brick.helper.EmployeeHelper;
import com.brick.helper.LaborHelper;
import com.brick.helper.VehicleInfo;
import com.brick.panel.LaborWork.MyListRender;
import com.brick.panel.LaborWork.searchComboBoxEditor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Order extends JPanel {
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JButton button = new JButton("");
	private final JLabel lblVoucher = new JLabel("Voucher No\n");
	private final JLabel lblVehicleNo = new JLabel("Vehicle No");
	private final JLabel lblDriverName = new JLabel("Driver Name");
	private final JLabel lblBrickType = new JLabel("Brick Type");
	private final JCheckBox chckbxHalf = new JCheckBox("Half");
	private final JTextField txtVoucherNo = new JTextField();
	private final JTextField txtHalf = new JTextField();
	private final JComboBox<VehicleInfo> comboBoxVehicleNo = new JComboBox<VehicleInfo>();
	private final JComboBox<EmployeeHelper> comboBoxDriverName = new JComboBox<EmployeeHelper>();
	private final JComboBox<BrickHelper> comboBoxBrickType = new JComboBox<BrickHelper>();
	private final JLabel lblCustomerName = new JLabel("Customer Name");
	private final JButton btnConfirmOrder = new JButton("Confirm Order");
	private final JLabel lblOrderDelivery = new JLabel("Order Delivery");
	private final JLabel lblTotal = new JLabel("Total");
	private final JLabel lblBalance = new JLabel("Advance");
	private final JLabel lblRemainder = new JLabel("Remainder");
	private final JTextField txtTotal = new JTextField();
	private final JTextField txtAdvance = new JTextField();
	private final JTextField txtRemainder = new JTextField();
	DatabaseHelper databasehelper = new DatabaseHelper();
	String numToken = "[\\p{Digit}]+";

	/**
	 * Create the panel.
	 */
	public Order() {
		txtDestination.setColumns(10);
		txtRemainder.setColumns(10);
		txtAdvance.setColumns(10);
		txtTotal.setColumns(10);
		txtHalf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				chckbxHalf.setSelected(true);
			}
		});
		txtHalf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//OnFocus Event for txtHalf textfield
				//txtHalf.setBackground(Color.black);
			}
		});
		txtHalf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtHalf.setColumns(10);
		txtVoucherNo.setColumns(10);
		
		txtAdvance.addCaretListener(onTxtAdvanceChangeListner);

		initGUI();
	}
	private void initGUI() {
		setLayout(new BorderLayout(0, 0));
		
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_2.setBackground(Color.GRAY);
		
		panel.add(panel_2);
		lblOrderDelivery.setForeground(new Color(0, 191, 255));
		lblOrderDelivery.setFont(new Font("Dialog", Font.BOLD, 16));
		
		panel_2.add(lblOrderDelivery);
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_3.setBackground(Color.GRAY);
		
		panel.add(panel_3);
		button.setIcon(new ImageIcon("images/exit.png"));
		
		panel_3.add(button);
		
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{135, 160, 0, 140, 160};
		gbl_panel_1.rowHeights = new int[]{45, 45, 45, 45, 45, 80};
		//gbl_panel_1.columnWidths = new int[]{143, 200, 93, 146, 200};
		//gbl_panel_1.columnWidths = new int[]{160, 0, 0, 0, 0, 0, 0};
		//gbl_panel_1.rowHeights = new int[]{45, 45, 45, 45, 45, 80};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel_1.setLayout(gbl_panel_1);
		
		GridBagConstraints gbc_lblVoucher = new GridBagConstraints();
		gbc_lblVoucher.anchor = GridBagConstraints.WEST;
		gbc_lblVoucher.insets = new Insets(0, 0, 5, 5);
		gbc_lblVoucher.gridx = 0;
		gbc_lblVoucher.gridy = 0;
		lblVoucher.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(lblVoucher, gbc_lblVoucher);
		
		GridBagConstraints gbc_txtVoucherNo = new GridBagConstraints();
		gbc_txtVoucherNo.insets = new Insets(7, 0, 7, 5);
		gbc_txtVoucherNo.fill = GridBagConstraints.BOTH;
		gbc_txtVoucherNo.gridx = 1;
		gbc_txtVoucherNo.gridy = 0;
		panel_1.add(txtVoucherNo, gbc_txtVoucherNo);
		
		GridBagConstraints gbc_lblCustomerName = new GridBagConstraints();
		gbc_lblCustomerName.anchor = GridBagConstraints.WEST;
		gbc_lblCustomerName.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomerName.gridx = 3;
		gbc_lblCustomerName.gridy = 0;
		lblCustomerName.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(lblCustomerName, gbc_lblCustomerName);
		ArrayList<CustomerHelper> customerlist = new ArrayList<CustomerHelper>();
		customerlist = databasehelper.fetchCustomerName();
		comboBoxCustomer.setEditable(true);
		comboBoxCustomer.setRenderer(new CustomerRender());
		comboBoxCustomer.setEditor(new CustomerEditor());
		for (CustomerHelper customerHelper : customerlist) {

			comboBoxCustomer.addItem(customerHelper);
		}

		
		GridBagConstraints gbc_comboBoxCustomer = new GridBagConstraints();
		gbc_comboBoxCustomer.insets = new Insets(7, 0, 7, 0);
		gbc_comboBoxCustomer.fill = GridBagConstraints.BOTH;
		gbc_comboBoxCustomer.gridx = 4;
		gbc_comboBoxCustomer.gridy = 0;
		comboBoxCustomer.setEditable(true);
		panel_1.add(comboBoxCustomer, gbc_comboBoxCustomer);
		
		
		GridBagConstraints gbc_lblVehicleNo = new GridBagConstraints();
		gbc_lblVehicleNo.anchor = GridBagConstraints.WEST;
		gbc_lblVehicleNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblVehicleNo.gridx = 0;
		gbc_lblVehicleNo.gridy = 1;
		lblVehicleNo.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(lblVehicleNo, gbc_lblVehicleNo);
		
		GridBagConstraints gbc_comboBoxVehicleNo = new GridBagConstraints();
		gbc_comboBoxVehicleNo.insets = new Insets(7, 0, 7, 5);
		gbc_comboBoxVehicleNo.fill = GridBagConstraints.BOTH;
		gbc_comboBoxVehicleNo.gridx = 1;
		gbc_comboBoxVehicleNo.gridy = 1;
		comboBoxVehicleNo.setEditable(true);
		panel_1.add(comboBoxVehicleNo, gbc_comboBoxVehicleNo);
		ArrayList<VehicleInfo> list = new ArrayList<VehicleInfo>();
		list = databasehelper.fetchVechileInfo();
		comboBoxVehicleNo.setEditable(true);
		comboBoxVehicleNo.setRenderer(new MyListRender());
		comboBoxVehicleNo.setEditor(new searchComboBoxEditor());
		for (VehicleInfo vehicleHelper : list) {

			comboBoxVehicleNo.addItem(vehicleHelper);
		}
		
		GridBagConstraints gbc_lblDestination = new GridBagConstraints();
		gbc_lblDestination.anchor = GridBagConstraints.WEST;
		gbc_lblDestination.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestination.gridx = 3;
		gbc_lblDestination.gridy = 1;
		lblDestination.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(lblDestination, gbc_lblDestination);
		
		GridBagConstraints gbc_txtDestination = new GridBagConstraints();
		gbc_txtDestination.insets = new Insets(7, 0, 7, 0);
		gbc_txtDestination.fill = GridBagConstraints.BOTH;
		gbc_txtDestination.gridx = 4;
		gbc_txtDestination.gridy = 1;
		panel_1.add(txtDestination, gbc_txtDestination);
		
		GridBagConstraints gbc_lblDriverName = new GridBagConstraints();
		gbc_lblDriverName.anchor = GridBagConstraints.WEST;
		gbc_lblDriverName.insets = new Insets(0, 0, 5, 5);
		gbc_lblDriverName.gridx = 0;
		gbc_lblDriverName.gridy = 2;
		lblDriverName.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(lblDriverName, gbc_lblDriverName);
		
		GridBagConstraints gbc_comboBoxDriverName = new GridBagConstraints();
		gbc_comboBoxDriverName.insets = new Insets(7, 0, 7, 5);
		gbc_comboBoxDriverName.fill = GridBagConstraints.BOTH;
		gbc_comboBoxDriverName.gridx = 1;
		gbc_comboBoxDriverName.gridy = 2;
		comboBoxDriverName.setEditable(true);
		panel_1.add(comboBoxDriverName, gbc_comboBoxDriverName);
		ArrayList<EmployeeHelper> driverlist = new ArrayList<EmployeeHelper>();
		driverlist = databasehelper.fetchDriverName();
		comboBoxDriverName.setEditable(true);
		comboBoxDriverName.setRenderer(new DriverRender());
		comboBoxDriverName.setEditor(new DriverEditor());
		for (EmployeeHelper employeeHelper : driverlist) {

			comboBoxDriverName.addItem(employeeHelper);
		}

		
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.WEST;
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.gridx = 3;
		gbc_lblTotal.gridy = 2;
		lblTotal.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(lblTotal, gbc_lblTotal);
		
		GridBagConstraints gbc_txtTotal = new GridBagConstraints();
		gbc_txtTotal.insets = new Insets(7, 0, 7, 0);
		gbc_txtTotal.fill = GridBagConstraints.BOTH;
		gbc_txtTotal.gridx = 4;
		gbc_txtTotal.gridy = 2;
		panel_1.add(txtTotal, gbc_txtTotal);
		
		GridBagConstraints gbc_lblBrickType = new GridBagConstraints();
		gbc_lblBrickType.anchor = GridBagConstraints.WEST;
		gbc_lblBrickType.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrickType.gridx = 0;
		gbc_lblBrickType.gridy = 3;
		lblBrickType.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(lblBrickType, gbc_lblBrickType);
		
		GridBagConstraints gbc_comboBoxBrickType = new GridBagConstraints();
		gbc_comboBoxBrickType.insets = new Insets(7, 0, 7, 5);
		gbc_comboBoxBrickType.fill = GridBagConstraints.BOTH;
		gbc_comboBoxBrickType.gridx = 1;
		gbc_comboBoxBrickType.gridy = 3;
		panel_1.add(comboBoxBrickType, gbc_comboBoxBrickType);
		ArrayList<BrickHelper> bricklist = new ArrayList<BrickHelper>();
		bricklist = databasehelper.fetchBrickName();
		comboBoxBrickType.setEditable(true);
		comboBoxBrickType.setRenderer(new BrickRender());
		comboBoxBrickType.setEditor(new BrickEditor());
		for (BrickHelper brickHelper : bricklist) {

			comboBoxBrickType.addItem(brickHelper);
		}

		
		GridBagConstraints gbc_lblBalance = new GridBagConstraints();
		gbc_lblBalance.anchor = GridBagConstraints.WEST;
		gbc_lblBalance.insets = new Insets(0, 0, 5, 5);
		gbc_lblBalance.gridx = 3;
		gbc_lblBalance.gridy = 3;
		lblBalance.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(lblBalance, gbc_lblBalance);
		
		GridBagConstraints gbc_txtAdvance = new GridBagConstraints();
		gbc_txtAdvance.insets = new Insets(7, 0, 7, 0);
		gbc_txtAdvance.fill = GridBagConstraints.BOTH;
		gbc_txtAdvance.gridx = 4;
		gbc_txtAdvance.gridy = 3;
		panel_1.add(txtAdvance, gbc_txtAdvance);
		
		GridBagConstraints gbc_chckbxHalf = new GridBagConstraints();
		gbc_chckbxHalf.anchor = GridBagConstraints.WEST;
		gbc_chckbxHalf.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxHalf.gridx = 0;
		gbc_chckbxHalf.gridy = 4;
		chckbxHalf.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(chckbxHalf, gbc_chckbxHalf);
		
		GridBagConstraints gbc_txtHalf = new GridBagConstraints();
		gbc_txtHalf.insets = new Insets(7, 0, 7, 5);
		gbc_txtHalf.fill = GridBagConstraints.BOTH;
		gbc_txtHalf.gridx = 1;
		gbc_txtHalf.gridy = 4;
		panel_1.add(txtHalf, gbc_txtHalf);
		 
		GridBagConstraints gbc_lblRemainder = new GridBagConstraints();
		gbc_lblRemainder.anchor = GridBagConstraints.WEST;
		gbc_lblRemainder.insets = new Insets(0, 0, 5, 5);
		gbc_lblRemainder.gridx = 3;
		gbc_lblRemainder.gridy = 4;
		lblRemainder.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(lblRemainder, gbc_lblRemainder);
		
		GridBagConstraints gbc_txtRemainder = new GridBagConstraints();
		gbc_txtRemainder.insets = new Insets(7, 0, 7, 0);
		gbc_txtRemainder.fill = GridBagConstraints.BOTH;
		gbc_txtRemainder.gridx = 4;
		gbc_txtRemainder.gridy = 4;
		panel_1.add(txtRemainder, gbc_txtRemainder);
		
		GridBagConstraints gbc_btnConfirmOrder = new GridBagConstraints();
		gbc_btnConfirmOrder.anchor = GridBagConstraints.SOUTH;
		gbc_btnConfirmOrder.insets = new Insets(0, 0, 0, 5);
		gbc_btnConfirmOrder.gridx = 2;
		gbc_btnConfirmOrder.gridy = 5;
		btnConfirmOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Action for cofirm order button
				
			if (txtVoucherNo.getText().trim().isEmpty() || !txtVoucherNo.getText().matches(numToken))
					{
				JOptionPane.showMessageDialog(null, "Numeric Value must be present Voucher Field",
						"ERROR", JOptionPane.ERROR_MESSAGE);
				txtVoucherNo.requestFocus();
				return;
					}
			if (chckbxHalf.isSelected())
			{
				if (txtHalf.getText().trim().isEmpty() || !txtHalf.getText().matches(numToken))
				{
					JOptionPane.showMessageDialog(null, "Numeric Value must be present Half Brick Field",
							"ERROR", JOptionPane.ERROR_MESSAGE);
					txtHalf.requestFocus();
					return;
					
				}
			}
			
			int vehicle = ((VehicleInfo) comboBoxVehicleNo.getSelectedItem()).vechileId;
			DatabaseHelper databasehelper = new DatabaseHelper();
			Object[] t =(Object[]) (databasehelper.insertOrderDelivery(txtVoucherNo.getText(), ((VehicleInfo) comboBoxVehicleNo.getSelectedItem()).vechileId, ((EmployeeHelper) comboBoxDriverName.getSelectedItem()).id, ((BrickHelper) comboBoxBrickType.getSelectedItem()).id, Integer.valueOf(txtHalf.getText().toString()), ((CustomerHelper) comboBoxCustomer.getSelectedItem()).id, txtDestination.getText()));
			if (Integer.valueOf(t[0].toString()) == 1)
			{
				JOptionPane.showMessageDialog(null, "Successfully Added",
						"Success", JOptionPane.DEFAULT_OPTION);
			}
			else
			{
				JOptionPane.showMessageDialog(null, t[1],
						"Error", JOptionPane.ERROR_MESSAGE);
				
			}
				
			}
		});
		
		btnConfirmOrder.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(btnConfirmOrder, gbc_btnConfirmOrder);
		
		
	}
	
	private CaretListener onTxtAdvanceChangeListner = new CaretListener() {

		@Override
		public void caretUpdate(CaretEvent e) {
			int remainder = Integer.valueOf(txtTotal.getText().toString())
					- Integer.valueOf(txtAdvance.getText().trim().isEmpty()?"0":txtAdvance.getText() 	);
			txtRemainder.setText(String.valueOf(remainder));

		}
	};
	
	public class MyListRender extends JLabel implements
	ListCellRenderer<Object> {

private static final long serialVersionUID = 1L;

@Override
public Component getListCellRendererComponent(
		JList<? extends Object> list, Object value, int index,
		boolean isSelected, boolean cellHasFocus) {
	VehicleInfo tt = (VehicleInfo) value;

	setText(tt.vechileNo);
	return this;
}

}
	
	class searchComboBoxEditor implements ComboBoxEditor {
		JTextField jTextField;

		public searchComboBoxEditor() {
			super();
			jTextField = new JTextField();
		}

		@Override
		public void setItem(Object anObject) {

			if (anObject instanceof VehicleInfo) {
				VehicleInfo o = (VehicleInfo) anObject;
				jTextField.setText(o.vechileNo);
			} else {
				jTextField.setText((String) anObject);
			}

		}

		@Override
		public Object getItem() {
			return jTextField.getText();
		}

		@Override
		public Component getEditorComponent() {
			// TODO Auto-generated method stub
			return jTextField;
		}

		@Override
		public void selectAll() {
			jTextField.selectAll();

		}

		@Override
		public void addActionListener(ActionListener l) {
			// TODO Auto-generated method stub

		}

		@Override
		public void removeActionListener(ActionListener l) {
			// TODO Auto-generated method stub

		}

	}
	
	public class DriverRender extends JLabel implements
	ListCellRenderer<Object> {

private static final long serialVersionUID = 1L;

@Override
public Component getListCellRendererComponent(
		JList<? extends Object> list, Object value, int index,
		boolean isSelected, boolean cellHasFocus) {
	EmployeeHelper tt = (EmployeeHelper) value;

	setText(tt.name);
	return this;
}

}
	
	class DriverEditor implements ComboBoxEditor {
		JTextField jTextField;

		public DriverEditor() {
			super();
			jTextField = new JTextField();
		}

		@Override
		public void setItem(Object anObject) {

			if (anObject instanceof EmployeeHelper) {
				EmployeeHelper o = (EmployeeHelper) anObject;
				jTextField.setText(o.name);
			} else {
				jTextField.setText((String) anObject);
			}

		}

		@Override
		public Object getItem() {
			return jTextField.getText();
		}

		@Override
		public Component getEditorComponent() {
			// TODO Auto-generated method stub
			return jTextField;
		}

		@Override
		public void selectAll() {
			jTextField.selectAll();

		}

		@Override
		public void addActionListener(ActionListener l) {
			// TODO Auto-generated method stub

		}

		@Override
		public void removeActionListener(ActionListener l) {
			// TODO Auto-generated method stub

		}

	}
	
	public class BrickRender extends JLabel implements
	ListCellRenderer<Object> {

private static final long serialVersionUID = 1L;

@Override
public Component getListCellRendererComponent(
		JList<? extends Object> list, Object value, int index,
		boolean isSelected, boolean cellHasFocus) {
	BrickHelper tt = (BrickHelper) value;

	setText(tt.name);
	return this;
}

}
	
	class BrickEditor implements ComboBoxEditor {
		JTextField jTextField;

		public BrickEditor() {
			super();
			jTextField = new JTextField();
		}

		@Override
		public void setItem(Object anObject) {

			if (anObject instanceof BrickHelper) {
				BrickHelper o = (BrickHelper) anObject;
				jTextField.setText(o.name);
			} else {
				jTextField.setText((String) anObject);
			}

		}

		@Override
		public Object getItem() {
			return jTextField.getText();
		}

		@Override
		public Component getEditorComponent() {
			// TODO Auto-generated method stub
			return jTextField;
		}

		@Override
		public void selectAll() {
			jTextField.selectAll();

		}

		@Override
		public void addActionListener(ActionListener l) {
			// TODO Auto-generated method stub

		}

		@Override
		public void removeActionListener(ActionListener l) {
			// TODO Auto-generated method stub

		}

	}
	
	public class CustomerRender extends JLabel implements
	ListCellRenderer<Object> {

private static final long serialVersionUID = 1L;

@Override
public Component getListCellRendererComponent(
		JList<? extends Object> list, Object value, int index,
		boolean isSelected, boolean cellHasFocus) {
	CustomerHelper tt = (CustomerHelper) value;

	setText(tt.name);
	return this;
}

}
	
	class CustomerEditor implements ComboBoxEditor {
		JTextField jTextField;

		public CustomerEditor() {
			super();
			jTextField = new JTextField();
		}

		@Override
		public void setItem(Object anObject) {

			if (anObject instanceof CustomerHelper) {
				CustomerHelper o = (CustomerHelper) anObject;
				jTextField.setText(o.name);
			} else {
				jTextField.setText((String) anObject);
			}

		}

		@Override
		public Object getItem() {
			return jTextField.getText();
		}

		@Override
		public Component getEditorComponent() {
			// TODO Auto-generated method stub
			return jTextField;
		}

		@Override
		public void selectAll() {
			jTextField.selectAll();

		}

		@Override
		public void addActionListener(ActionListener l) {
			// TODO Auto-generated method stub

		}

		@Override
		public void removeActionListener(ActionListener l) {
			// TODO Auto-generated method stub

		}

	}
	private final JComboBox<CustomerHelper> comboBoxCustomer = new JComboBox<CustomerHelper>();
	private final JLabel lblDestination = new JLabel("Destination");
	private final JTextField txtDestination = new JTextField();

}
