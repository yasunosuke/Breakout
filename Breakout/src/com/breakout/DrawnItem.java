package com.breakout;

public class DrawnItem {
	
	private String character;
	private int positionX;
	private int positionY;
	private final int HEIGHT;
	private final int WIDTH;

	public DrawnItem(String character, int positionX, int positionY, int hEIGHT, int wIDTH) {
		super();
		this.character = character;
		this.positionX = positionX;
		this.positionY = positionY;
		HEIGHT = hEIGHT;
		WIDTH = wIDTH;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	
	public String getCharacter() {
		return character;
	}

	public int getWIDTH() {
		return WIDTH;
	}
	
	
	
	
	
}
