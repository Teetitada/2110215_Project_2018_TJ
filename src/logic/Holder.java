package logic;

import java.util.ArrayList;

import model.Entity;
import model.Hand;
import model.Item;
import model.RottenSushi;
import model.Salmon;
import model.SalmonRoe;
import model.Shrim;
import model.Sushi;
import model.Tamago;
import model.Tuna;
//import scene.Animation;
import scene.GameScene;
import scene.ResLoader;

public class Holder {
	
	private static Holder instance = new Holder();
	
	private GameScene GameScene;

	
	private static ArrayList<String> input;
    private static ArrayList<Item> item;
    
    private Hand hand;
    private Hand hand2;
    private Counter counter;
    
    public Holder() {

    	input = new ArrayList<String>();
    	item = new ArrayList<Item>();
    }
    
    public static Holder getInstance () {
		return instance;
	}
    
    protected void setup() {
    	GameScene = new GameScene();
    	hand = new Hand(1,ResLoader.BlueHand1,ResLoader.BlueHand2);
    	hand2 = new Hand(2,ResLoader.RedHand1,ResLoader.RedHand2);
    	counter = new Counter();
    }
    
    protected void reset() {
    	GameScene = null;
    	input.clear();
    	item.clear();
    }
    
    public ArrayList<String> getInput(){
    	return input;
    }

	public ArrayList<Item> getFood() {
		return item;
	}
	

	public GameScene getGameScene() {
		return GameScene;
	}

	public Hand getHand() {
		return hand;
	}

	public Hand getHand2() {
		return hand2;
	}

	public Counter getCounter() {
		return counter;
	}

	public void setCounter(Counter counter) {
		this.counter = counter;
	}
	
	
	    
    
    
}
