/*********************************************
 * M-Task Version 1.2.3
 * Build:
 * 	Major: 6272016
 *  Minor: 162801
 * 
 * Created by phoenixpinpoint
 * 
 * 
 * Class: MTask
 * Version: 62720161628
 * 
 * 
 * Support: 
 * *********************************************/
package com.phoenixpinpoint.DevTools;

//Swing Components
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



//AWT Components
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;


//Class Definition
public class MTask {

	static MTask window;
	static JFrame MTaskWindow;//Window
	static TaskWindow newTask;//TaskWindow
	static SQLManager db;
	LoginDialog loginDialog = new LoginDialog();
	
	static int loggedIn = 0;
	static JTextField usernameStatusBar;
	static JTextField refreashStatusBar;
	static JTextField endStatusBar;
	
	static String user = " ";
	static String selectedData;
	
	static SortPanel sorter;
	
	ProjectManager manager;
	
	//Declare table to view tasks
	JTable taskTable;
	
	String columnTitles[] = {"Task ID", "Task Title","Task Project", "Task Due Date", "Task Status"};
	Object[][] data = null;

	//Instantiate scrollpane for table scroll bars
	JScrollPane scrollPane = new JScrollPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				//Load the Windows look and feel so the program looks like a windows program.
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				try {
					//Instantiate the MTask Class
					window = new MTask();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MTask() {
		db = new SQLManager();
		initialize();//Call The initialize
	}

	public  void refreshTable()
	{
		System.out.println("Refreshing Table");
		refreashStatusBar.setText(" Refreashing...");
		
		ResultSet taskQuery = null;
		String getTask = "SELECT * FROM `MTaskTable` WHERE `TaskStatus` <> 'Closed'";
		String getTaskCount = "SELECT COUNT(TaskId) FROM `MTaskTable` WHERE `TaskStatus` <> 'Closed';";
		int count = 0;
		try {
			taskQuery = db.stmt.executeQuery(getTaskCount);
			while(taskQuery.next())
			{
				count = taskQuery.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data = new Object[count][6];
		int dataXCount = 0;
		int dataYCount = 1;
		while (dataXCount < count)
		{
			data[dataXCount][dataYCount] = "";
			data[dataXCount][dataYCount + 1] = "";
			data[dataXCount][dataYCount + 2] = "";
			data[dataXCount][dataYCount + 3] = "";
			data[dataXCount][dataYCount + 4] = "";
			dataXCount++;
		}

		dataXCount = 0;
		dataYCount = 0;
		

		try {
			taskQuery = db.stmt.executeQuery(getTask);
			while(taskQuery.next())
			{
				data[dataXCount][dataYCount] = taskQuery.getString("TaskId");
				data[dataXCount][dataYCount + 1] = taskQuery.getString("TaskTitle");
				data[dataXCount][dataYCount + 2] = taskQuery.getString( "TaskProject");
				data[dataXCount][dataYCount + 3] = taskQuery.getString("TaskDueDate");
				data[dataXCount][dataYCount + 4] = taskQuery.getString("TaskStatus");
				dataXCount++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		taskTable = new JTable(data, columnTitles);
		taskTable.setFillsViewportHeight(true);
		taskTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (! e.getValueIsAdjusting()){
					int[] selectedRow = taskTable.getSelectedRows();
					int[] selectedColumn = taskTable.getSelectedColumns();
					for (int i = 0; i < selectedRow.length; i++) {
						for (int j = 0; j < selectedColumn.length; j++) {
							selectedData = (String) taskTable.getValueAt(selectedRow[i], selectedColumn[0]);
		    	         }
					}
				}
		      }
		 	});
		scrollPane.setViewportView(taskTable);
		refreashStatusBar.setText(" Done.");
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MTaskWindow = new JFrame();//Create JFrame Component of Class
		MTaskWindow.setIconImage(Toolkit.getDefaultToolkit().getImage(MTask.class.getResource("/com/phoenixpinpoint/DevTools/Task.png")));
		MTaskWindow.setResizable(false);//Set Resizable to false
		MTaskWindow.setTitle("M-Task");//Set Window Title
		MTaskWindow.setBounds(100, 100, 1210, 822);//Set window size in x,y,w,h format
		MTaskWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Set close operation to exit
		MTaskWindow.getContentPane().setLayout(null);//Set layout to static/null
		MTaskWindow.setEnabled(false);
		loginDialog.setVisible(true);//Set login to visible
		
		//Instantiate MenuBar, Menus, MenuItems, and Separators
		JMenuBar menuBar = new JMenuBar();
		JMenu mnFile = new JMenu("File");
		JMenuItem mntmNewTask = new JMenuItem("New Task");
		mntmNewTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newTask = new TaskWindow();
				newTask.setVisible(true);
			}
		});
		JMenuItem mntmLoadTask = new JMenuItem("Load Task");
		mntmLoadTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadTaskDialog loadTask = new LoadTaskDialog();
				loadTask.setVisible(true);	
			}
		});
		JSeparator separator = new JSeparator();
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		JMenu mnHelp = new JMenu("Help");
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutDialog about = new AboutDialog();
				about.setVisible(true);
			}
		});
		
		//Instantiate buttons
		JButton btnCreateTask = new JButton("Create Task");
		JButton btnLoadTask = new JButton("Load Task");
		btnLoadTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaskWindow loader = new TaskWindow();
				loader.loadTask(selectedData);
				loader.setVisible(true);
			}
		});
		JButton btnDeleteTask = new JButton("Delete Task");
		btnDeleteTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteConfirmationDialog confirm = new DeleteConfirmationDialog();
				confirm.setVisible(true);
			}
		});
	
		//Set Size/Bounds in x,y,w,h format
		btnCreateTask.setBounds(480, 29, 109, 23);
		scrollPane.setBounds(10, 63, 1184, 668);
		btnLoadTask.setBounds(602, 29, 109, 23);
		btnDeleteTask.setBounds(721, 29, 109, 23);
		
		//Add GUI Objects to ContentPane of JFrame
		MTaskWindow.getContentPane().add(btnCreateTask);
		MTaskWindow.getContentPane().add(scrollPane);
		MTaskWindow.getContentPane().add(btnLoadTask);
		MTaskWindow.getContentPane().add(btnDeleteTask);
		
		//Set MenuBar for JFrame
		MTaskWindow.setJMenuBar(menuBar);
		
		
		//Populate MenuBar
		/* MenuBar Operation:
		 * MenuBar -> Menu -> MenuItem
		 * 	MenuBar is always the same
		 * 	Menu Would be File and Help
		 * 	MenuItem is New Task, Load Task, Exit, and Help
		 */
		menuBar.add(mnFile);
		mnFile.add(mntmNewTask);
		mnFile.add(mntmLoadTask);
		mnFile.add(separator);
		mnFile.add(mntmExit);
		
		JMenu mnProject = new JMenu("Project");
		menuBar.add(mnProject);
		
		JMenuItem mntmViewProjects = new JMenuItem("View Projects");
		mntmViewProjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProjectsWindow projects = new ProjectsWindow(manager);
			}
		});
		mnProject.add(mntmViewProjects);
		menuBar.add(mnHelp);
		mnHelp.add(mntmAbout);
		
		//Set ScrollPane Viewport
		scrollPane.setViewportView(taskTable);
		
		usernameStatusBar = new JTextField();
		usernameStatusBar.setEnabled(false);
		usernameStatusBar.setEditable(false);
		usernameStatusBar.setBounds(0, 753, 602, 20);
		MTaskWindow.getContentPane().add(usernameStatusBar);
		usernameStatusBar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTable();
			}
		});
		btnRefresh.setBounds(840, 29, 109, 23);
		MTaskWindow.getContentPane().add(btnRefresh);
		
		refreashStatusBar = new JTextField();
		refreashStatusBar.setEnabled(false);
		refreashStatusBar.setEditable(false);
		refreashStatusBar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		refreashStatusBar.setBounds(602, 753, 109, 20);
		MTaskWindow.getContentPane().add(refreashStatusBar);
		
		endStatusBar = new JTextField();
		endStatusBar.setEnabled(false);
		endStatusBar.setEditable(false);
		endStatusBar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		endStatusBar.setBounds(712, 753, 492, 20);
		MTaskWindow.getContentPane().add(endStatusBar);
		
		//Listeners
		btnCreateTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newTask = new TaskWindow();
				newTask.setVisible(true);
				newTask.newTicket = 1;
			}
		});
		
		
		sorter = new SortPanel();
		sorter.setBounds(10,10,341,40);
		MTaskWindow.getContentPane().add(sorter);
		
		manager = new ProjectManager();
		
		// And From your main() method or any other method
		Timer timer = new Timer();
		timer.schedule(new RefreshTimer(), 0, 600000);//Refreash every minute (60 x 1000 milliseconds = 60000 or 60 seconds x 10 = 600000 or 600 Minutes)
	}
}
