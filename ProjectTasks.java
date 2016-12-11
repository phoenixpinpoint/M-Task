package com.phoenixpinpoint.DevTools;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProjectTasks extends JPanel {

	private JTable table;
	
	/**
	 * Create the panel.
	 */
	public ProjectTasks() {
		setLayout(null);
		
		JLabel label = new JLabel("Status:");
		label.setBounds(10, 14, 46, 14);
		add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(66, 11, 85, 20);
		add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 590, 363);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{},
			},
			new String[] {
				"Task ID", "Task Title", "Task Due Date", "Task Status"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(183);
		table.getColumnModel().getColumn(2).setPreferredWidth(117);
		table.getColumnModel().getColumn(3).setPreferredWidth(103);
	}
}
