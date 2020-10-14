package controller;

import java.awt.Button;
import java.io.IOException;

import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.DaoModel;


public class LoginAccount  {
	public String userId;
	public String password;
	public Boolean accountStatus;
	
	ObservableList<String> choicesList = FXCollections.observableArrayList("@hawk.iit.edu","@iit.edu");
	ObservableList<String> selectionList = FXCollections.observableArrayList("Administrator","User");
	ObservableList<String> serviceSelectList = FXCollections.observableArrayList("Federal_Services","Private");
	
		@FXML
	    private Button clearpressed;

	    @FXML
	    private Button loginpressed;

	    @FXML
	    private PasswordField passwordField;

	    
	    @FXML
	    private TextField emailField;

	    @FXML
	    private CheckBox remember;

	    @FXML
	    private Hyperlink forgotPassword;

	    @FXML
	    private Button exitpressed;
	    
		
		@SuppressWarnings("rawtypes")
		@FXML
		private ChoiceBox choices;
		@SuppressWarnings("rawtypes")
		@FXML
		private ChoiceBox selection;
		
		@SuppressWarnings("rawtypes")
		@FXML
		private ChoiceBox serviceSelect;
		
		@FXML
		protected ResourceBundle resources;
		@FXML
		public javafx.scene.control.Button closeButton;


		@FXML
		public void closeButtonAction(){
		  // get a handle to the stage
		  Stage stage = (Stage) closeButton.getScene().getWindow();
		  // do what you have to do
		  stage.close();
		}
		
	  @SuppressWarnings("unchecked")
	  @FXML
	    public void clearFields() {
		  emailField.clear();
		  passwordField.clear();
		  selection.setValue(null);
		 
	    }
	 
	  public void registerPage() {
		  Account_Registration ar=new Account_Registration();
		  try {
			ar.register();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failed ot load"+getClass());
		}
	  }
	   
		public void initialize(){
			
	  		if(selection!=null) {
	  		loadSceneAndSendMessage();}
		 }
		
		
		

			@SuppressWarnings("unchecked")
		private void loadSceneAndSendMessage() {
	  		//choices.setItems(choicesList);
	  			selection.setItems(selectionList);
	  	}
	  		
	  	public  void LoginAcc() throws IOException {
	  		String[] record = null;
	  		System.out.println("Email ID");
	  		DaoModel dr = new DaoModel();
	  		String emailOrUsername =emailField.getText();
	  		System.out.println(emailOrUsername);
	  		/*if(selection.getValue()==null){
	  			Alert alert = new Alert(AlertType.ERROR);
	  			alert.setTitle("Error Dialog");
	  			alert.setHeaderText("Look, an Error Dialog");
	  			alert.setContentText("Select Administrator/User");	
	  			alert.showAndWait();
	  			
	  		}*/
	  		 if(!emailOrUsername.isEmpty()) {
	  		    record = dr.retrieveUserRecords(emailOrUsername);
	 
	  		 
	  		System.out.println("Email:"+emailOrUsername);
	  		System.out.println("Password:" + record[1]);
	  		System.out.println("Type:"+ record[2]);
	  		
	  		if(!(passwordField.getText().isEmpty())) {
	  			Password_Hashing passHash=new Password_Hashing();
	  			String encrypTPass=passHash.get_SecurePassword(passwordField.getText());
			if (encrypTPass.equals(record[1])) {

				System.out.println("Password:" + record[1]);

				if (record[2].equals("Administrator")) {
					AdminPageController adm = new AdminPageController();
					adm.adminPageLoad();
				} else if (record[2].equals("User")) {
					Services sc = new Services();
					sc.serviceLoad();
				}

			}
	  		  
	  		  else {
	  			Alert alert = new Alert(AlertType.ERROR);
	  			alert.setTitle("Error Dialog");
	  			alert.setHeaderText("Look, an Error Dialog");
	  			alert.setContentText("Username/Password didn't match");	
	  			alert.showAndWait();
	  		  }
	  		}
	  		else {
	  			Alert alert = new Alert(AlertType.ERROR);
	  			alert.setTitle("Error Dialog");
	  			alert.setHeaderText("Look, an Error Dialog");
	  			alert.setContentText("Please Enter password");	
	  			alert.showAndWait();
	  		}
			 }
	  		 else {
	  			Alert alert = new Alert(AlertType.ERROR);
	  			alert.setTitle("Error Dialog");
	  			alert.setHeaderText("Look, an Error Dialog");
	  			alert.setContentText("Please Enter Valid Email id");	
	  			alert.showAndWait();
	  		 }
	  	}
}
