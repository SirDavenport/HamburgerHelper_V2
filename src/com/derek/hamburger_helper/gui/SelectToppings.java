package com.derek.hamburger_helper.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.derek.hamburger_helper.bread_type.BreadRollType;
import com.derek.hamburger_helper.hamburger_type.BillsHamburger;
import com.derek.hamburger_helper.meat.MeatType;
import com.derek.hamburger_helper.toppings.ListOfToppings;
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

public class SelectToppings extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private ListOfToppings tList;
	private JLabel toppingsCountLabel;
	private boolean doesToppingExist;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectToppings frame = new SelectToppings(null);
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
	public SelectToppings(BillsHamburger h1) {
		toppingsCountLabel = new JLabel("");
		tList = new ListOfToppings();
		toppingsCountLabel.setVisible(true);
		toppingsCountLabel.setText(String.valueOf(h1.getToppingList().size()));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectYourMeat = new JLabel("TOPPINGS");
		lblSelectYourMeat.setBounds(118, 90, 66, 16);
		contentPane.add(lblSelectYourMeat);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(118, 108, 130, 132);
		contentPane.add(scrollPane);
		DefaultListModel toppingsModel = new DefaultListModel();
		for(int i=0; i<tList.getToppingsList().size();i++) {
			toppingsModel.addElement(tList.getToppingsList().get(i));
		}
		JList toppingsList = new JList(toppingsModel);
		
		scrollPane.setViewportView(toppingsList);
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Topping top = (Topping)toppingsList.getSelectedValue();
				if(toppingsList.getSelectedIndex()!=-1) {
					h1.addTopping(top.getType());
					toppingsCountLabel.setText(String.valueOf(h1.getToppingList().size()));
					for(int i=0; i <tList.getToppingsList().size();i++) {
						System.out.println("Count of " + tList.getToppingsList().get(i).getType()+": "+tList.getToppingsList().get(i).getCount());
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
				
				SelectCondiments selectCondiments = new SelectCondiments(h1);
				System.out.println("Count of " + h1.getMeat().getType()+": "+h1.getMeat().getCount());
				System.out.println("Count of " + h1.getBread().getType()+": "+h1.getBread().getCount());
				System.out.println("Count of " + h1.getCheese().getType()+": "+h1.getCheese().getCount());

				for(int i=0; i <h1.getToppingList().size();i++) {
					System.out.println("Count of " + h1.getToppingList().get(i).getType()+": "+h1.getToppingList().get(i).getCount());
				}
				
				selectCondiments.setVisible(true);
				dispose();
			}
		});
		completeOrderButton.setBounds(260, 181, 150, 25);
		contentPane.add(completeOrderButton);
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectCheese selectCheese = new SelectCheese(h1);
				
				
				selectCheese.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(0, 0, 97, 25);
		contentPane.add(btnBack);
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Topping top = (Topping)toppingsList.getSelectedValue();
				if(toppingsList.getSelectedIndex()!=-1) {
					doesToppingExist = h1.deleteTopping(top);
					toppingsCountLabel.setText(String.valueOf(h1.getToppingList().size()));
				
					if(!doesToppingExist) {
						JOptionPane.showMessageDialog(null, "You cannot delete what is not there!");
					}
					else {
						JOptionPane.showMessageDialog(null, h1.getBread() + " "+h1.getMeat()+ h1.getToppingList());
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
		txtrDidSomebodySay.setText("Toppings bring a whole new\r\nLevel of flavor.");
		txtrDidSomebodySay.setEditable(false);
		txtrDidSomebodySay.setBounds(223, 13, 212, 45);
		contentPane.add(txtrDidSomebodySay);
		
		JLabel label = new JLabel("Bill's Burgers");
		label.setBounds(345, 237, 90, 16);
		contentPane.add(label);
		
		
		toppingsCountLabel.setBounds(183, 90, 56, 16);
		contentPane.add(toppingsCountLabel);
	}

}
