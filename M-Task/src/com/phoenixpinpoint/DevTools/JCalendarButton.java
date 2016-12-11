/*********************************************
 * M-Task Version 1.2.3
 * Build:
 * 	Major: 6272016
 *  Minor: 162801
 * 
 * Created by phoenixpinpoint
 * 
 * 
 * Class: JCalendarButton
 * Version: 62720161628
 * 
 * 
 * Support: 
 * *********************************************/
package com.phoenixpinpoint.DevTools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JCalendarButton extends JButton {

	/**
	 * Create the panel.
	 */
	public JCalendarButton(final JTextField field) {
		setIcon(new ImageIcon(MTask.class.getResource("/com/CenturyLink/Qwest/DataCPE/DevTools/calendar.gif")));
		
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JCalendar etaCalendar = new JCalendar(MTask.MTaskWindow, MTask.newTask.dueDateField);
			}
		});
	}
	public void setBounds(JTextField field)
	{
		int x,y,width,height;
		x = field.getBounds().x + 100;
		y = field.getBounds().y;
		width = 20;
		height = 15;
		
		setBounds(x,y,width,height);
	}
}
