package com.brick.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JList;
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
import javax.swing.plaf.basic.BasicComboBoxEditor;

import com.brick.database.DatabaseHelper;
import com.brick.helper.LaborHelper;
import com.brick.helper.VehicleInfo;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

public class Order extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private final JComboBox comboBoxVehicleNo = new JComboBox();
	private final JComboBox comboBoxDriverName = new JComboBox();
	private final JComboBox comboBoxBrickType = new JComboBox();
	private final JLabel lblCustomerName = new JLabel("Customer Name");
	private final JTextField txtCustomerName = new JTextField();
	private final JButton btnConfirmOrder = new JButton("Confirm Order");
	private final JLabel lblOrderDelivery = new JLabel("Order Delivery");
	private final JLabel lblTotal = new JLabel("Total");
	private final JLabel lblBalance = new JLabel("Balance");
	private final JLabel lblRemainder = new JLabel("Remainder");
	private final JTextField txtTotal = new JTextField();
	private final JTextField txtBalance = new JTextField();
	private final JTextField txtRemainder = new JTextField();
	DatabaseHelper databaseHelper=new DatabaseHelper();

	/**
	 * Create the panel.
	 */
	public Order() {
		txtRemainder.setColumns(10);
		txtBalance.setColumns(10);
		txtTotal.setColumns(10);
		txtCustomerName.setColumns(10);
		txtHalf.setColumns(10);
		txtVoucherNo.setColumns(10);

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
		gbl_panel_1.columnWidths = new int[] { 135, 160, 0, 140, 160 };
		gbl_panel_1.rowHeights = new int[] { 45, 45, 45, 45, 45, 80 };
		// gbl_panel_1.columnWidths = new int[]{143, 200, 93, 146, 200};
		// gbl_panel_1.columnWidths = new int[]{160, 0, 0, 0, 0, 0, 0};
		// gbl_panel_1.rowHeights = new int[]{45, 45, 45, 45, 45, 80};
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
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

		GridBagConstraints gbc_txtCustomerName = new GridBagConstraints();
		gbc_txtCustomerName.insets = new Insets(7, 0, 7, 0);
		gbc_txtCustomerName.fill = GridBagConstraints.BOTH;
		gbc_txtCustomerName.gridx = 4;
		gbc_txtCustomerName.gridy = 0;
		panel_1.add(txtCustomerName, gbc_txtCustomerName);

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
		panel_1.add(comboBoxVehicleNo, gbc_comboBoxVehicleNo);

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
		panel_1.add(comboBoxDriverName, gbc_comboBoxDriverName);

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

		GridBagConstraints gbc_lblBalance = new GridBagConstraints();
		gbc_lblBalance.anchor = GridBagConstraints.WEST;
		gbc_lblBalance.insets = new Insets(0, 0, 5, 5);
		gbc_lblBalance.gridx = 3;
		gbc_lblBalance.gridy = 3;
		lblBalance.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(lblBalance, gbc_lblBalance);

		GridBagConstraints gbc_txtBalance = new GridBagConstraints();
		gbc_txtBalance.insets = new Insets(7, 0, 7, 0);
		gbc_txtBalance.fill = GridBagConstraints.BOTH;
		gbc_txtBalance.gridx = 4;
		gbc_txtBalance.gridy = 3;
		panel_1.add(txtBalance, gbc_txtBalance);

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
		btnConfirmOrder.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(btnConfirmOrder, gbc_btnConfirmOrder);
	}

	public class MyListRender extends JLabel implements
			ListCellRenderer<Object> {

		private static final long serialVersionUID = 1L;

		@Override
		public Component getListCellRendererComponent(
				JList<? extends Object> list, Object value, int index,
				boolean isSelected, boolean cellHasFocus) {
			VehicleInfo object = (VehicleInfo) value;

			setText(object.vechileNo);
			return this;
		}

	}

	class ComboBoxEditor extends BasicComboBoxEditor {

		public ComboBoxEditor() {
			super();
		}

		@Override
		public void setItem(Object anObject) {
			if (anObject == null) {
				super.setItem("");
			} else {
				if (anObject instanceof LaborHelper) {
					VehicleInfo o = (VehicleInfo) anObject;

					super.setItem(o.vechileNo);
				} else if (anObject instanceof String) {
					super.setItem(anObject);
				}
			}
		}

		@Override
		public Object getItem() {
			return new VehicleInfo();
		}
	}

}
