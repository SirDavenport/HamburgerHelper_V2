package com.derek.hamburger_helper.cheese;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.derek.hamburger_helper.condiments.Condiment;

public class ListOfCheese {


	private List<CheeseType> cheeseList;
	private CheeseType cheese;
	public ListOfCheese() {
		cheeseList = new ArrayList<>();
		cheese = new CheeseType();
		try {
			Stream<String> lines = Files.lines(Paths.get("resource\\AvailableCheese.txt"));
			lines.forEach((String t) -> {
				String[] parse = t.split(",");
				if(parse.length<3) return;
				cheese.setType(parse[0]);
				cheese.setCount(Integer.parseInt(parse[1]));
				cheese.setPrice(Double.parseDouble(parse[2]));
				cheeseList.add(cheese);
				cheese = new CheeseType();
			});
		} catch (IOException ex) {
			System.out.println("Unable to open student file." + ex.toString());
		}




	}
	public List<CheeseType> getCheeseList() {
		return cheeseList;
	}


}



