package model;

import exception.LoadTimeException;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import scene.ResLoader;

public class Hand extends Entity{
	
	private int loadMax;
	private boolean go;
	private boolean back;
	private boolean pick;
	private int step;
	private int pickvelocity;
	private int totalScore;
	private int load;	
	private static int HAND_WIDTH = 80;
	private static int HAND_HEIGHT = 80;
	private int player;
	private Image image2;
	
	public int getLoad() {
		return load;
	}

	public void setLoad(int load) {
		this.load = load;
	}
	
	public Hand(int player, Image image, Image image2) {
		this.image = image;
		this.image2 = image2;
		this.player = player;
		this.loadMax = 400;
		this.pickvelocity = 300;
		this.load = 400;
		this.step = 5;
		if(player==1)
		{
			this.positionX = 250;
			this.positionY = 400;
		}
		if(player==2)
		{
			this.positionX = 500;
			this.positionY = 400;
		}
		this.velocityX = 0;
		this.velocityY = 0;
		this.totalScore = 0;
		this.go = false;
        this.back = false;
        this.pick = false;
	}
	
	public void left() {
	 	if(positionX<0||go||back) return;		 	
        positionX -= step;	        
    }

	public void right() {
		 if(positionX>730||go||back) return;		 	
		 positionX += step;	        
	}
	 
	public void go() throws LoadTimeException {
		if(!back&&load>=loadMax){
			ResLoader.JumpSound.play();
			this.load = 0;
			this.go = true;	
			this.velocityY = -pickvelocity;
		} else throw new LoadTimeException();		
	}
	
	public void checkGo() {
		if(go && positionY<200) {
			this.go = false;
			this.back = true;
			this.velocityY = pickvelocity;			
			this.pick = false;
		}		
	}
	
	public void checkBack() {
		if(back && positionY>400) {
			this.go = false;
			this.back = false;
			this.velocityY = 0;
			this.positionY = 400;
			this.pick = false;	
		}		
	}
	
	@Override
	public void update(double time) {		
		checkGo();
		checkBack();		
	    positionX += velocityX * time;
	    positionY += velocityY * time;     
	}
	
	public int getTotalScore() {
		return totalScore;
	}
	
	public void setTotalScore(int score) {
		this.totalScore = score;
	}
		
	public int getLoadMax() {
		return loadMax;
	}

	public void setLoadMax(int loadMax) {
		this.loadMax = loadMax;
	}

	public int getPickvelocity() {
		return pickvelocity;
	}

	public void setPickvelocity(int pickvelocity) {
		this.pickvelocity = pickvelocity;
	}

	@Override
	public void render(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
		if(pick == true) {
			gc.drawImage(image2, positionX, positionY, HAND_WIDTH, HAND_HEIGHT);
					
		}
		else gc.drawImage(image, positionX, positionY, HAND_WIDTH, HAND_HEIGHT);		
		if(!go && !back && !(load>=(loadMax-20)))
		{			
			gc.drawImage(ResLoader.Load,positionX+32, positionY+35, 30, 30);
		}
		if(player == 1)
		{
			String text = " Blue Score: " + totalScore;
			gc.fillText( text, 10, 50);
			gc.strokeText( text, 10, 50 );
		}
		if(player == 2)
		{
			String text = " Red Score: " + totalScore;
			gc.fillText( text, 450, 50);
			gc.strokeText( text, 450, 50 );
		}
		
	}

	public boolean isPick() {
		return pick;
	}

	public void setPick(boolean pick) {
		this.pick = pick;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	
	
	
}
