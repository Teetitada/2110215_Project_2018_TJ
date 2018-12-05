package logic;

import java.util.Iterator;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import model.Entity;
import model.Hand;
import model.RottenSushi;
import model.Salmon;
import model.SalmonRoe;
import model.Shrim;
import model.Sushi;
import model.Tamago;
import model.Tuna;

import scene.SceneManager;
import scene.GameOver;
import scene.ResLoader;
import logic.Holder;

public class GameManager {
	
	private static long lastNanoTime = System.nanoTime();
	private static AnimationTimer timer;
	private static double elapsedTime;
	

	public static void startGame() {
		Holder.getInstance().setup(); // <<to be fix
//		score = 0;		
		Holder.getInstance().getCounter().start();
		timer = new AnimationTimer() {
			@Override
			public void handle(long currentNanoTime) {
				// TODO Auto-generated method stub
				double elapsedTime = (currentNanoTime - lastNanoTime) / 1000000000.0;				
                lastNanoTime = currentNanoTime;
                Holder.getInstance().getHand().setLoad(Holder.getInstance().getHand().getLoad()+2);
                Holder.getInstance().getHand2().setLoad(Holder.getInstance().getHand2().getLoad()+2);
                Holder.getInstance().getGameScene().paintComponent();
                checkInput(elapsedTime);
                autoAddSushi();
                checkIntersects();                
                for (Entity obj : Holder.getInstance().getFood() )
                {
                	obj.update(elapsedTime);  
                }
                if(Holder.getInstance().getCounter().current == 0 )
                {
                	ResLoader.GameBgm.stop();
	            	gameOver();
	            	return;                   	
                }
			}
			
		};
		timer.start();
	}
	
//	private static void update() {
//		
//	}
	
	private static void checkInput(double elapsedTime) {
		
		// game logic  
        if (Holder.getInstance().getInput().contains("UP"))Holder.getInstance().getHand2().go();
        if (Holder.getInstance().getInput().contains("LEFT")) Holder.getInstance().getHand2().left();                   
        if (Holder.getInstance().getInput().contains("RIGHT")) Holder.getInstance().getHand2().right();                   
        // render
        Holder.getInstance().getHand().update(elapsedTime);
        
        if (Holder.getInstance().getInput().contains("W")) Holder.getInstance().getHand().go(); 
        if (Holder.getInstance().getInput().contains("A")) Holder.getInstance().getHand().left();                   
        if (Holder.getInstance().getInput().contains("D")) Holder.getInstance().getHand().right();
        
        Holder.getInstance().getHand2().update(elapsedTime);
	}
	
	private static void checkIntersects() {
		int size = Holder.getInstance().getFood().size();
		/*for(int i =0; i!=size; i++)
		{
			for(int j=i+1; j!=size; j++)
			{
				if((Holder.getInstance().getFood().get(i).intersects(Holder.getInstance().getFood().get(j))))
				{
					Holder.getInstance().getFood().get(j).setPositionY(-100);
				}
			}
		}*/
		if(size>=2){
        	if((Holder.getInstance().getFood().get(size-2).intersects(Holder.getInstance().getFood().get(size-1))))
        	{        		
        		int s = size-1;
        		Holder.getInstance().getFood().get(s).setPositionY(-10);    
        		Holder.getInstance().getFood().remove(s);        		    		
        	}
        }
		Iterator<Entity> foodIter = Holder.getInstance().getFood().iterator();
        while ( foodIter.hasNext() )
        {
            Entity obj = foodIter.next();
            
            if ( Holder.getInstance().getHand().intersects(obj) ) {   
            	Holder.getInstance().getHand().setPick(true);
            	ResLoader.PickSound.play();
            	
            	/*if(obj instanceof Wasabi) {                    	
	            	ResLoader.GameBgm.stop();
	            	gameOver();
	            	return;
            	}*/
            	
            	if(obj instanceof Sushi ){
	            	Sushi sushi = (Sushi) obj;
	            	sushi.action(Holder.getInstance().getHand());	            	
	            	foodIter.remove(); 
            	}                      
            }
            
            if ( Holder.getInstance().getHand2().intersects(obj)) {   
            	Holder.getInstance().getHand2().setPick(true);
            	ResLoader.PickSound.play();
            	
            	/*if(obj instanceof Wasabi){                    	
	            	ResLoader.GameBgm.stop();
	            	gameOver();
	            	return;
            	}*/
            	
            	if(obj instanceof Sushi ) {
            		Sushi sushi = (Sushi) obj;
	            	sushi.action(Holder.getInstance().getHand2());
	            	foodIter.remove(); 
            	}                      
            }
        }     
	}
	
	private static void autoAddSushi() {
		if (Math.random()<0.06){
        	double rdm = Math.random();  
        	
        	/*if(rdm>0.00&&rdm<0.08){
        		Wasabi wasabi = new Wasabi();
        		Holder.getInstance().getFood().add( wasabi );  
        	}*/
        	
        	if(rdm>0.08&&rdm<0.18){
	        	Sushi sushi = new RottenSushi();
	        	Holder.getInstance().getFood().add( sushi );  
        	}
        	
        	if(rdm>0.18&&rdm<0.38){
	    		Sushi sushi = new Tamago();
	    		Holder.getInstance().getFood().add( sushi );  
    		}
        	
        	if(rdm>0.38&&rdm<0.58) {
	    		Sushi sushi = new Shrim();
	    		Holder.getInstance().getFood().add( sushi );  
    		}
        	
        	if(rdm>0.58&&rdm<0.78){
	    		Sushi sushi = new SalmonRoe();
	    		Holder.getInstance().getFood().add( sushi );  
    		}
        	
        	if(rdm>0.78&&rdm<0.93){
	    		Sushi sushi = new Salmon();
	    		Holder.getInstance().getFood().add( sushi );  
    		}
        	
        	if(rdm>0.93&&rdm<1.000){
	    		Sushi sushi = new Tuna();
	    		Holder.getInstance().getFood().add( sushi );  
    		}     
        	
        }
	}
	
	private static void gameOver() {
		timer.stop();
		Pane gameOver = new GameOver(Holder.getInstance().getHand().getTotalScore()); // <<to be fixed later
		Holder.getInstance().reset(); // <<to be fix
		SceneManager.gotoSceneOf(gameOver);
	}
	
	public static double getElapsetime() {
		return elapsedTime;
	}

}
