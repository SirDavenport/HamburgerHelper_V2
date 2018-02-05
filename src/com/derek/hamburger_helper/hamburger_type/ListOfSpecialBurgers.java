package com.derek.hamburger_helper.hamburger_type;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

import com.derek.hamburger_helper.meat.ListOfMeats;
import com.derek.hamburger_helper.meat.MeatType;

public class ListOfSpecialBurgers {
	


	

		private List<BillsHamburger> specialList;
		private BillsHamburger bh;
		
		//The type =[0], meat = [1], cheese = [2], roll = [3], toppings = [4], condiments = [5], price = [6], description = [7]
		public ListOfSpecialBurgers() {
			bh = new BillsHamburger();
	
			specialList = new ArrayList<>();
			
			try {
				Stream<String> lines = Files.lines(Paths.get("resource\\AvailableBurgers.txt"));
				lines.forEach((String t) -> {
					String[] parse = t.split(",");
					if(parse.length<3) return;
					//JOptionPane.showMessageDialog(null, parse);
					bh.setType(parse[0]);
					bh.chooseMeat(parse[1]);
					bh.chooseCheese(parse[2]);
					bh.chooseBread(parse[3]);
					bh.setDescription(parse[7]);
					bh.thePrice();
					String[] parseTop = parse[4].split(":");
					
			
						for(int i=0;i<parseTop.length;i++) {
							bh.addTopping(parseTop[i]);
						}
					
					String[] parseCon = parse[5].split(":");
					
						
						for(int i=0;i<parseCon.length;i++) {
							bh.addCondiment(parseCon[i]);
						}
					
					specialList.add(bh);
					bh = new BillsHamburger();
				});
			} catch (IOException ex) {
				System.out.println("Unable to open student file." + ex.toString());
			}




		}
		public List<BillsHamburger> getSpecialBurger() {
			return specialList;
		}

	}