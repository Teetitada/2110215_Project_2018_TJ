package logic;

import java.util.Iterator;

import exception.LoadTimeException;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import model.Entity;
import model.Hand;
import model.Item;
import model.LoadFaster;
import model.PowerUp;
import model.RottenSushi;
import model.Salmon;
import model.SalmonRoe;
import model.Shrim;
import model.SpeedUp;
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
	

	public static void startGame() {
		Holder.getInstance().setup();
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
                
                try {
					checkInput(elapsedTime);
				} catch (LoadTimeException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getErrorMessage());
				}
                
                autoAddSushi();
                checkIntersects();               
                
                for (Entity obj : Holder.getInstance().getFood() )
                {
                	obj.update(elapsedTime);  
                }
                
                if(Holder.getInstance().getCounter().getCurrent() == 0 )
                {
                	ResLoader.AlarmTime.stop();
	            	gameOver();
	            	return;                   	
                }
			}
			
		};
		timer.start();
	}
		
	private static void checkInput(double elapsedTime) throws LoadTimeException {
		
		// game logic  
        if (Holder.getInstance().getInput().contains("UP")) Holder.getInstance().getHand2().go();
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
		
		if(size>=2){
        	if((Holder.getInstance().getFood().get(size-2).intersects(Holder.getInstance().getFood().get(size-1))))
        	{        		
        		int s = size-1;
        		Holder.getInstance().getFood().get(s).setPositionY(-10);    
        		Holder.getInstance().getFood().remove(s);        		    		
        	}
        }
		Iterator<Item> itemIter = Holder.getInstance().getFood().iterator();
        while ( itemIter.hasNext() )
        {
            Item itemit = itemIter.next();
            
            if ( Holder.getInstance().getHand().intersects(itemit) ) {   
            	
            	Holder.getInstance().getHand().setPick(true);
            	ResLoader.PickSound.play();         
            	            	
	            Item item = (Item) itemit;
	            	item.action(Holder.getInstance().getHand());	            	
	            	itemIter.remove(); 
            }                     
            
            
            if ( Holder.getInstance().getHand2().intersects(itemit)) {   
            	
            	Holder.getInstance().getHand2().setPick(true);
            	ResLoader.PickSound.play();  
            	
            	Item item = (Item) itemit;
            	item.action(Holder.getInstance().getHand2());	            	
            	itemIter.remove();                   
            }
        }     
	}
	
	private static void autoAddSushi() {
		if (Math.random()<0.06){
        	double rdm = Math.random();  
        	
        	if(rdm>0.00&&rdm<0.04){
        		Item loadfaster = new LoadFaster();
        		Holder.getInstance().getFood().add(loadfaster);  
        	}
        	
        	if(rdm>0.04&&rdm<0.08){
        		Item speedup = new SpeedUp();
        		Holder.getInstance().getFood().add(speedup);  
        	}
        	
        	if(rdm>0.08&&rdm<0.18){
        		Item sushi = new RottenSushi();
	        	Holder.getInstance().getFood().add( sushi );  
        	}
        	
        	if(rdm>0.18&&rdm<0.38){
        		Item sushi = new Tamago();
	    		Holder.getInstance().getFood().add( sushi );  
    		}
        	
        	if(rdm>0.38&&rdm<0.58) {
        		Item sushi = new Shrim();
	    		Holder.getInstance().getFood().add( sushi );  
    		}
        	
        	if(rdm>0.58&&rdm<0.78){
        		Item sushi = new SalmonRoe();
	    		Holder.getInstance().getFood().add( sushi );  
    		}
        	
        	if(rdm>0.78&&rdm<0.93){
        		Item sushi = new Salmon();
	    		Holder.getInstance().getFood().add( sushi );  
    		}
        	
        	if(rdm>0.93&&rdm<1.000){
        		Item sushi = new Tuna();
	    		Holder.getInstance().getFood().add( sushi );  
    		}     
        	
        }
	}
	
	private static void gameOver() {
		timer.stop();
		ResLoader.AlarmTime.stop();
		Pane gameOver = new GameOver(Holder.getInstance().getHand2().getTotalScore(),
				Holder.getInstance().getHand().getTotalScore()); // <<hand2=red, hand1=blue

		Holder.getInstance().reset();
		ResLoader.GameOver.play();
		SceneManager.gotoSceneOf(gameOver);
	}
	

}
