package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import model.DaoModel;

public class AdminPageController {


	private ComboBox serviceSelect=new ComboBox<>();

	
	private ComboBox nameSelect= new ComboBox<>();
	

	

	
	ObservableList<String> serviceSelectList =  FXCollections.observableArrayList("Government","Private");
	ObservableList<String> nameListG = FXCollections.observableArrayList("Community Living","Ability One Commission","United States Access Board","Administration for Children and Families",
			"Administration for Native Americans","Administration Conference for United States","U S Department of Agriculture","U S Air Force","Alcohol and Tobacco Tax",
			"Bureau of Consular Affairs","Central Intelligence Agency");
	
	ObservableList<String> nameListP = FXCollections.observableArrayList("Plumbing","Health Insurance","Air Conditioning","Gardening","Car Insurance",
			"paint","Carpet Cleaning","Furniture","Pest Control");
	
	public AdminPageController admPageCont;
	public List<AdminPageController> admList=new ArrayList<>();
	private String serviceType;
	private String serviceName;
	private String textAreaData;
	
	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getTextAreaData() {
		return textAreaData;
	}

	public void setTextAreaData(String textAreaData) {
		this.textAreaData = textAreaData;
	}

	/*@SuppressWarnings("unchecked")
	public void initialize(){
		serviceSelect=new ComboBox<>();
		serviceSelect.setItems(serviceSelectList);
		//loadNames();
	 }*/
	
