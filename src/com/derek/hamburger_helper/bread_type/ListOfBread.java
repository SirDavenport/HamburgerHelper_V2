package com.derek.hamburger_helper.bread_type;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ListOfBread {

	private List<BreadRollType> breadList;
	private BreadRollType bread;
	public ListOfBread() {
		breadList = new ArrayList<>();
		bread = new BreadRollType();
		try {
			Stream<String> lines = Files.lines(Paths.get("resource\\AvailableBread.txt"));
			lines.forEach((String t) -> {
				String[] parse = t.split(",");
				if(parse.length<3) return;
				bread.setType(parse[0]);
				bread.setCount(Integer.parseInt(parse[1]));
				bread.setPrice(Double.parseDouble(parse[2]));
				breadList.add(bread);
				bread = new BreadRollType();
			});
		} catch (IOException ex) {
			System.out.println("Unable to open student file." + ex.toString());
		}




	}
	public List<BreadRollType> getBreadList() {
		return breadList;
	}

}
