package model;

public abstract class Item extends Entity{
	public abstract void action(Hand hand);	
	private final double Item_WIDTH = 100;
	private final double Item_HEIGHT = 100;	
	public Item() {
		this.positionX = 900;
		this.positionY = 200;
		this.velocityX = -200;
		this.velocityY = 0;
		this.width = Item_WIDTH;
	    this.height = Item_HEIGHT;  	    
	}
}
