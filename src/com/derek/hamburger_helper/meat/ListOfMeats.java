package com.derek.hamburger_helper.meat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.derek.hamburger_helper.toppings.Topping;

public class ListOfMeats {

	private List<MeatType> meatList;
	private MeatType meat;
	public ListOfMeats() {
		meatList = new ArrayList<>();
		meat = new MeatType();
		try {
			Stream<String> lines = Files.lines(Paths.get("resource\\AvailableMeat.txt"));
			lines.forEach((String t) -> {
				String[] parse = t.split(",");
				if(parse.length<3) return;
				meat.setType(parse[0]);
				meat.setCount(Integer.parseInt(parse[1]));
				meat.setPrice(Double.parseDouble(parse[2]));
				meatList.add(meat);
				meat = new MeatType();
			});
		} catch (IOException ex) {
			System.out.println("Unable to open student file." + ex.toString());
		}




	}
	public List<MeatType> getMeatList() {
		return meatList;
	}
	

}
