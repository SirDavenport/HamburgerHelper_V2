package com.derek.hamburger_helper;

public class Food {
	
	private String type;
	private double price;
	private int count;
	private boolean isAvailable;
	private int buyCount;
	public Food(String type, double price, int count, int buyCount) {
		super();
		this.type = type;
		this.price = price;
		this.isAvailable = true;
		this.count = count;
		this.buyCount = buyCount;
	}
	
	public void getMoreFood(int numberOfFood) {
		System.out.println("Ordered " + numberOfFood + " more");
		count = numberOfFood+count;
		this.isAvailable = true;
	}

	public String getType() {
		return type;
	}
	public double getPrice() {
		return price;
	}
	public int getCount() {
		return count;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public int getBuyCount() {
		return buyCount;
	}
	
	public double getFullCost() {
		return this.price*this.buyCount;
	}
	
	public void updateCount(int count) {
		this.count -= count;
	}

	@Override
	public String toString() {
		return type + ": " + "$"+getFullCost();
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	

}
