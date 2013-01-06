package com.brick.panel;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import com.brick.database.DatabaseHelper;

/**
 * @version 1.0 11/09/98
 */
public class ButtonEditor extends DefaultCellEditor {
  protected JButton button;
  private String    label;
  private boolean   isPushed;
  DatabaseHelper databaseHelper;
  int value;
  public ButtonEditor(JCheckBox checkBox , int a,int id) {
    super(checkBox);
    button = new JButton();
    button.setOpaque(true);
    if (a>-1)
    {
    	System.err.println("fuck this system");
    	/*try {
			databaseHelper.deleterow(id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
*/    }
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
      }
    });
  }
 
  public Component getTableCellEditorComponent(JTable table, Object value,
                   boolean isSelected, int row, int column) {
    if (isSelected) {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
    } else{
      button.setForeground(table.getForeground());
      button.setBackground(table.getBackground());
    }
    label = (value ==null) ? "" : value.toString();
    button.setText( label );
    isPushed = true;
    return button;
  }
 
  public Object getCellEditorValue() {
    if (isPushed)  {
      // 
      // 
    	
      JOptionPane.showMessageDialog(button ,label + ": Ouch!"+value);
      System.err.println(value);
      // System.out.println(label + ": Ouch!");
    }
    isPushed = false;
    return new String( label ) ;
  }
   
  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }
 
  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }
}