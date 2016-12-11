package com.phoenixpinpoint.DevTools;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddProgramLanguageDialog extends JFrame {

	private JPanel contentPane;
	private JTextField langaugeField;


	/**
	 * Create the frame.
	 */
	public AddProgramLanguageDialog(final DefaultListModel model) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddProgramLanguageDialog.class.getResource("/com/sun/java/swing/plaf/windows/icons/Question.gif")));
		setTitle("Enter Programming Lanaguage");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 102);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProgrammingLanguage = new JLabel("Programming Language:");
		lblProgrammingLanguage.setBounds(10, 11, 116, 14);
		contentPane.add(lblProgrammingLanguage);
		
		langaugeField = new JTextField();
		langaugeField.setBounds(136, 8, 288, 20);
		contentPane.add(langaugeField);
		langaugeField.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.addElement(langaugeField.getText());
			}
		});
		btnOk.setBounds(10, 36, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(109, 36, 89, 23);
		contentPane.add(btnCancel);
	}

}
