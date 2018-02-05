package com.derek.hamburger_helper.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;

import com.derek.hamburger_helper.hamburger_type.BillsHamburger;
import com.derek.hamburger_helper.hamburger_type.ListOfSpecialBurgers;

import javax.swing.event.ListSelectionEvent;

public class SelectSpecials extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private ListOfSpecialBurgers bList;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectSpecials frame = new SelectSpecials(null);
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
	
	public SelectSpecials(BillsHamburger h) {
		bList = new ListOfSpecialBurgers();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 56, 214, 225);
		contentPane.add(scrollPane);
		
		DefaultListModel listModel = new DefaultListModel();
		for(int i=0; i<bList.getSpecialBurger().size();i++) {
			listModel.addElement(bList.getSpecialBurger().get(i));
		}
		JList burgerList = new JList(listModel);
		DefaultListModel listModel2 = new DefaultListModel();
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(376, 56, 250, 225);
		contentPane.add(scrollPane_1);
		
		JList descList = new JList();
		
		burgerList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				JList descList = new JList();
				
				BillsHamburger ham = new BillsHamburger();
				ham = (BillsHamburger) burgerList.getSelectedValue();
				listModel2.removeAllElements();
				if(burgerList.getSelectedIndex()!=-1) {
					listModel2.addElement("Name: "+ham.getType());
					listModel2.addElement("Meat: "+ham.getMeat());
					listModel2.addElement("Bread: "+ham.getBread());
					listModel2.addElement("Cheese: "+ham.getCheese());
					for(int i=0; i<ham.getToppingList().size();i++) {
						listModel2.addElement(ham.getToppingList().get(i).getType());
						
					}
					for(int i=0; i<ham.getCondimentsList().size();i++) {
						listModel2.addElement(ham.getCondimentsList().get(i).getType());
					}
					listModel2.addElement(ham.getDescription());
					descList.setModel(listModel2);
					descList.setBounds(377, 56, 250, 225);
					scrollPane_1.setViewportView(descList);
				
				}
			}
		});
		scrollPane.setViewportView(burgerList);
		JLabel lblSpecialBurgers = new JLabel("Special Burgers");
		lblSpecialBurgers.setBounds(41, 37, 102, 16);
		contentPane.add(lblSpecialBurgers);
		
		JButton btnNewButton = new JButton("Choose");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BillsHamburger ham = (BillsHamburger)burgerList.getSelectedValue();
				if(burgerList.getSelectedIndex()!=-1) {
					h.chooseBread(ham.getBread().getType());
					h.chooseMeat(ham.getMeat().getType());
					h.chooseCheese(ham.getCheese().getType());
					h.setType(ham.getType());
					for(int i=0;i<ham.getToppingList().size();i++) {
						h.addTopping(ham.getToppingList().get(i).getType());
						
					}
					for(int i=0;i<ham.getCondimentsList().size();i++) {
						h.addCondiment(ham.getCondimentsList().get(i).getType());
					}
					h.setDescription(ham.getDescription());
					CheckOut checkout = new CheckOut(h, 2);
					checkout.setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null,"Please select a burger.");
				}
				
			}
		});
		btnNewButton.setBounds(267, 136, 97, 25);
		contentPane.add(btnNewButton);
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome win = new Welcome();
				win.setVisible(true);
				dispose();
				
			}
		});
		button.setBounds(0, 0, 97, 25);
		contentPane.add(button);
		JLabel lblBillsBurgers = new JLabel("Bill's Burgers");
		lblBillsBurgers.setBounds(635, 278, 87, 16);
		contentPane.add(lblBillsBurgers);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(376, 37, 87, 16);
		contentPane.add(lblDescription);
		
		
		
		
	}
}
