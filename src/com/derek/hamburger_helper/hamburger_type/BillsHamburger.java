package com.derek.hamburger_helper.hamburger_type;

import java.util.ArrayList;
import java.util.List;

import com.derek.hamburger_helper.bread_type.BreadRollType;
import com.derek.hamburger_helper.bread_type.ListOfBread;
import com.derek.hamburger_helper.cheese.CheeseType;
import com.derek.hamburger_helper.cheese.ListOfCheese;
import com.derek.hamburger_helper.condiments.Condiment;
import com.derek.hamburger_helper.condiments.ListOfCondiments;
import com.derek.hamburger_helper.meat.ListOfMeats;
import com.derek.hamburger_helper.meat.MeatType;
import com.derek.hamburger_helper.toppings.ListOfToppings;
import com.derek.hamburger_helper.toppings.Topping;

public class BillsHamburger {
	
	private BreadRollType bread;
	private MeatType meat; 
	private List<Topping> toppingList;
	private double price;
	private CheeseType cheese;
	private String type;
	private String description;
	private List<Condiment> condimentList;
	private ListOfMeats lom;
	private ListOfCheese loc;
	private ListOfBread lob;
	private ListOfToppings lot;
	private ListOfCondiments locon;
	private Topping topping;
	private Condiment condiment;
	
	
	public BillsHamburger() {
		super();
		this.condiment = new Condiment();
		this.topping = new Topping();
		this.lom = new ListOfMeats();
		this.loc = new ListOfCheese();
		this.lob = new ListOfBread();
		this.lot = new ListOfToppings();
		this.locon = new ListOfCondiments();
		this.cheese = new CheeseType();
		this.toppingList = new ArrayList<>();
		this.bread = new BreadRollType();
		this.meat = new MeatType();
		this.type = "Hamburger";
		this.description = "A basic hamburger, but still delicious!";
		this.price = 8.00;
		this.condimentList = new ArrayList<>();
	}
	
	public void addTopping(String top) {
		for(int i=0;i<lot.getToppingsList().size();i++) {
			if(lot.getToppingsList().get(i).getType().equals(top)) {
				this.topping = lot.getToppingsList().get(i);
				this.toppingList.add(this.topping);
				this.topping.updateCount(1);
				break;
			}
		}
		
	}
	public void addCondiment(String con) {
		for(int i=0;i<locon.getCondimentsList().size();i++) {
			if(locon.getCondimentsList().get(i).getType().equals(con)) {
				this.condiment = locon.getCondimentsList().get(i);
				this.condimentList.add(this.condiment);
				this.condiment.updateCount(1);
				break;
			}
		}
		
	}
	public boolean deleteTopping(Topping top) {
		for(int i =0; i<toppingList.size();i++) {
			if(toppingList.get(i).getType().equals(top.getType())) {
				toppingList.remove(toppingList.get(i));
				top.updateCount(-1);
				System.out.println("Successfully removed!");
				return true;
			
			}
			else
				return false;
			
		}
		return false;
		
	}
	public boolean deleteCondiment(Condiment con) {
		for(int i =0; i<condimentList.size();i++) {
			if(condimentList.get(i).getType().equals(con.getType())) {
				condimentList.remove(condimentList.get(i));
				con.updateCount(-1);
				System.out.println("Successfully removed!");
				return true;
			
			}
			else
				return false;
			
		}
		return false;
		
	}
	
	public String getMeatInfo() {
		return("Meat: "+ this.meat.getType() + "| |"+ this.meat.getCount());
	}
	
	public void getToppings() {
		for(int i=0; i<toppingList.size(); i++) {
			double fullPrice = toppingList.get(i).getFullCost();
			System.out.println("Topping " + (i+1) +": " + toppingList.get(i).getType()+"| |" +fullPrice);
		}
	}
	private void getCondiments() {
		for(int i=0; i<condimentList.size(); i++) {
			double fullPrice = condimentList.get(i).getFullCost();
			System.out.println("Condiment " + (i+1) +": " + condimentList.get(i).getType()+"| |" +fullPrice);
		}
	}
	public String getBreadInfo() {
		return("Bread: "+ this.bread.getType() + "| |" +this.bread.getBuyCount()+ "| |"+ this.bread.getFullCost());
	}
	public BreadRollType getBread() {
		return bread;
	}
	public MeatType getMeat() {
		return meat;
	}
	public void chooseMeat(String meat) {
		for(int i=0;i<lom.getMeatList().size();i++) {
			if(lom.getMeatList().get(i).getType().equals(meat)) {
				this.meat = lom.getMeatList().get(i);
				this.meat.updateCount(1);
				break;
			}
		}
		
	}
	public void chooseBread(String bread) {
		for(int i=0;i<lob.getBreadList().size();i++) {
			if(lob.getBreadList().get(i).getType().equals(bread)) {
				this.bread = lob.getBreadList().get(i);
				this.bread.updateCount(1);
				break;
			}
		}
	}
	public String getCheeseInfo() {
		return("Cheese: "+ this.cheese.getType() + "| |" +this.cheese.getBuyCount()+ "| |"+ this.cheese.getFullCost());
	}
	public void chooseCheese(String cheese) {
		for(int i=0;i<loc.getCheeseList().size();i++) {
			if(loc.getCheeseList().get(i).getType().equals(cheese)) {
				this.cheese = loc.getCheeseList().get(i);
				this.cheese.updateCount(1);
				break;
			}
		}
	}
	public List<Topping> getToppingList() {
		return toppingList;
	}
	public List<Condiment> getCondimentsList() {
		return condimentList;
	}

	public double getPrice() {
		return this.price;
	}
	public double thePrice() {
		this.price = this.meat.getFullCost()+this.bread.getFullCost()+this.cheese.getFullCost();
		for(int i=0; i<this.toppingList.size();i++) {
			this.price += this.toppingList.get(i).getFullCost();
		}
		for(int i=0; i<this.condimentList.size();i++) {
			this.price += this.condimentList.get(i).getFullCost();
		}
		return this.price;
	}
	
	public CheeseType getCheese() {
		return this.cheese;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type+ ": $"+price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void deleteAllToppings() {
		this.toppingList = new ArrayList<>();
	}
	public void deleteAllCondiments() {
		this.condimentList = new ArrayList<>();
	}
	

}
