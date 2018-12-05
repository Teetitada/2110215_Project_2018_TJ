package model;

import scene.ResLoader;

public class LoadFaster extends PowerUp{
 public LoadFaster() {
  // TODO Auto-generated constructor stub
  this.image = ResLoader.LoadFaster;  
 }

 @Override
 public void action(Hand hand) {
  // TODO Auto-generated method stub
  hand.setLoadMax(hand.getLoadMax()-50);  
 }
}