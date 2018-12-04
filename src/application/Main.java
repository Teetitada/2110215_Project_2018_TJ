package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import logic.Holder;
import scene.ResLoader;
import scene.SceneManager;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root,800,500);
			
			ResLoader.loadResource();//<<<<< added
			
			//auto-gen
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			SceneManager.initialize(primaryStage);
			SceneManager.gotoMainMenu();
			
			primaryStage.setTitle("Ewww!! WASABI");
//			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
//			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		Holder.getInstance().getCounter().interrupt();
	}
}
