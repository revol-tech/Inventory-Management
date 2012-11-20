package com.brick.helper;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxEditor;
import javax.swing.JTextField;

public class CustomComboBoxEditor implements ComboBoxEditor {
	JTextField jTextField;

	public CustomComboBoxEditor() {
		super();
		jTextField = new JTextField();
	}

	@Override
	public void setItem(Object anObject) {

		if (anObject instanceof LaborHelper) {
			LaborHelper laborHelper = (LaborHelper) anObject;
			jTextField.setText(laborHelper.name);
		} else if (anObject instanceof CustomerHelper) {
			CustomerHelper customerHelper = (CustomerHelper) anObject;
			jTextField.setText(customerHelper.name);
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
