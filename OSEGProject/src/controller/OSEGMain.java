package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class OSEGMain extends Application {

	public static Stage commStage;
	public static void main(String[] args) {
		launch(args);
		// TODO Auto-generated method stub
	
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		//Scene scene = new Scene(new StackPane());
		commStage=primaryStage;
		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass()
				.getResource("/view/Login.fxml"));
		Scene scene1 = new Scene(root);
		commStage.setTitle("LoginPage");
		commStage.setScene(scene1);
		commStage.show();
		
	}

}
