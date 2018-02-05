package com.derek.hamburger_helper.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.derek.hamburger_helper.hamburger_type.BillsHamburger;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;

public class CheckOut extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOut frame = new CheckOut(null, 1);
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
	public CheckOut(BillsHamburger h1, int backTo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(2, 51, 158, 189);
		contentPane.add(scrollPane);
		
		DefaultListModel listModel = new DefaultListModel();
		listModel.addElement(h1.getMeat());
		listModel.addElement(h1.getBread());
		listModel.addElement(h1.getCheese());
		for(int i=0; i<h1.getToppingList().size();i++) {
			listModel.addElement(h1.getToppingList().get(i));
		}
		for(int i=0; i<h1.getCondimentsList().size();i++) {
			listModel.addElement(h1.getCondimentsList().get(i));
		}
		listModel.addElement("Final Price: $"+h1.thePrice());
		
		JList list = new JList(listModel);
		scrollPane.setRowHeaderView(list);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(backTo ==1) {
					SelectCondiments selectCondiments = new SelectCondiments(h1);
					selectCondiments.setVisible(true);
					dispose();
				}
				else if(backTo == 2) {
					SelectSpecials selectSpecials = new SelectSpecials(h1);
					for(int i=0;i<h1.getToppingList().size();i++) {
						h1.deleteAllToppings();
					}
					for(int i=0;i<h1.getCondimentsList().size();i++) {
						h1.deleteAllCondiments();
					}
					selectSpecials.setVisible(true);
					dispose();
				}
			}
		});
		btnBack.setBounds(0, 0, 97, 25);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("Bill's Burgers");
		label.setBounds(345, 237, 91, 16);
		contentPane.add(label);
		
		JButton btnAddToOrder = new JButton("Add to Order");
		btnAddToOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Eventually this will add to customer objects order");
				dispose();
			}
		});
		btnAddToOrder.setBounds(172, 215, 107, 25);
		contentPane.add(btnAddToOrder);
		
		JTextArea txtrWeHopeYou = new JTextArea();
		txtrWeHopeYou.setEditable(false);
		if(backTo == 1) {
			txtrWeHopeYou.setText("We Hope you Enjoyed\r\nBuilding your own\r\nBurger!");
		}
		else if(backTo ==2) {
			txtrWeHopeYou.setText("We Hope you Enjoy your\r\n" + h1.getType()+"!");
		}
		txtrWeHopeYou.setBounds(172, 102, 168, 58);
		contentPane.add(txtrWeHopeYou);
		
		JLabel lblThankYou = new JLabel("THANK YOU!");
		lblThankYou.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThankYou.setBounds(172, 13, 132, 25);
		contentPane.add(lblThankYou);
	}
}
