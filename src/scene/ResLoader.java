package scene;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class ResLoader {
	
	//MENU VISUAL
	public static Image MenuImg, PlayBtn1, PlayBtn2;
	public static AudioClip MenuBgm;
	
	//OBJECT VISUAL
	public static AudioClip GameBgm;
	public static AudioClip PickSound, JumpSound, GameOver;
	public static AudioClip AlarmTime;
	public static Image BlueHand1, BlueHand2, RedHand1, RedHand2;
	public static Image RottenSushi, SalmonRoe, Salmon, Tamago, Shrim, Tuna;
	public static Image Speedup, LoadFaster;
	public static Image GameBg, Bar;
	public static Image Load, Counter;
	public static Image Logo;
	//GAMEOVER VISUAL
	public static Image GameOverImg, ReplayBtn1, ReplayBtn2, HomeBtn1, HomeBtn2;
	
	public static void loadResource() {
		//Load MENU
		MenuBgm = new AudioClip(ClassLoader.getSystemResource("audio/Santorini_2.mp3").toString());
		MenuImg = new Image(ClassLoader.getSystemResource("img/MovingBG.gif").toString());
		Logo = new Image(ClassLoader.getSystemResource("img/logo.png").toString());
		PlayBtn1 = new Image(ClassLoader.getSystemResource("img/PlayBtn1.png").toString());
		PlayBtn2 = new Image(ClassLoader.getSystemResource("img/PlayBtn2.png").toString());
		
		//Load Game(Process)
		GameBgm = new AudioClip(ClassLoader.getSystemResource("audio/Splashing_Around.mp3").toString());
		AlarmTime = new AudioClip(ClassLoader.getSystemResource("audio/Alarm_Clock.mp3").toString());
		PickSound = new AudioClip(ClassLoader.getSystemResource("audio/pick.wav").toString());
		JumpSound = new AudioClip(ClassLoader.getSystemResource("audio/jump.wav").toString());
		
		Counter = new Image(ClassLoader.getSystemResource("img/progress5.gif").toString());
		
		BlueHand1 = new Image(ClassLoader.getSystemResource("img/bluehand1.png").toString());
		BlueHand2 = new Image(ClassLoader.getSystemResource("img/bluehand2.png").toString());
		RedHand1 = new Image(ClassLoader.getSystemResource("img/redhand1.png").toString());
		RedHand2 = new Image(ClassLoader.getSystemResource("img/redhand2.png").toString());
		Load = new Image(ClassLoader.getSystemResource("img/progress4.gif").toString());
		
		
		GameBg = new Image(ClassLoader.getSystemResource("img/wood.jpg").toString());
		Bar = new Image(ClassLoader.getSystemResource("img/bar4.jpg").toString());
		
		Speedup = new Image(ClassLoader.getSystemResource("img/speedup.png").toString());
		LoadFaster = new Image(ClassLoader.getSystemResource("img/loadfaster.png").toString());
		
		RottenSushi = new Image(ClassLoader.getSystemResource("img/rotten.png").toString());
		SalmonRoe = new Image(ClassLoader.getSystemResource("img/salmonroe.png").toString());
		Shrim = new Image(ClassLoader.getSystemResource("img/shrim.png").toString());
		Tamago = new Image(ClassLoader.getSystemResource("img/tamago.png").toString());
		Tuna = new Image(ClassLoader.getSystemResource("img/tuna.png").toString());
		Salmon = new Image(ClassLoader.getSystemResource("img/salmon.png").toString());
		
		
		//Load GameOver
		GameOver = new AudioClip(ClassLoader.getSystemResource("audio/gameover.wav").toString());
		GameOverImg = new Image(ClassLoader.getSystemResource("img/GameOverBG.jpg").toString());
		ReplayBtn1 = new Image(ClassLoader.getSystemResource("img/ReplayBtn1.png").toString());
		ReplayBtn2 = new Image(ClassLoader.getSystemResource("img/ReplayBtn2.png").toString());
		HomeBtn1 = new Image(ClassLoader.getSystemResource("img/HomeBtn1.png").toString());
		HomeBtn2 = new Image(ClassLoader.getSystemResource("img/HomeBtn2.png").toString());
	}
}
