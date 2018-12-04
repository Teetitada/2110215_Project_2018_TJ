package model;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Entity implements Renderable{
	protected Image image;
	protected double positionX;
	protected double positionY;    
	protected double velocityX;
	protected double velocityY;
	protected double width;
	protected double height;	
	
	public void update(double time) {
		positionX += velocityX * time;
        positionY += velocityY * time;
	}
	
	public Rectangle2D getBoundary() {
        return new Rectangle2D(positionX,positionY,width,height);
    }

	
	public boolean intersects(Entity e){
        return e.getBoundary().intersects( this.getBoundary() );
    }
	
	@Override
	public void render(GraphicsContext gc){		
        gc.drawImage( image, positionX, positionY, width, height );        
    }

	public double getPositionX() {
		return positionX;
	}

	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	public double getPositionY() {
		return positionY;
	}

	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	

	
}
