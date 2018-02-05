package com.derek.hamburger_helper.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import com.derek.hamburger_helper.bread_type.BreadRollType;
import com.derek.hamburger_helper.condiments.Condiment;

import com.derek.hamburger_helper.condiments.ListOfCondiments;
import com.derek.hamburger_helper.hamburger_type.BillsHamburger;

import com.derek.hamburger_helper.meat.MeatType;
import com.derek.hamburger_helper.toppings.Topping;


import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class SelectCondiments extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private ListOfCondiments cList;
	private JLabel condimentCountLabel;
	private boolean doesCondimentExist;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectCondiments frame = new SelectCondiments(null);
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
	public SelectCondiments(BillsHamburger h1) {
		condimentCountLabel = new JLabel("");
		cList = new ListOfCondiments();
		condimentCountLabel.setVisible(true);
		condimentCountLabel.setText(String.valueOf(h1.getCondimentsList().size()));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectYourMeat = new JLabel("Condiments");
		lblSelectYourMeat.setBounds(118, 90, 89, 16);
		contentPane.add(lblSelectYourMeat);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(118, 108, 130, 132);
		contentPane.add(scrollPane);
		DefaultListModel condimentModel = new DefaultListModel();
		for(int i=0; i<cList.getCondimentsList().size();i++) {
			condimentModel.addElement(cList.getCondimentsList().get(i));
		}
		JList condimentList = new JList(condimentModel);
		
		scrollPane.setViewportView(condimentList);
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Condiment condom = (Condiment)condimentList.getSelectedValue();
				if(condimentList.getSelectedIndex()!=-1) {
					h1.addCondiment(condom.getType());
					condimentCountLabel.setText(String.valueOf(h1.getCondimentsList().size()));
					for(int i=0; i <cList.getCondimentsList().size();i++) {
						System.out.println("Count of " + cList.getCondimentsList().get(i).getType()+": "+cList.getCondimentsList().get(i).getCount());
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "No item selected");
				}
			}
		});
		addButton.setBounds(260, 106, 97, 25);
		contentPane.add(addButton);
		JButton completeOrderButton = new JButton("Complete");
		completeOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CheckOut checkOut = new CheckOut(h1, 1);
				System.out.println("Count of " + h1.getMeat().getType()+": "+h1.getMeat().getCount());
				System.out.println("Count of " + h1.getBread().getType()+": "+h1.getBread().getCount());
				System.out.println("Count of " + h1.getCheese().getType()+": "+h1.getCheese().getCount());

				for(int i=0; i <h1.getCondimentsList().size();i++) {
					System.out.println("Count of " + h1.getCondimentsList().get(i).getType()+": "+h1.getCondimentsList().get(i).getCount());
				}
				
				checkOut.setVisible(true);
				dispose();
			}
		});
		completeOrderButton.setBounds(260, 181, 150, 25);
		contentPane.add(completeOrderButton);
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectToppings selectTopping = new SelectToppings(h1);
				
				
				selectTopping.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(0, 0, 97, 25);
		contentPane.add(btnBack);
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Condiment condom = (Condiment)condimentList.getSelectedValue();
				if(condimentList.getSelectedIndex()!=-1) {
					doesCondimentExist = h1.deleteCondiment(condom);
					condimentCountLabel.setText(String.valueOf(h1.getCondimentsList().size()));
				
					if(!doesCondimentExist) {
						JOptionPane.showMessageDialog(null, "You cannot delete what is not there!");
					}
					else {
						JOptionPane.showMessageDialog(null, h1.getBread() + " "+h1.getMeat()+ h1.getCondimentsList());
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "You did not select a Topping to delete!");
				}
	
			}
		});
		deleteButton.setBounds(260, 144, 110, 25);
		contentPane.add(deleteButton);
		
		JTextArea txtrDidSomebodySay = new JTextArea();
		txtrDidSomebodySay.setEditable(false);
		txtrDidSomebodySay.setText("Spice up your life with\r\nThese special Condiments\r\n");
		txtrDidSomebodySay.setBounds(223, 13, 212, 45);
		contentPane.add(txtrDidSomebodySay);
		
		JLabel label = new JLabel("Bill's Burgers");
		label.setBounds(345, 237, 90, 16);
		contentPane.add(label);
		
		
		condimentCountLabel.setBounds(187, 90, 31, 16);
		contentPane.add(condimentCountLabel);
	}

}
