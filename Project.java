package com.phoenixpinpoint.DevTools;

public class Project {
	
	private String title;
	private String team;
	
	public Project(String projectTitle, String projectTeam)
	{
		title = projectTitle;
		team = projectTeam;
	}
	public String getTitle()
	{
		return title;
	}
	public String getTeam()
	{
		return team;
	}
}
