package com.phoenixpinpoint.DevTools;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.border.BevelBorder;

import java.awt.Button;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProjectDetails extends JPanel {
	private JTextField dueDateField;
	private JTextField gitRepoField;
	private DefaultListModel listModel;

	/**
	 * Create the panel.
	 */
	public ProjectDetails() {
		setLayout(null);
		
		JLabel lblProjectDueDate = new JLabel("Project Due Date:");
		lblProjectDueDate.setBounds(10, 11, 86, 14);
		add(lblProjectDueDate);
		
		JLabel lblProjectStatus = new JLabel("Project Status:");
		lblProjectStatus.setBounds(10, 36, 86, 14);
		add(lblProjectStatus);
		
		JLabel lblProjectGitRepository = new JLabel("Project Git Repository:");
		lblProjectGitRepository.setBounds(10, 61, 109, 14);
		add(lblProjectGitRepository);
		
		dueDateField = new JTextField();
		dueDateField.setBounds(129, 8, 109, 20);
		add(dueDateField);
		dueDateField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Created", "Approved", "Open", "Completed", "Closed"}));
		comboBox.setBounds(129, 33, 109, 20);
		add(comboBox);
		
		gitRepoField = new JTextField();
		gitRepoField.setBounds(129, 58, 137, 20);
		add(gitRepoField);
		gitRepoField.setColumns(10);
		
		JLabel lblProgrammingLanguages = new JLabel("Programming Language(s):");
		lblProgrammingLanguages.setBounds(10, 86, 137, 14);
		add(lblProgrammingLanguages);
		
		listModel = new DefaultListModel();
		
		JList list = new JList(listModel);
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setBounds(10, 106, 137, 183);
		add(list);
		
		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddProgramLanguageDialog addLanguage = new AddProgramLanguageDialog(listModel);
			}
		});
		button.setBounds(157, 105, 41, 23);
		add(button);
		
		JButton button_1 = new JButton("-");
		button_1.setBounds(157, 139, 41, 23);
		add(button_1);

	}
}
