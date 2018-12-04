package scene;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class GameOver extends Pane {

	private final double BTN_WIDTH = 75;
	private final double BTN_HEIGHT = 75;
	
	private Canvas bgCanvas = new Canvas(SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
	private Canvas replayBtn;
	private Canvas homeBtn;
	
	private int score;
	
	public GameOver(int score) {
		this.score = score;		
		ResLoader.GameOver.play();
		GraphicsContext gc = bgCanvas.getGraphicsContext2D();
		gc.drawImage(ResLoader.GameOverImg, 0, 0, SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
		getChildren().add(bgCanvas);
		
		replayBtn = drawButton(ResLoader.ReplayBtn1);	
		replayBtn.setFocusTraversable(true);
		addCanvasEvents(replayBtn, "Replay", ResLoader.ReplayBtn1, ResLoader.ReplayBtn2);
		
		getChildren().add(replayBtn);
		changeCenter(replayBtn, (SceneManager.SCENE_WIDTH-BTN_WIDTH)/4, 375);
		
		homeBtn = drawButton(ResLoader.HomeBtn1);	
		addCanvasEvents(homeBtn, "Home", ResLoader.HomeBtn1, ResLoader.HomeBtn2);
		
		getChildren().add(homeBtn);
		changeCenter(homeBtn, 3*(SceneManager.SCENE_WIDTH-BTN_WIDTH)/4, 375);
	}
	
	private void changeCenter(Canvas canvas,double x, double y) {
		canvas.setTranslateX(x);
		canvas.setTranslateY(y);
	}
	
	private Canvas drawButton(Image img) {
		Canvas btn = new Canvas(BTN_WIDTH,BTN_HEIGHT);
		GraphicsContext gc = btn.getGraphicsContext2D();
		gc.drawImage(img, 0, 0, BTN_WIDTH,BTN_HEIGHT);
		
		return btn;
	}
	
	private void drawOnMouseEvent(Canvas canvas, Image img) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.drawImage(img, 0, 0, BTN_WIDTH,BTN_HEIGHT);
	}	
	
	private void addCanvasEvents(Canvas canvas, String buttonName, Image img1, Image img2) {
		//TODO Fill Code
		canvas.setOnMouseClicked(new javafx.event.EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if(buttonName=="Replay") SceneManager.goToGameScene(); // << to be fixed
				if(buttonName=="Home") SceneManager.gotoMainMenu();
			}
		});
		
		canvas.setOnMouseEntered(new javafx.event.EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				drawOnMouseEvent(canvas, img2);
			}	
		});
		
		canvas.setOnMouseExited(new javafx.event.EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				drawOnMouseEvent(canvas, img1);
			}
			
		});
	}
	
}
