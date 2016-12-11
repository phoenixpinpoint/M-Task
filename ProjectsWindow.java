package com.phoenixpinpoint.DevTools;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProjectsWindow extends JFrame {

	private JPanel contentPane;
	private ProjectManager manager;
	private JList projectList;

	/**
	 * Create the frame.
	 */
	public ProjectsWindow(ProjectManager projectManager) {
		setVisible(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProjectsWindow.class.getResource("/com/sun/java/swing/plaf/windows/icons/HardDrive.gif")));
		setTitle("Projects");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 549, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewProject = new JButton("New Project");
		btnNewProject.setBounds(381, 10, 125, 23);
		contentPane.add(btnNewProject);
		
		DefaultListModel listModel = new DefaultListModel();
		
		projectList = new JList(listModel);
		projectList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && !e.isConsumed()) 
				{
					e.consume();
					manager.loadProject(projectList.getSelectedIndex());
					dispose();
				}
				else
				{
					projectList.getSelectedIndex();
				}
			}
		});
		projectList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		projectList.setBounds(10, 11, 361, 455);
		contentPane.add(projectList);
		
		JButton btnEditProject = new JButton("Edit Project");
		btnEditProject.setBounds(381, 44, 125, 23);
		contentPane.add(btnEditProject);
		
		JButton btnDeleteProject = new JButton("Delete Project");
		btnDeleteProject.setBounds(381, 78, 125, 23);
		contentPane.add(btnDeleteProject);
		
		manager = projectManager;
		
		for(int i = 0; i <= manager.getProjectCount(); i++)
		{
			listModel.addElement(manager.getProjectTitle(i));
		}
		//ProjectList.addElement()
	}
}
