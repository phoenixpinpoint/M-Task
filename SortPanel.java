package com.phoenixpinpoint.DevTools;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class SortPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public SortPanel() {
		setLayout(null);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(10, 11, 46, 14);
		add(lblStatus);
		
		JComboBox statusComboBox = new JComboBox();
		statusComboBox.setModel(new DefaultComboBoxModel(new String[] {"All", "Created", "Approved", "Open", "Completed", "Closed"}));
		statusComboBox.setBounds(66, 8, 85, 20);
		add(statusComboBox);
		
		JLabel lblProject = new JLabel("Project:");
		lblProject.setBounds(161, 11, 46, 14);
		add(lblProject);
		
		JComboBox projectComboBox = new JComboBox();
		projectComboBox.setBounds(217, 8, 85, 20);
		add(projectComboBox);

	}
}
