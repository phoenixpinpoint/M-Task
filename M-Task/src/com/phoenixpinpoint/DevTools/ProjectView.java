package com.phoenixpinpoint.DevTools;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class ProjectView extends JFrame {

	private JPanel contentPane;
	private JTextField projectNameField;
	private JTextField projectTeamField;
	private JTabbedPane tabbedPane;


	/**
	 * Create the frame.
	 */
	public ProjectView(Project p) {
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProjectView.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		String title = p.getTitle();
		setTitle("Project: " + title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 792, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProjectName = new JLabel("Project Name:");
		lblProjectName.setBounds(10, 11, 68, 14);
		contentPane.add(lblProjectName);
		
		projectNameField = new JTextField();
		projectNameField.setEditable(false);
		projectNameField.setBounds(88, 8, 237, 20);
		contentPane.add(projectNameField);
		projectNameField.setColumns(10);
		projectNameField .setText(p.getTitle());
		
		JLabel lblProjectTeam = new JLabel("Project Team:");
		lblProjectTeam.setBounds(10, 36, 68, 14);
		contentPane.add(lblProjectTeam);
		
		projectTeamField = new JTextField();
		projectTeamField.setEditable(false);
		projectTeamField.setBounds(88, 33, 237, 20);
		contentPane.add(projectTeamField);
		projectTeamField.setColumns(10);
		projectTeamField.setText(p.getTeam());
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 61, 766, 488);
		contentPane.add(tabbedPane);
		
		ProjectDetails details = new ProjectDetails();
		
		tabbedPane.addTab("Details", details);
		
		ProjectTasks tasks = new ProjectTasks();
		
		tabbedPane.addTab("Tasks", tasks);
		
	}
}
