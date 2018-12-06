package scene;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class GameOver extends Pane {

	private final double BTN_WIDTH = 75;
	private final double BTN_HEIGHT = 75;
	
	private Canvas replayBtn;
	private Canvas homeBtn;
	private Canvas field, gameOverLabel, result;
	
	private ImageView iv = new ImageView();
	
	private int redScore;
	private int blueScore;
	
	public GameOver(int score1, int score2) {
		this.redScore = score1;		
		this.blueScore = score2;
		
		//Background
		Image i = ResLoader.MenuImg;
		iv.setImage(i);
		getChildren().add(iv);
		
		gameOverLabel = new Canvas(SceneManager.SCENE_WIDTH,200);
		GraphicsContext gc2 = gameOverLabel.getGraphicsContext2D();
		
		gc2.setFont(Font.font("Times New Roman", 50));
		gc2.setFill(Color.BLACK);
		gc2.setTextBaseline(VPos.CENTER);
		gc2.setTextAlign(TextAlignment.CENTER);
		gc2.fillText("GAME OVER", SceneManager.SCENE_WIDTH/2, 100);
		
		changeCenter(gameOverLabel, 0, 0);
		getChildren().add(gameOverLabel);
		
		//ScoreResult
		result = new Canvas(300,300);
		showResult(result);
		
		field = new Canvas(300,200);
		field.setOpacity(0.5);
		GraphicsContext gcSth = field.getGraphicsContext2D();
		gcSth.setFill(Color.WHITE);
		gcSth.fillRoundRect(1, 1, 300-2, 200-2, 20, 20);
		
		changeCenter(result, (SceneManager.SCENE_WIDTH-300)/2, 150);
		changeCenter(field, (SceneManager.SCENE_WIDTH-300)/2, 150);
		getChildren().addAll(field,result);
		
		//Button
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
	
	private void showResult(Canvas canvas) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		gc.setFont(Font.font(getStyle(), 22));
		gc.setFill(Color.BLACK);
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.CENTER);
		gc.fillText("Red Score",canvas.getWidth()/2, 25);
		gc.fillText(""+redScore, canvas.getWidth()/2, 75);
		gc.fillText("Blue Score", canvas.getWidth()/2, 125);
		gc.fillText(""+blueScore, canvas.getWidth()/2, 175);
		
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
				ResLoader.GameOver.stop();
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
