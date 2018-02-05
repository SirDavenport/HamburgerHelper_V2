package com.derek.hamburger_helper.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.derek.hamburger_helper.hamburger_type.BillsHamburger;
import com.derek.hamburger_helper.meat.ListOfMeats;
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

public class SelectMeat extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private ListOfMeats mList;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectMeat frame = new SelectMeat(null);
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
	public SelectMeat(BillsHamburger h1) {
		mList = new ListOfMeats();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectYourMeat = new JLabel("MEATS:");
		lblSelectYourMeat.setBounds(118, 90, 66, 16);
		contentPane.add(lblSelectYourMeat);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(118, 108, 130, 132);
		contentPane.add(scrollPane);
		DefaultListModel meatModel = new DefaultListModel();
		for(int i=0; i<mList.getMeatList().size();i++) {
			meatModel.addElement(mList.getMeatList().get(i));
		}
		JList meatList = new JList(meatModel);
		scrollPane.setViewportView(meatList);
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MeatType meat = (MeatType)meatList.getSelectedValue();
				if(meatList.getSelectedIndex()!=-1) {
					h1.chooseMeat(meat.getType());
					JOptionPane.showMessageDialog(null, h1.getMeat());
					SelectBread sb = new SelectBread(h1);
					for(int i=0; i <mList.getMeatList().size();i++) {
						System.out.println("Count of " + mList.getMeatList().get(i).getType()+": "+mList.getMeatList().get(i).getCount());
					}
					sb.setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "No item selected");
				}
			}
		});
		addButton.setBounds(257, 154, 97, 25);
		contentPane.add(addButton);
		
		JLabel lblBillsBurgers = new JLabel("Bill's Burgers");
		lblBillsBurgers.setBounds(345, 237, 87, 16);
		contentPane.add(lblBillsBurgers);
		
		JTextArea txtrChooseYourFavorite = new JTextArea();
		txtrChooseYourFavorite.setEditable(false);
		txtrChooseYourFavorite.setText("Choose your favorite meat, \r\nor maybe try something new!");
		txtrChooseYourFavorite.setBounds(220, 13, 217, 45);
		contentPane.add(txtrChooseYourFavorite);
		
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
		
	}

}
