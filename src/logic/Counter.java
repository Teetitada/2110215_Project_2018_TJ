package logic;

import javafx.scene.canvas.GraphicsContext;
import model.Renderable;
import scene.ResLoader;

public class Counter extends Thread implements Renderable{
	int current = 30;	
	public void run() {
		while(current>0) {
		try {						
				Thread.sleep(1000);
				current--;				
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Stop Timer Thread");
			break;
		}	
		}			
	}	
	
	@Override
	public void render(GraphicsContext gc){	
		gc.drawImage(ResLoader.Counter, 375, 15, 50,50);
		String text = "" + current;
		gc.fillText( text, 383, 50);
		gc.strokeText( text, 383, 50);   
    }		
}
