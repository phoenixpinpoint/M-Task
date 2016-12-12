/*********************************************
 * M-Task Version 1.2.3
 * Build:
 * 	Major: 6272016
 *  Minor: 162801
 * 
 * Created by phoenixpinpoint
 * 
 * 
 * Class: TaskWindow
 * Version: 62720161628
 * 
 * 
 * Support:
 * *********************************************/
package com.phoenixpinpoint.DevTools;

//AWT Components
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;

//Swing Components
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.Toolkit;


public class TaskWindow extends JFrame {//Changed to JFrame from JDialog so it will show up as child window on Start menu

	//Declare and Initialize Panel for content
	JPanel overviewPanel = new JPanel();
	
	//Declare JTextFields and JTextPanes
	JTextField taskTitleField;
	JTextField createdOnField;
	JTextField dueDateField;
	JTextPane descriptionPane;
	JTextField createdByField;
	JTextField taskProjectField;
	//Declare Comboboxes
	JComboBox statuComboBox = new JComboBox();
	JComboBox priorityComboBox = new JComboBox();
	JLabel lblId;
	JScrollPane descriptionScrollPane;
	
	int newTicket = 0;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

	public void saveTask()
	{
		String title = taskTitleField.getText();
		String description = descriptionPane.getText();
		String dueDate = dueDateField.getText();
		String project = taskProjectField.getText();
		String status = statuComboBox.getSelectedItem().toString();
		String submitter = createdByField.getText();
		String priority = priorityComboBox.getSelectedItem().toString();
		
		SimpleDateFormat americanFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		
		String dateSubmitted = americanFormat.format(cal.getTime());
		
		String saveSQL = "INSERT INTO `tasks` (`taskname`, `taskdescription`, `taskpriority`, `taskproject`, `taskstatus`, `tasksubmitter`, `datesubmitted`, `taskduedate`) VALUE ('"+title+"',"+"'"+description+"',"+"'"+priority+"','"+ project + "'," + "'" + status + "','" + submitter +  "','"+ dateSubmitted+"','"+ dueDate+"');";
		
		System.out.println(saveSQL);
		
		try {
			MTask.db.stmt.executeUpdate(saveSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateTask()
	{
		String title = taskTitleField.getText();
		String description = descriptionPane.getText();
		String dueDate = dueDateField.getText();
		String project = taskProjectField.getText();
		String status = statuComboBox.getSelectedItem().toString();
		String submitter = createdByField.getText();
		String priority = priorityComboBox.getSelectedItem().toString();
		String id = lblId.getText();
		
		
		String updateSQL = "UPDATE `tasks` SET `taskname` = '"+title+"',`taskpriority` = '"+priority+"', `taskduedate` = '" + dueDate+ "', `taskproject` = '" + project + "', `taskstatus` = '" + status + "', `tasksubmitter` = '"+ submitter+"'" + ", `tasksubmitted` = '" + description + "' WHERE `TaskId` = '" + id + "';";		
		
		System.out.println(updateSQL);
		
		try {
			MTask.db.stmt.executeUpdate(updateSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void loadTask(String selectedData)
	{
		String title = null;
		String description = null;
		String dueDate = null;
		String project = null;
		String status = null;
		String submitter = null;
		String createdBy = null;
		String createdOn = null;
		String priority = null;
		int id = 0;
		
		String getSQL = "SELECT * FROM `tasks` WHERE `idtasks` = '"+ selectedData + "';";
		
		try {
			ResultSet getSet = MTask.db.stmt.executeQuery(getSQL);
			while(getSet.next())
			{
				title = getSet.getString("taskname");
				description = getSet.getString("taskdescription");
				dueDate = getSet.getString("taskduedate");
				project = getSet.getString("taskproject");
				status = getSet.getString("taskstatus");
				submitter = getSet.getString("tasksubmitter");
				priority = getSet.getString("taskpriority");
				createdOn = getSet.getString("datesubmitted");
				createdBy = getSet.getString("tasksubmitter");
				id = getSet.getInt("idtasks");
				
				
				//System.out.println(getSet.getString("TaskTitle"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		taskTitleField.setText(title);
		descriptionPane.setText(description);
		dueDateField.setText(dueDate);
		taskProjectField.setText(project);
		statuComboBox.setSelectedItem(status);
		createdByField.setText(submitter);
		priorityComboBox.setSelectedItem(priority);
		createdOnField.setText(createdOn);
		createdByField.setText(createdBy);
		lblId.setText(Integer.toString(id));
	}
	/**
	 * Create the dialog.
	 */
	public TaskWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TaskWindow.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
		//Set up Dialogbox
		setTitle("Task");//Set Title to Task
		setBounds(100, 100, 563, 412);
		getContentPane().setLayout(null);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 339, 535, 35);
			buttonPane.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (newTicket == 1)
						{
							saveTask();
						}
						else
						{
							updateTask();
						}
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		tabbedPane.setBounds(0, 0, 547, 339);
		getContentPane().add(tabbedPane);
		tabbedPane.addTab("Overview", new ImageIcon(TaskWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/menu.gif")), overviewPanel, null);
		overviewPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		overviewPanel.setLayout(null);//Set Layout to static or null
		
		//Declare JLabel Variables for JTextFields and JComboboxes
		JLabel lblTaskTitle = new JLabel("Task Title:");
		JLabel lblTaskStatus = new JLabel("Task Status:");
		JLabel lblTaskDueDate = new JLabel("Task Due Date:");
		JLabel lblTaskCreatedOn = new JLabel("Task Created On:");
		JLabel lblTaskPriority = new JLabel("Task Priority:");
		JLabel lblTaskDescription = new JLabel("Task Description:");
		JLabel lblProject = new JLabel("Project:");
		JLabel lblTaskCreatedBy = new JLabel("Task Created By:");
		
		//Set Label Bounds in x,y,w,h format
		lblTaskTitle.setBounds(10, 11, 55, 14);
		lblTaskStatus.setBounds(10, 36, 67, 14);
		lblTaskDueDate.setBounds(10, 61, 80, 14);
		lblTaskCreatedOn.setBounds(10, 86, 92, 14);
		lblTaskDescription.setBounds(10, 111, 82, 14);
		lblTaskPriority.setBounds(214, 36, 67, 14);
		
		//Add Label to contentPanel
		overviewPanel.add(lblTaskTitle);
		overviewPanel.add(lblTaskDueDate);
		overviewPanel.add(lblTaskCreatedOn);
		overviewPanel.add(lblTaskDescription);
		overviewPanel.add(lblTaskPriority);
		overviewPanel.add(lblTaskStatus);
		
		//Initialize TextField an TextPane Objects
		taskTitleField = new JTextField();
		createdOnField = new JTextField();
		dueDateField = new JTextField();
		descriptionPane = new JTextPane();
		
		//Set Location and size (Bounds) of TextFields and textPanes
		taskTitleField.setBounds(124, 8,234, 20);
		createdOnField.setBounds(124, 83, 234, 20);
		descriptionPane.setBounds(10, 136, 515, 137);
		
		taskTitleField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		overviewPanel.add(taskTitleField);
		taskTitleField.setColumns(10);
		
		

		
		statuComboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Created", "Approved", "Open", "Completed", "Closed"}));
		statuComboBox.setBounds(124, 33, 80, 20);
		overviewPanel.add(statuComboBox);
		
				createdOnField.setEditable(false);
				createdOnField.setEnabled(false);
				
						createdOnField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
						overviewPanel.add(createdOnField);
						createdOnField.setColumns(10);
						
						//descriptionPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
						//contentPanel.add(descriptionPane);
						
						dueDateField.setBounds(124, 58, 98, 20);
						overviewPanel.add(dueDateField);
						dueDateField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
						
						JCalendarButton dueDate = new JCalendarButton(dueDateField);
						dueDate.setBounds(dueDateField);
						overviewPanel.add(dueDate);
						


	
						priorityComboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Critical", "High", "Medium", "Low"}));
						priorityComboBox.setBounds(291, 33, 67, 20);
						overviewPanel.add(priorityComboBox);
						
						lblTaskCreatedBy.setBounds(351, 111, 92, 14);
						overviewPanel.add(lblTaskCreatedBy);
						
						createdByField = new JTextField();
						createdByField.setEditable(false);
						createdByField.setBounds(439, 108, 86, 20);
						overviewPanel.add(createdByField);
						createdByField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
						createdByField.setText(MTask.user);
						
						
						lblProject.setBounds(368, 11, 46, 14);
						overviewPanel.add(lblProject);
						
						taskProjectField = new JTextField();
						taskProjectField.setBounds(411, 8, 114, 20);
						overviewPanel.add(taskProjectField);
						taskProjectField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
						
						lblId = new JLabel("id");
						lblId.setBounds(479, 36, 46, 14);
						overviewPanel.add(lblId);
						
						descriptionScrollPane = new JScrollPane();
						descriptionScrollPane.setBounds(10, 136, 515, 137);
						descriptionScrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
						descriptionScrollPane.setViewportView(descriptionPane);
						overviewPanel.add(descriptionScrollPane);
						
						JPanel notesPanel = new JPanel();
						tabbedPane.addTab("Notes", new ImageIcon(TaskWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/hardDrive.gif")), notesPanel, null);
						notesPanel.setLayout(null);
						
						JLabel lblNotes = new JLabel("Notes:");
						lblNotes.setBounds(10, 11, 46, 14);
						notesPanel.add(lblNotes);
						
						JTextArea noteTextArea = new JTextArea();
						noteTextArea.setBounds(10, 30, 510, 268);
						notesPanel.add(noteTextArea);
						noteTextArea.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	}
}
