package com.brick.helper;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class CustomRender extends JLabel implements ListCellRenderer<Object> {

	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(JList<? extends Object> list,
			Object value, int index, boolean isSelected, boolean cellHasFocus) {
		if (value instanceof CustomerHelper) {
			CustomerHelper tt = (CustomerHelper) value;
			setText(tt.name);
		} else if (value instanceof BrickHelper) {
			BrickHelper tt = (BrickHelper) value;
			setText(tt.name);
		} else if (value instanceof EmployeeHelper) {
			EmployeeHelper tt = (EmployeeHelper) value;
			setText(tt.name);
		} else if (value instanceof VehicleInfo) {
			VehicleInfo tt = (VehicleInfo) value;
			setText(tt.vechileNo);
		} else if (value instanceof LaborHelper) {
			LaborHelper tt = (LaborHelper) value;
			setText(tt.name);

		}

		return this;
	}

}
