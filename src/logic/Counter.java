package logic;

import javafx.scene.canvas.GraphicsContext;
import model.Renderable;
import scene.ResLoader;

public class Counter extends Thread implements Renderable{
	int current = 7;	
	public void run() {
		while(current>0) {
		try {						
				Thread.sleep(1000);
				current--;			
				if (current == 5) { ResLoader.AlarmTime.play(); }
				if (current == 4) { ResLoader.GameBgm.stop(); }
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
		String text = "" + current;
		gc.fillText( text, 383, 50);
		gc.strokeText( text, 383, 50);   
    }		
}
