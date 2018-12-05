package model;

import scene.ResLoader;

public class Sushi extends Item {
	
	protected int score;	

	public int getScore() {
		return score;
	}

	@Override
	public void action(Hand hand) {
		// TODO Auto-generated method stub
		hand.setTotalScore(hand.getTotalScore()+score);	
	}
	
	
	
	 
}
