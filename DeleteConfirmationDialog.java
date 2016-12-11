/*********************************************
 * M-Task Version 1.2.3
 * Build:
 * 	Major: 6272016
 *  Minor: 162801
 * 
 * Created by phoenixpinpoint
 * 
 *
 * 
 * Class: DeleteConfirmationDialog
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
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Toolkit;
import java.sql.SQLException;

public class DeleteConfirmationDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DeleteConfirmationDialog dialog = new DeleteConfirmationDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DeleteConfirmationDialog() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteConfirmationDialog.class.getResource("/com/sun/java/swing/plaf/windows/icons/Warn.gif")));
		setTitle("Delete?");
		setBounds(100, 100, 450, 134);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAreYouSure = new JLabel("Are you sure you want to delete this task?");
			lblAreYouSure.setBounds(10, 25, 414, 14);
			contentPanel.add(lblAreYouSure);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton yesButton = new JButton("Yes");
				yesButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String removeSQL = "DELETE FROM `MTaskTable` WHERE `MTaskTable`.`TaskId` = " + MTask.selectedData + ";";
						try {
							MTask.db.stmt.executeUpdate(removeSQL);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						dispose();
					}
				});
				yesButton.setActionCommand("OK");
				buttonPane.add(yesButton);
				getRootPane().setDefaultButton(yesButton);
			}
			{
				JButton noButton = new JButton("No");
				noButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				noButton.setActionCommand("Cancel");
				buttonPane.add(noButton);
			}
		}
	}

}
