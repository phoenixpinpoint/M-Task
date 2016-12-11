/*********************************************
 * M-Task Version 1.2.3
 * Build:
 * 	Major: 6272016
 *  Minor: 162801
 * 
 * Created by phoenixpinpoint
 * 

 * 
 * Class: JCalendar
 * Version: 62720161628
 * 
 * 
 * Support: 
 * *********************************************/
package com.phoenixpinpoint.DevTools;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
 
public class JCalendar extends JDialog {
    int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
    int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);;
    JLabel l = new JLabel("", JLabel.CENTER);
    String day = "";
    JDialog d;
    JButton[] button = new JButton[49];
    
    JLabel lblHour = new JLabel("Hour: ");
    JLabel lblMinute = new JLabel("Minute: ");
    JLabel lblTimeZone = new JLabel("Time Zone: ");
    
    JComboBox hourBox = new JComboBox();
    JComboBox minuteBox = new JComboBox();
    JComboBox timeZoneBox = new JComboBox();
 
    /**
     * Create a calendar to select a date.
     * 
     */
    public static Icon getResource(String imageIcon)
	{
		ImageIcon icon = new ImageIcon(imageIcon);
		return icon;
	}
    public JCalendar(JFrame parent, final JTextField field) {
    	for(int i = 0; i <= 23; i++)
    	{
    		String formatted = String.format("%02d", i);
    		hourBox.addItem(formatted);
    	}
    	for(int i = 0; i <= 59; i++)
    	{
    		String formatted = String.format("%02d", i);
    		minuteBox.addItem(formatted);
    	}
    	timeZoneBox.addItem("CST");
    	timeZoneBox.addItem("CDT");
    	timeZoneBox.addItem("EST");
    	timeZoneBox.addItem("EDT");
    	timeZoneBox.addItem("MST");
    	timeZoneBox.addItem("MDT");
    	timeZoneBox.addItem("PST");
    	timeZoneBox.addItem("PDT");
    
    	d = new JDialog();
        d.setModal(true);
        
        d.setIconImage(Toolkit.getDefaultToolkit().getImage("/com/phoenixpinpoint/calendar.gif"));
        
        String[] header = { "Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat" };
        JPanel time = new JPanel(new GridLayout(1, 4));
        time.setPreferredSize(new Dimension(120,30));
        time.add(lblHour);
        time.add(hourBox);
        time.add(lblMinute);
        time.add(minuteBox);
        time.add(lblTimeZone);
        time.add(timeZoneBox);
        JPanel p1 = new JPanel(new GridLayout(7, 7));
        p1.setPreferredSize(new Dimension(430, 120));
 
        for (int x = 0; x < button.length; x++) {
            final int selection = x;
            button[x] = new JButton();
            button[x].setFocusPainted(false);
            button[x].setBackground(Color.white);
            if (x > 6) {
                button[x].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        day = button[selection].getActionCommand();
                        System.out.println(button[selection].getActionCommand());
                        int modMonth = month + 1;
                        System.out.println("Cal: " + modMonth + " "+  button[selection].getActionCommand() + " " + year + " "+ hourBox.getSelectedItem().toString() + ":" + minuteBox.getSelectedItem().toString() + " "+ timeZoneBox.getSelectedItem().toString());
                        field.setText(year + "-" + modMonth + "-" + button[selection].getActionCommand().toString() +" "+hourBox.getSelectedItem().toString()+":"+ minuteBox.getSelectedItem().toString()+" "+ timeZoneBox.getSelectedItem().toString()); 
                        d.dispose();
                    }
                });
 
            }
            if (x < 7) {
                button[x].setText(header[x]);
                button[x].setForeground(Color.red);
            }
            p1.add(button[x]);
 
        }
 
        JPanel p2 = new JPanel(new GridLayout(1, 3));
        JButton previous = new JButton("<< Previous");
        previous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                month--;
                displayDate();
            }
        });
        p2.add(previous);
        p2.add(l);
        JButton next = new JButton("Next >>");
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                month++;
                displayDate();
            }
        });
        p2.add(next);
        d.add(time, BorderLayout.NORTH);
        d.add(p1, BorderLayout.CENTER);
        d.add(p2, BorderLayout.SOUTH);
        d.pack();
        d.setLocationRelativeTo(parent);
        displayDate();
        d.setVisible(true);
    }
 
    public JCalendar(final JTextField field) {
    	for(int i = 0; i <= 23; i++)
    	{
    		String formatted = String.format("%02d", i);
    		hourBox.addItem(formatted);
    	}
    	for(int i = 0; i <= 59; i++)
    	{
    		String formatted = String.format("%02d", i);
    		minuteBox.addItem(formatted);
    	}
    	timeZoneBox.addItem("CST");
    	timeZoneBox.addItem("CDT");
    	timeZoneBox.addItem("EST");
    	timeZoneBox.addItem("EDT");
    	timeZoneBox.addItem("MST");
    	timeZoneBox.addItem("MDT");
    	timeZoneBox.addItem("PST");
    	timeZoneBox.addItem("PDT");
    	
    	d = new JDialog();
        d.setModal(true);
        
        d.setIconImage(Toolkit.getDefaultToolkit().getImage("/com/phoenixpinpoint/calendar.gif"));
        
        String[] header = { "Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat" };
        JPanel time = new JPanel(new GridLayout(1, 4));
        time.setPreferredSize(new Dimension(120,30));
        time.add(lblHour);
        time.add(hourBox);
        time.add(lblMinute);
        time.add(minuteBox);
        time.add(lblTimeZone);
        time.add(timeZoneBox);
        JPanel p1 = new JPanel(new GridLayout(7, 7));
        p1.setPreferredSize(new Dimension(430, 120));
 
        for (int x = 0; x < button.length; x++) {
            final int selection = x;
            button[x] = new JButton();
            button[x].setFocusPainted(false);
            button[x].setBackground(Color.white);
            if (x > 6) {
                button[x].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        day = button[selection].getActionCommand();
                        System.out.println(button[selection].getActionCommand());
                        int modMonth = month + 1;
                        System.out.println("Cal: " + modMonth + " "+  button[selection].getActionCommand() + " " + year + " "+ hourBox.getSelectedItem().toString() + ":" + minuteBox.getSelectedItem().toString() + " "+ timeZoneBox.getSelectedItem().toString());
                        field.setText(year + "-" + modMonth + "-" + button[selection].getActionCommand().toString() +" "+hourBox.getSelectedItem().toString()+":"+ minuteBox.getSelectedItem().toString()+" "+ timeZoneBox.getSelectedItem().toString()); 
                        d.dispose();
                    }
                });
 
            }
            if (x < 7) {
                button[x].setText(header[x]);
                button[x].setForeground(Color.red);
            }
            p1.add(button[x]);
 
        }
 
        JPanel p2 = new JPanel(new GridLayout(1, 3));
        JButton previous = new JButton("<< Previous");
        previous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                month--;
                displayDate();
            }
        });
        p2.add(previous);
        p2.add(l);
        JButton next = new JButton("Next >>");
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                month++;
                displayDate();
            }
        });
        p2.add(next);
        d.add(time, BorderLayout.NORTH);
        d.add(p1, BorderLayout.CENTER);
        d.add(p2, BorderLayout.SOUTH);
        d.pack();
        d.setLocationRelativeTo(getParent());
        displayDate();
        d.setVisible(true);
	}
	/**
     * Display the dates
     * 
     * @return void
     */
    public void displayDate() {
        for (int x = 7; x < button.length; x++)
            button[x].setText("");
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                "MMMM yyyy");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month, 1);
        int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
        int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
        for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++) {
            button[x].setText("" + day);
            l.setText(sdf.format(cal.getTime()));
            d.setTitle("Date Time Selection");
            for (int y = 7; y < button.length; y++)
            {
                String str = button[x].getText();
                int m = Integer.parseInt(str);
                SimpleDateFormat fm = new SimpleDateFormat("MMMM yyyy");
                String dfm = fm.format(new Date());
                SimpleDateFormat format = new SimpleDateFormat("dd");
                String date = format.format(new Date());
 
                int n = Integer.parseInt(date);
                if ((m < n) && (dfm.equals(l.getText())))
                    button[x].setEnabled(true);
 
            }
        }
    }
 
    /**
     * Set the selected date to the Task Time area.
     * 
     * @return a String of date and time
     */
 
    public String setPickedDate() {
        if (day.equals(""))
            return day;
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                "  dd/MM/yyyy   hh:mm:ss");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month, Integer.parseInt(day));
        return sdf.format(cal.getTime());
    }
}
