package com.derek.hamburger_helper.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import com.derek.hamburger_helper.bread_type.BreadRollType;
import com.derek.hamburger_helper.bread_type.ListOfBread;
import com.derek.hamburger_helper.hamburger_type.BillsHamburger;
import com.derek.hamburger_helper.meat.MeatType;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class SelectBread extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private ListOfBread bList;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectBread frame = new SelectBread(null);
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
	public SelectBread(BillsHamburger h1) {
		
		bList = new ListOfBread();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectYourMeat = new JLabel("BREADS:");
		lblSelectYourMeat.setBounds(118, 90, 66, 16);
		contentPane.add(lblSelectYourMeat);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(118, 108, 130, 132);
		contentPane.add(scrollPane);
		DefaultListModel breadModel = new DefaultListModel();
		for(int i=0; i<bList.getBreadList().size();i++) {
			breadModel.addElement(bList.getBreadList().get(i));
		}
		JList breadList = new JList(breadModel);
		scrollPane.setViewportView(breadList);
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BreadRollType bread = (BreadRollType)breadList.getSelectedValue();
				if(breadList.getSelectedIndex()!=-1) {
					h1.chooseBread(bread.getType());
					JOptionPane.showMessageDialog(null, h1.getBread() + " "+h1.getMeat());
					SelectCheese selectCheese = new SelectCheese(h1);
					for(int i=0; i <bList.getBreadList().size();i++) {
						System.out.println("Count of " + bList.getBreadList().get(i).getType()+": "+bList.getBreadList().get(i).getCount());
					}
					selectCheese.setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "No item selected");
				}
			}
		});
		addButton.setBounds(257, 154, 97, 25);
		contentPane.add(addButton);
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectMeat selectMeat = new SelectMeat(h1);
				selectMeat.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(0, 0, 97, 25);
		contentPane.add(btnBack);
		
		JTextArea txtrOurWideVariety = new JTextArea();
		txtrOurWideVariety.setEditable(false);
		txtrOurWideVariety.setText("Our variety of tasty Breads\r\nmake for a great Burger!");
		txtrOurWideVariety.setBounds(214, 13, 222, 45);
		contentPane.add(txtrOurWideVariety);
		
		JLabel label = new JLabel("Bill's Burgers");
		label.setBounds(345, 237, 91, 16);
		contentPane.add(label);
	}

}
