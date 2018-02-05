package com.derek.hamburger_helper.toppings;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class ListOfToppings{
	
	private List<Topping> toppingsList;
	private Topping top;
	public ListOfToppings() {
		top = new Topping();
		toppingsList = new ArrayList<>();
		try {
		       Stream<String> lines = Files.lines(Paths.get("resource\\AvailableToppings.txt"));
		       lines.forEach((String t) -> {
		          String[] parse = t.split(",");
		          if(parse.length<3) return;
		          top.setType(parse[0]);
		          top.setCount(Integer.parseInt(parse[1]));
		          top.setPrice(Double.parseDouble(parse[2]));
		          toppingsList.add(top);
		          top = new Topping();
		       });
		    } catch (IOException ex) {
		       System.out.println("Unable to open student file." + ex.toString());
		    }
		
		
		
		
	}
	public List<Topping> getToppingsList() {
		return toppingsList;
	}
	

}
