package com.derek.hamburger_helper.gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.derek.hamburger_helper.hamburger_type.BillsHamburger;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Welcome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private BillsHamburger h1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Welcome() {
		h1 = new BillsHamburger();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To Bill's Burgers");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(183, 58, 336, 29);
		contentPane.add(lblNewLabel);
		
		JTextArea txtrFeelFreeTo = new JTextArea();
		txtrFeelFreeTo.setEditable(false);
		txtrFeelFreeTo.setText("Feel Free to create your own\r\nburger or try one of \r\nBill's signature Burgers!");
		txtrFeelFreeTo.setBounds(265, 113, 240, 66);
		contentPane.add(txtrFeelFreeTo);
		
		JButton btnCreateYourOwn = new JButton("Create Your Own Burger");
		btnCreateYourOwn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectMeat selectMeat = new SelectMeat(h1);
				selectMeat.setVisible(true);
				dispose();
			}
		});
		btnCreateYourOwn.setBounds(130, 203, 200, 54);
		contentPane.add(btnCreateYourOwn);
		
		JButton menuButton = new JButton("Bill's Special Burgers");
		menuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectSpecials selectSpecial = new SelectSpecials(h1);
				selectSpecial.setVisible(true);
				dispose();
			}
		});
		menuButton.setBounds(346, 203, 200, 54);
		contentPane.add(menuButton);
		
		JLabel label = new JLabel("Bill's Burgers");
		label.setBounds(596, 314, 87, 16);
		contentPane.add(label);
	}
}
