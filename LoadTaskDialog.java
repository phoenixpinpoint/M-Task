/*********************************************
 * M-Task Version 1.2.3
 * Build:
 * 	Major: 6272016
 *  Minor: 162801
 * 
 * Created by Adam Guthrie
 * 
 * 
 * Class: LoadTaskDialog
 * Version: 62720161628
 * 
 * 
 * Support: 
 * *********************************************/
package com.phoenixpinpoint.DevTools;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoadTaskDialog extends JFrame {//Changed to JFrame from JDialog so it will show up as child window on Start menu

	private final JPanel contentPanel = new JPanel();
	private JTextField idField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoadTaskDialog dialog = new LoadTaskDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoadTaskDialog() {
		setResizable(false);
		setTitle("Load Task");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoadTaskDialog.class.getResource("/com/sun/java/swing/plaf/windows/icons/Directory.gif")));
		setBounds(100, 100, 450, 120);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblTaskId = new JLabel("Task Id: ");
			lblTaskId.setBounds(10, 11, 46, 14);
			contentPanel.add(lblTaskId);
		}
		{
			idField = new JTextField();
			idField.setBounds(66, 8, 358, 20);
			contentPanel.add(idField);
			idField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton loadButton = new JButton("Load");
				loadButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TaskWindow task = new TaskWindow();
						task.loadTask(idField.getText());
						if(task.lblId.getText().equals("0"))
						{
							InvalidTaskDialog invalidError = new InvalidTaskDialog();
							invalidError.setVisible(true);
						}
						else
						{
							task.setVisible(true);
						}
						dispose();
					}
				});
				loadButton.setActionCommand("OK");
				buttonPane.add(loadButton);
				getRootPane().setDefaultButton(loadButton);
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
	}

}
