package scene;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.GameManager;
import logic.Holder;

public class SceneManager {
	private static Stage primaryStage;
	public static final double SCENE_WIDTH = 800;
	public static final double SCENE_HEIGHT = 500;
	
	private static Pane mainMenu = new MainMenu(); //<<fixed
	private static Scene mainMenuScene = new Scene(mainMenu,SCENE_WIDTH,SCENE_HEIGHT);
	
	public static void initialize(Stage stage) {
		primaryStage = stage;
		primaryStage.setResizable(false);
		primaryStage.show();
//		ResLoader.bgmSound.play(); //<< to be added
	}
	
	public static void gotoMainMenu() {
//		ResLoader.bgmSound.stop(); //
//		ResLoader.bgmSound.play(); // << to be added
		primaryStage.setScene(mainMenuScene);
	}
	
	public static void gotoSceneOf(Pane pane) {
//		ResLoader.bgmSound.stop();
//		ResLoader.bgmSound.play(); //<< to be added
		
		Scene sceneToGo = new Scene(pane,SCENE_WIDTH,SCENE_HEIGHT);	
		primaryStage.setScene(sceneToGo);
	}
	
	public static void goToGameScene() {
//		ResLoader.bgmSound.stop(); //<< to be add
		GameManager.startGame(); // << to be fix		
		Scene gameScene = new Scene(Holder.getInstance().getGameScene());
		primaryStage.setScene(gameScene);
		
		gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			
			@Override			
			public void handle(KeyEvent e) {
				// TODO Auto-generated method stub
				 String code = e.getCode().toString();				 
                 if ( !Holder.getInstance().getInput().contains(code) )
                     Holder.getInstance().getInput().add( code );
			}			
		});
		gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				// TODO Auto-generated method stub
				String code = e.getCode().toString();
                Holder.getInstance().getInput().remove( code );
			}			
		});
	}	
//	Pane gameOver = new GameOver(2500);
//	SceneManager.gotoSceneOf(gameOver);
	
}
