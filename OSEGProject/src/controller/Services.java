package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

public class Services {
	@SuppressWarnings("rawtypes")
	@FXML
	private ChoiceBox serviceSelect;

	ObservableList<String> serviceSelectList = FXCollections.observableArrayList("Government","Private");
	
	public void initialize(){
		try {
			loadServices();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	@SuppressWarnings("unchecked")
		public void loadServices() throws IOException {
	// TODO Auto-generated method stub
			
			serviceSelect.setItems(serviceSelectList);
		
			}
	
	public void confirmService() throws IOException {
		if(serviceSelect.getValue()==null){
  			Alert alert = new Alert(AlertType.ERROR);
  			alert.setTitle("Error Dialog");
  			alert.setHeaderText("Look, an Error Dialog");
  			alert.setContentText("Please select either Government or Private Services");	
  			alert.showAndWait();
  		}
		else if(serviceSelect.getValue().equals("Government")){
			FGServices fgService= new FGServices();
			fgService.loadFgServices();
		}
		else if(serviceSelect.getValue().equals("Private")){
			PServices pService=new PServices();
			pService.loadPServices();
		}
		
	}
	
	public void serviceLoad() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ServiceSelectionHeader.fxml"));
		Parent root = loader.load();
		OSEGMain.commStage.setScene(new Scene(root));
		OSEGMain.commStage.setTitle("Service Header");
		OSEGMain.commStage.show();
	}
	
	public void logoutServicePage() throws IOException {
		Logout lg=new Logout();
		lg.logout();
	}
	
}
