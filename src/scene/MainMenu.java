package scene;

import javafx.scene.layout.Pane;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class MainMenu extends Pane {

	private final double BTN_WIDTH = 100;
	private final double BTN_HEIGHT = 100;
	private Canvas playBtn;
//	private Canvas menuBG = new Canvas(SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
	private ImageView iv = new ImageView();
	
	public MainMenu() {
//		GraphicsContext gc = menuBG.getGraphicsContext2D();
//		gc.drawImage(ResLoader.MenuImg, 0, 0, SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
//		getChildren().add(menuBG);
		
		Image i = new Image(ClassLoader.getSystemResource("img/MovingBG.gif").toString());
		iv.setImage(i);
		getChildren().add(iv);
		
		//Title
		Canvas MainLabel = new Canvas(SceneManager.SCENE_WIDTH,300);
		GraphicsContext gc = MainLabel.getGraphicsContext2D();
		
		gc.drawImage(ResLoader.Logo, 300, 100, 200,100);
		gc.setFill(Color.WHITE);
		gc.setTextBaseline(VPos.CENTER);
		gc.setTextAlign(TextAlignment.CENTER);
		//gc.fillText("Ewww! WASABI", SceneManager.SCENE_WIDTH/2, 150);
		//gc.strokeText("Ewww! WASABI", SceneManager.SCENE_WIDTH/2, 150);
		
		changeCenter(MainLabel, 0, 0);
		getChildren().add(MainLabel);
		
		//Button
		playBtn = drawButton(ResLoader.PlayBtn1);	
		playBtn.setFocusTraversable(true);
		addCanvasEvents(playBtn, "Play", ResLoader.PlayBtn1, ResLoader.PlayBtn2);
		
		getChildren().add(playBtn);
		changeCenter(playBtn, (SceneManager.SCENE_WIDTH-BTN_WIDTH)/2, SceneManager.SCENE_HEIGHT/2);
		
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
				if(buttonName=="Play") SceneManager.goToGameScene(); //<<<to be fixed
				
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
