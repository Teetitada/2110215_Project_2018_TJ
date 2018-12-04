package model;

import scene.ResLoader;

public class Sushi extends Entity {
	
	private final double SUSHI_WIDTH = 100;
	private final double SUSHI_HEIGHT = 100;
	
	protected int score;
	
	public Sushi() {
		this.positionX = 900;
		this.positionY = 200;
		this.velocityX = -200;
		this.velocityY = 0;
		this.width = SUSHI_WIDTH;
	    this.height = SUSHI_HEIGHT;  	    
	}

	public int getScore() {
		return score;
	}

	public double getSUSHI_WIDTH() {
		return SUSHI_WIDTH;
	}

	public double getSUSHI_HEIGHT() {
		return SUSHI_HEIGHT;
	}
	
	
	
	 
}
