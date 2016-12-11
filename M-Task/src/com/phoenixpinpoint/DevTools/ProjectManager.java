package com.phoenixpinpoint.DevTools;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectManager {

	private Project[] projects;
	private SQLManager db = MTask.db;
	
	public ProjectManager()
	{
		String getProjects = "SELECT * FROM `MTaskProjects`";
		String getProjectCount = "SELECT COUNT(ProjectId) FROM `MTaskProjects`;";

		ResultSet projectQuery = null;
		int count = 0;
		try {
			projectQuery = db.stmt.executeQuery(getProjectCount);
			while(projectQuery.next())
			{
				count = projectQuery.getInt(1);
				projects = new Project[count];
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int counter = 0;
		try {
			projectQuery = db.stmt.executeQuery(getProjects );
			while(projectQuery.next())
			{
				String title = projectQuery.getString("ProjectTitle");
				String team = projectQuery.getString("ProjectTeam");
				projects[counter] = new Project(title, team); 
				counter++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public int getProjectCount()
	{
		return projects.length-1;
	}
	public String getProjectTitle(int i)
	{
		return projects[i].getTitle();
	}
	public String getProjectTeam(int i)
	{
		return projects[i].getTeam();
	}
	public void loadProject(int i)
	{
		ProjectView view = new ProjectView(projects[i]);
	}
	public Object[][] loadTasks(int i)
	{
		Object[][] taskData = null;
		String project = getProjectTitle(i);
		String getTasks = "SELECT * FROM `MTaskProjects` WHERE `TaskProject` = '"+project+"";
		String getTasksCount = "SELECT COUNT(ProjectId) FROM `MTaskTable` WHERE `TaskProject` = '"+project+"';";

		ResultSet taskQuery = null;
		int count = 0;
		try {
			taskQuery = db.stmt.executeQuery(getTasksCount);
			while(taskQuery.next())
			{
				count = taskQuery.getInt(1);
				//projects = new Project[count];
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int counter = 0;
		try {
			//taskQuery = db.stmt.executeQuery(getProjects);
			while(taskQuery.next())
			{
				String title = taskQuery.getString("ProjectTitle");
				String team = taskQuery.getString("ProjectTeam");
				projects[counter] = new Project(title, team); 
				counter++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return taskData;
	}
}
