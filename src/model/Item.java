package model;

public abstract class Item extends Entity{
	public abstract void action(Hand hand);	
	private final double ITEM_WIDTH = 100;
	private final double ITEM_HEIGHT = 100;	
	public Item() {
		this.positionX = 900;
		this.positionY = 200;
		this.velocityX = -200;
		this.velocityY = 0;
		this.width = ITEM_WIDTH;
	    this.height = ITEM_HEIGHT;  	    
	}
}
