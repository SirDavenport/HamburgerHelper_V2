package com.derek.hamburger_helper.condiments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ListOfCondiments {

	private List<Condiment> condimentList;
	private Condiment con;
	public ListOfCondiments() {
		con = new Condiment();
		condimentList = new ArrayList<>();
		try {
			Stream<String> lines = Files.lines(Paths.get("resource\\AvailableCondiments.txt"));
			lines.forEach((String t) -> {
				String[] parse = t.split(",");
				if(parse.length<3) return;
				con.setType(parse[0]);
				con.setCount(Integer.parseInt(parse[1]));
				con.setPrice(Double.parseDouble(parse[2]));
				condimentList.add(con);
				con = new Condiment();
			});
		} catch (IOException ex) {
			System.out.println("Unable to open student file." + ex.toString());
		}




	}
	public List<Condiment> getCondimentsList() {
		return condimentList;
	}


}



