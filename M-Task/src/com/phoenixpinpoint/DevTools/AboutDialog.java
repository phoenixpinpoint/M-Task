/*********************************************
 * M-Task Version 1.2.3
 * Build:
 * 	Major: 6272016
 *  Minor: 162801
 * 
 * Created by Adam Guthrie
 * 
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
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class AboutDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AboutDialog dialog = new AboutDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AboutDialog() {
		setResizable(false);
		setTitle("About");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AboutDialog.class.getResource("/com/sun/java/swing/plaf/windows/icons/Inform.gif")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblMtaskTaskManagement = new JLabel("MTask Task Management Tool Version 1.2.3");
			lblMtaskTaskManagement.setBounds(10, 11, 424, 58);
			contentPanel.add(lblMtaskTaskManagement);
		}
		{
			JLabel lblCreatedByAdam = new JLabel("Created By: phoenixpinpoint");
			lblCreatedByAdam.setBounds(10, 110, 424, 14);
			contentPanel.add(lblCreatedByAdam);
		}
		{
			JLabel lblOrganizationCustomerAssurance = new JLabel("Organization: ");
			lblOrganizationCustomerAssurance.setBounds(10, 135, 424, 14);
			contentPanel.add(lblOrganizationCustomerAssurance);
		}
		{
			JLabel lblSupport= new JLabel("Support: ");
			lblSupport.setBounds(10, 160, 424, 14);
			contentPanel.add(lblSupport);
		}
		{
			JLabel lblVersionMajorMinor = new JLabel("Version:1.2.3 Major: 08012016 Minor: 154101");
			lblVersionMajorMinor.setBounds(10, 214, 424, 14);
			contentPanel.add(lblVersionMajorMinor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
