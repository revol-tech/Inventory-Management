package com.brick.panel;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.basic.BasicComboBoxEditor;

import com.brick.database.DatabaseHelper;
import com.brick.helper.AutoCompleteData;
import com.brick.helper.AutoCompletion;
import com.brick.helper.LaborHelper;

public class LaborWork extends JPanel {

	DatabaseHelper databasehelper = new DatabaseHelper();
	String[] labortype = { "", "Madeshi", "Bokenya", "Patheri" };

	private final JLabel lblLaborName = new JLabel("Labor Name");
	private final JLabel lblLaborType = new JLabel("Labor Type");
	private final JComboBox<LaborHelper> labourname = new JComboBox<LaborHelper>();
	
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
	 * Create the panel.new 
	 */
	public LaborWork() {
		textField_1.setBounds(142, 20, 145, 19);
		textField_1.setColumns(10);
		labourname.setBounds(239, 65, 146, 19);
		ArrayList<LaborHelper> list = new ArrayList<LaborHelper>();
		list = databasehelper.fetchLaborName();
		/*
		 * for (LaborHelper laborHelper : list) {
		 * 
		 * labourname.addItem(laborHelper); }
		 */
		for (LaborHelper laborHelper1 : list) {
			System.out.println(laborHelper1.name);
			labourname.addItem(laborHelper1);
		}
		labourname.setEditor(new searchComboBoxEditor());
		labourname.setRenderer(new MyListRender());
		labourname.setEditable(true);
		
		//AutoCompletion.enable(labourname);
		new AutoCompleteData(labourname);
		initGUI();

	}

	private void initGUI() {
		setLayout(null);
		// this.setSize(JFrame.MAXIMIZED_BOTH);
		lblLaborName.setBounds(99, 67, 109, 15);

		add(lblLaborName);
		lblLaborType.setBounds(99, 120, 109, 15);

		add(lblLaborType);

		add(labourname);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = comboBox.getSelectedItem().toString();
				if (name == "Bokenya") {
					patheri.setVisible(false);
					madhesi.setVisible(false);
					bokenya.setVisible(true);
				} else if (name == "Madeshi") {

					patheri.setVisible(false);
					bokenya.setVisible(false);
					madhesi.setVisible(true);

				} else if (name == "Patheri") {

					bokenya.setVisible(false);
					madhesi.setVisible(false);
					patheri.setVisible(true);

				} else {

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

	public class MyListRender extends JLabel implements
			ListCellRenderer<Object> {

		/**
 * 
 */
		private static final long serialVersionUID = 1L;

		@Override
		public Component getListCellRendererComponent(
				JList<? extends Object> list, Object value, int index,
				boolean isSelected, boolean cellHasFocus) {
			LaborHelper tt = (LaborHelper) value;
			
			
			setText(tt.name);
			return this;
		}

	}
	class searchComboBoxEditor extends BasicComboBoxEditor {

        public searchComboBoxEditor() {
            super();
        }

        @Override
        public void setItem(Object anObject) {
            if (anObject == null) {
                super.setItem("");
            } else {
            	if(anObject instanceof LaborHelper){
                LaborHelper o = (LaborHelper)anObject;
                System.out.print("m"+o.name);
                super.setItem(o.name);
            	}else if(anObject instanceof String){
            		super.setItem(anObject);
            	}
            }
        }

        @Override
        public Object getItem() {
            return new LaborHelper();
        }
    }
	
}
