package com.derek.hamburger_helper.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import com.derek.hamburger_helper.bread_type.BreadRollType;
import com.derek.hamburger_helper.cheese.CheeseType;
import com.derek.hamburger_helper.cheese.ListOfCheese;
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

public class SelectCheese extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private ListOfCheese cList;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectCheese frame = new SelectCheese(null);
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
	public SelectCheese(BillsHamburger h1) {
		
		cList = new ListOfCheese();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectCheese = new JLabel("CHEESE:");
		lblSelectCheese.setBounds(118, 90, 66, 16);
		contentPane.add(lblSelectCheese);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(118, 108, 130, 132);
		contentPane.add(scrollPane);
		DefaultListModel cheeseModel = new DefaultListModel();
		for(int i=0; i<cList.getCheeseList().size();i++) {
			cheeseModel.addElement(cList.getCheeseList().get(i));
		}
		JList cheeseList = new JList(cheeseModel);
		scrollPane.setViewportView(cheeseList);
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheeseType cheese = (CheeseType)cheeseList.getSelectedValue();
				if(cheeseList.getSelectedIndex()!=-1) {
					h1.chooseCheese(cheese.getType());
					JOptionPane.showMessageDialog(null, h1.getCheeseInfo());
					SelectToppings st = new SelectToppings(h1);
					for(int i=0; i <cList.getCheeseList().size();i++) {
						System.out.println("Count of " + cList.getCheeseList().get(i).getType()+": "+cList.getCheeseList().get(i).getCount());
					}
					st.setVisible(true);
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
				SelectBread selectBread = new SelectBread(h1);
				selectBread.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(0, 0, 97, 25);
		contentPane.add(btnBack);
		
		JTextArea txtrIsThereAnything = new JTextArea();
		txtrIsThereAnything.setText("Is there anything better\r\nthan Cheese?");
		txtrIsThereAnything.setEditable(false);
		txtrIsThereAnything.setBounds(240, 13, 196, 45);
		contentPane.add(txtrIsThereAnything);
		
		JLabel label = new JLabel("Bill's Burgers");
		label.setBounds(345, 237, 91, 16);
		contentPane.add(label);
	}

}
