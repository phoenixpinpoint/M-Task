/*********************************************
 * M-Task Version 1.2.3
 * Build:
 * 	Major: 6272016
 *  Minor: 162801
 * 
 * Created by phoenixpinpoint
 * 
 * 
 * Class: InvalidTaskDialog
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
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InvalidTaskDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InvalidTaskDialog dialog = new InvalidTaskDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InvalidTaskDialog() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InvalidTaskDialog.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
		setResizable(false);
		setTitle("Invalid Task");
		setBounds(100, 100, 450, 106);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblInvalidTaskNumber = new JLabel("Invalid Task Number, Aborting Load");
			lblInvalidTaskNumber.setBounds(10, 22, 414, 14);
			contentPanel.add(lblInvalidTaskNumber);
		}
		{
			JButton btnOk = new JButton("Ok");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOk.setBounds(148, 47, 89, 23);
			contentPanel.add(btnOk);
		}
	}

}
