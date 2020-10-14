package controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Logout {

	public  void logout() throws IOException {

		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass()
				.getResource("/view/Login.fxml"));
		OSEGMain.commStage.setScene(new Scene(root));
		OSEGMain.commStage.setTitle("Login Page");
		OSEGMain.commStage.show();
	}
	
	public void backToAdmin() throws IOException {
		AdminPageController sc=new AdminPageController();
		sc.adminPageLoad();
	}
}
