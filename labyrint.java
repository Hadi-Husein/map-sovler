package map;

import java.io.File;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class labyrint extends Application {

	int count = 0;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	
		Map map = MapInterpreter.interpretMap(new File("v37/map.txt"));

		MapSolver solve = new MapSolver(map.getStartX(), map.getStartY(), map);
		
		Scene scene = new Scene(map, map.getWidth(), map.getHeight());
		
		primaryStage.setScene(scene);
		primaryStage.show();

		MapSolver.Solver(map);
	
		new AnimationTimer() {
			
			public void handle(long now) {
				if ( count < solve.path.size()){
					
					map.getChildren().add(solve.path.get(count));
					count++;
				}
				else{ 
					System.out.println("Antal Steg: " +count);
					this.stop();

				}
			}
		}.start();
	}

	public static void main(String[] args) {
		launch();
	}

}
