/*********************************************
 * M-Task Version 1.2.3
 * Build:
 * 	Major: 6272016
 *  Minor: 162801
 * 
 * 
 * 
 * Class: LoginDialog
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
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDialog extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginDialog dialog = new LoginDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loginUser()
	{
		String username = usernameField.getText();
		String password = passwordField.getText();
		String dbPassword = "Null";
		
		password = translate.crypt(password);
		
		String loginSQL = "SELECT daname, dapass, daboss, realname, cuid FROM `daminions-CPE` WHERE daname = '"+username+"' OR cuid = '"+username+"';";
		ResultSet loginQuery= null;
		
		try {
			loginQuery = MTask.db.stmt.executeQuery(loginSQL);
			while(loginQuery.next())
			{
				 dbPassword = loginQuery.getString("dapass");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(password.equals(dbPassword))
		{
			MTask.loggedIn = 1;
			MTask.MTaskWindow.setEnabled(true);
			MTask.MTaskWindow.setVisible(true);
			MTask.usernameStatusBar.setText("Logged In: " + username);
			MTask.user = username;
			dispose();
		}
	}
	/**
	 * Create the dialog.
	 */
	public LoginDialog() {
		setUndecorated(true);
		setResizable(false);
		setBounds(100, 100, 311, 199);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(61, 79, 57, 14);
		contentPanel.add(lblUsername);
		
		usernameField = new JTextField();
		usernameField.setBounds(128, 73, 86, 20);
		contentPanel.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblPassowrd = new JLabel("Passowrd:");
		lblPassowrd.setBounds(61, 104, 57, 14);
		contentPanel.add(lblPassowrd);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(128, 101, 86, 20);
		contentPanel.add(passwordField);
		
		JLabel lblMtaskVersion = new JLabel("M-Task Version 1.2.3");
		lblMtaskVersion.setBounds(117, 32, 146, 14);
		contentPanel.add(lblMtaskVersion);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton loginButton = new JButton("Login");
				loginButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						loginUser();
					}
				});
				loginButton.setActionCommand("OK");
				buttonPane.add(loginButton);
				getRootPane().setDefaultButton(loginButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
