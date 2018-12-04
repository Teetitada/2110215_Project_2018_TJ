package scene;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import logic.GameManager;
import logic.Holder;
import model.Entity;
import model.Hand;

public class GameScene extends Pane {
	
	public final static double GAME_WIDTH = 800 ;
	public final static double GAME_HEIGHT = 500;
	
	protected static Canvas canvas, canvas2;
//	protected Image gameBG;
	
	public GraphicsContext gc, gc2;
	
	public GameScene() {
		Initialize();
		//setEvent();
	}
	
	private void Initialize() {
		ResLoader.GameBgm.play();
		this.setWidth(GAME_WIDTH);
		this.setHeight(GAME_HEIGHT);
		canvas = new Canvas(GAME_WIDTH, GAME_HEIGHT);
		canvas2 = new Canvas(GAME_WIDTH, GAME_HEIGHT);
		this.getChildren().addAll(canvas,canvas2);
		this.gc = canvas.getGraphicsContext2D();	
		this.gc2 = canvas2.getGraphicsContext2D();
		Font theFont = Font.font( "Helvetica", FontWeight.BOLD, 30 );
        gc2.setFont( theFont );
        gc2.setFill( Color.WHITE);
        gc2.setStroke( Color.WHITE);
        gc2.setLineWidth(1);
		gc.drawImage(ResLoader.GameBg, 0, 0, GAME_WIDTH, GAME_HEIGHT);
		gc.drawImage(ResLoader.Bar, 0, 0);
	}
	
	/*private void setEvent() {		
		this.setOnMousePressed((MouseEvent event) -> {
			Holder.getInstance().getInput().add("UP");
		});
		this.setOnKeyPressed(new EventHandler<KeyEvent>() {
			
			@Override			
			public void handle(KeyEvent e) {
				// TODO Auto-generated method stub
				 String code = e.getCode().toString();
				 System.out.println("aaaa");
                 if ( !Holder.getInstance().getInput().contains(code) )
                     Holder.getInstance().getInput().add( code );
			}			
		});
		
		this.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				// TODO Auto-generated method stub
				String code = e.getCode().toString();
                Holder.getInstance().getInput().remove( code );
			}			
		});
	}*/
	
	public void paintComponent() {
		
		gc2.clearRect(0,0,800,500);
		Holder.getInstance().getCounter().render(gc2);
		
		for (Entity entity : Holder.getInstance().getFood()) { 
			entity.render(gc2);
		}
		Holder.getInstance().getHand().render(gc2);
		Holder.getInstance().getHand2().render(gc2);	
			
	}
	

	
	
}