	@SuppressWarnings("unchecked")
		public void loadServices() throws IOException {
	// TODO Auto-generated method stub
			
			serviceSelect.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
	            @Override
	            public void changed(ObservableValue ov, Object t, Object t1) {

	                switch (t1.toString()) {
	                    case "Government":
	                    	nameSelect=new ComboBox<>();
	                        nameSelect.setItems(nameListG);
	                        break;
	                   case "Private":
	                	   nameSelect=new ComboBox<>();
	                	   nameSelect.setItems(nameListP);
	                        break;
	                }
	            }
	        });
			
			AnchorPane root = new AnchorPane();
			root.getChildren().addAll(serviceSelect,nameSelect);
			OSEGMain.commStage.setScene(new Scene(root));
			OSEGMain.commStage.setTitle("Admin Page");
			OSEGMain.commStage.show();
	}
	
	/*@SuppressWarnings("unchecked")
	public void loadNames() {
		nameSelect.setItems(nameList);
	}*/
	
	/*public void submitData(){
		
		admPageCont=new AdminPageController();
		String textAreaData=textAreaField.getText();
		String[] textArray=textAreaData.split(";");
		if(serviceSelect.getValue()==null){
  			Alert alert = new Alert(AlertType.ERROR);
  			alert.setTitle("Error Dialog");
  			alert.setHeaderText("Look, an Error Dialog");
  			alert.setContentText("Select Government/Private Services");	
  			alert.showAndWait();
  		}
		
		if(nameSelect.getValue()==null){
  			Alert alert = new Alert(AlertType.ERROR);
  			alert.setTitle("Error Dialog");
  			alert.setHeaderText("Look, an Error Dialog");
  			alert.setContentText("Select Atleast One service name to continue");	
  			alert.showAndWait();
  		}
		
		if(!(serviceSelect.getValue()==null) &&  !(nameSelect.getValue()==null) && textArray.length>0){
			for(String strData:textArray) {
				admPageCont.setTextAreaData(strData);
				admPageCont.setServiceType(serviceSelect.getValue().toString());
				admPageCont.setServiceName(nameSelect.getValue().toString());
				admList.add(admPageCont);
			}
		
		}
		
		DaoModel dm=new DaoModel();
		try {
		boolean b=dm.insertUrlData(admList);
		if(b) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Success.fxml"));
			Parent root =loader.load();
			OSEGMain.commStage.setScene(new Scene(root));
			OSEGMain.commStage.setTitle("Success Page");
			OSEGMain.commStage.show();
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	*/
	@SuppressWarnings("unchecked")
	public void adminPageLoad() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AdminPage.fxml"));
		AnchorPane root =(AnchorPane)loader.load();
		
		
	
         
         
		root.setLayoutX(10.0);
		root.setLayoutY(20.0);
		root.setPrefHeight(600.0);
		root.setPrefWidth(600.0);
		root.setStyle("-fx-background-image: url('view/images/adminback2.jpg');");
		
		
		/*String image = JavaFXApplication9.class.getResource("splash.jpg").toExternalForm();
		root.setStyle("-fx-background-image: url('" + image + "'); " +
		           "-fx-background-position: center center; " +
		           "-fx-background-repeat: stretch;");*/
		AnchorPane root1=new AnchorPane();
		
		root1.setLayoutX(100.0);
		root1.setLayoutY(120.0);
		root1.setPrefHeight(400.0);
		root1.setPrefWidth(400.0);
		
		 Label headerLabel = new Label("Admin Services Page ");
		 headerLabel.setLayoutX(20.0);
		 headerLabel.setLayoutY(30.0);
		 headerLabel.setAlignment(Pos.CENTER);
		 headerLabel.setPrefHeight(80.0);
		 headerLabel.setPrefWidth(750.0);
		 headerLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
		 root.getChildren().addAll(headerLabel);
		 
		 Label headerLabelTS = new Label("Type of Service ");
		 headerLabelTS.setLayoutX(38.0);
		 headerLabelTS.setLayoutY(50.0);
		 headerLabelTS.setStyle("-fx-font-size: 16;");
		 root1.getChildren().addAll(headerLabelTS);
		 
		 Label serviceNameLabel = new Label("Service Name      ");
		 serviceNameLabel.setLayoutX(38.0);
		 serviceNameLabel.setLayoutY(80.0);
		 serviceNameLabel.setStyle("-fx-font-size: 16;");
		 root1.getChildren().addAll(serviceNameLabel);
		 
		 Label headerLabelURL = new Label("URL ");
		 headerLabelURL.setLayoutX(38.0);
		 headerLabelURL.setLayoutY(110.0);
		 headerLabelURL.setStyle("-fx-font-size: 16;");
		 root1.getChildren().addAll(headerLabelURL);
		 
		 TextArea ta = new TextArea();
		 ta.setLayoutX(200.0);
		 ta.setLayoutY(105.0);
		 ta.setPrefHeight(100.0);
		 ta.setPrefWidth(300.0);
		 root1.getChildren().addAll(ta);
		 
		 Label headerLabelNote = new Label(" Please Note: To add multiple url's seperate it by ';' ");
		 headerLabelNote.setLayoutX(200.0);
		 headerLabelNote.setLayoutY(230.0);
		 root1.getChildren().addAll(headerLabelNote);
		 
		 
	        
		serviceSelect=new ComboBox<>();
		serviceSelect.setLayoutX(200.0);
		serviceSelect.setLayoutY(35.0);
		serviceSelect.setPrefWidth(150.0);
		
		nameSelect=new ComboBox<>();
    	nameSelect.setLayoutX(200.0);
    	nameSelect.setLayoutY(70.0);
    	nameSelect.setPrefWidth(150.0);
		serviceSelect.setItems(serviceSelectList);
		serviceSelect.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue ov, Object t, Object t1) {

                switch (t1.toString()) {
                    case "Government":
                    	
                        nameSelect.setItems(nameListG);
                        break;
                   case "Private":
                	   
                	   nameSelect.setItems(nameListP);
                        break;
                }
            }
        });
	
		Button submitButton = new Button("Submit");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        submitButton.setLayoutX(200.0);
        submitButton.setLayoutY(300.0);
       
        Button logout = new Button("Logout");
        logout.setPrefHeight(40);
        logout.setDefaultButton(true);
        logout.setPrefWidth(100);
        logout.setLayoutX(320.0);
        logout.setLayoutY(300.0);
       
        
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
        	
            @Override
            public void handle(ActionEvent event) {
            	
            	admPageCont=new AdminPageController();
        		String textAreaData=ta.getText();
        		System.out.println("gfffg"+textAreaData.length());
        		System.out.println(""+ta);
        		if(textAreaData.equals("")){
          			Alert alert = new Alert(AlertType.ERROR);
          			alert.setTitle("Error Dialog");
          			alert.setHeaderText("Look, an Error Dialog");
          			alert.setContentText("Add URL's");	
          			alert.showAndWait();
          		}
        		String[] textArray=textAreaData.split(";");
        		if(serviceSelect.getValue()==null){
          			Alert alert = new Alert(AlertType.ERROR);
          			alert.setTitle("Error Dialog");
          			alert.setHeaderText("Look, an Error Dialog");
          			alert.setContentText("Select Government/Private Services");	
          			alert.showAndWait();
          		}
        		
        		
        		if(nameSelect.getValue()==null){
          			Alert alert = new Alert(AlertType.ERROR);
          			alert.setTitle("Error Dialog");
          			alert.setHeaderText("Look, an Error Dialog");
          			alert.setContentText("Select Atleast One service name to continue");	
          			alert.showAndWait();
          		}
        		
        		if(!(serviceSelect.getValue()==null) &&  !(nameSelect.getValue()==null) && textArray.length>0){
        			for(String strData:textArray) {
        				admPageCont.setTextAreaData(strData);
        				admPageCont.setServiceType(serviceSelect.getValue().toString());
        				admPageCont.setServiceName(nameSelect.getValue().toString());
        				admList.add(admPageCont);
        			}
        		
        		}
        		
        		DaoModel dm=new DaoModel();
        		try {
        		boolean b=dm.insertUrlData(admList);
        		if(b) {
        			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Success.fxml"));
        			Parent root =loader.load();
        			OSEGMain.commStage.setScene(new Scene(root));
        			OSEGMain.commStage.setTitle("Success Page");
        			OSEGMain.commStage.show();
        		}
        		} catch (Exception e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        		
            	
            	
            	
            	
            }});
        
        logout.setOnAction(new EventHandler<ActionEvent>() {
        	
            @Override
            public void handle(ActionEvent event) {
            	try {
					logoutAdminPage();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }});
        root1.getChildren().addAll(logout);
        root1.getChildren().addAll(submitButton);
		//AnchorPane root = new AnchorPane();
		root1.getChildren().addAll(serviceSelect,nameSelect);
		root.getChildren().addAll(root1);
		OSEGMain.commStage.setScene(new Scene(root));
		OSEGMain.commStage.setTitle("Admin Page");
		OSEGMain.commStage.show();
		   
        
	}
	
	public void logoutAdminPage() throws IOException {
		Logout lg=new Logout();
		lg.logout();
	}
	
}
