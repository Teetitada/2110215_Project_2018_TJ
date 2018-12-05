package model;

import javafx.scene.image.Image;
import scene.ResLoader;

public class SpeedUp extends PowerUp {

	public SpeedUp() {
		// TODO Auto-generated constructor stub
		this.image = ResLoader.Speedup;		
	}

	@Override
	public void action(Hand hand) {
		// TODO Auto-generated method stub
		hand.setStep(hand.getStep()+2);		
		hand.setPickvelocity(hand.getPickvelocity()+100);
	}
}