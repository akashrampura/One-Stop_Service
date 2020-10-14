package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Window;
import model.DaoModel;

public class Account_Registration {

    private String name;
    private String email;
    private String passWord;
    private String typeOfUser;
    private String loginDate;
    public List<Account_Registration> regList=new ArrayList<>();
    public Account_Registration accReg;
    
    public void register() throws Exception {
    	//Stage primaryStage=new Stage();
    	OSEGMain.commStage.setTitle("Registration Form");

        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 800, 500);
        // Set the scene in primary stage	
        OSEGMain.commStage.setScene(scene);
        
        OSEGMain.commStage.show();
    }


    private GridPane createRegistrationFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(150, 150, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) throws ParseException {
    	
        // Add Header
        Label headerLabel = new Label("Registration Form");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Name Label
        Label nameLabel = new Label("Full Name : ");
        gridPane.add(nameLabel, 0,1);

        // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1,1);


        // Add Email Label
        Label emailLabel = new Label("Email ID : ");
        gridPane.add(emailLabel, 0, 2);
     
        // Add Email Text Field
        TextField emailField = new TextField();
        emailField.setPrefHeight(40);
        gridPane.add(emailField, 1, 2);

        // Add Password Label
        Label passwordLabel = new Label("Password : ");
        gridPane.add(passwordLabel, 0, 3);

        // Add Password Field
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        gridPane.add(passwordField, 1, 3);
        

        // Add Confirm Password Label
        Label confirmPasswordLabel = new Label("Confirm Password : ");
        gridPane.add(confirmPasswordLabel, 0, 4);

        // Add Password Field
        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPrefHeight(40);
        gridPane.add(confirmPasswordField, 1, 4);
        
        // Add Type Label
        Label typeLabel = new Label("Register As : ");
        gridPane.add(typeLabel, 0, 5);

        // Add Radio Field
        final ToggleGroup tg=new ToggleGroup();
        RadioButton rblA=new RadioButton("Administrator");
        rblA.setToggleGroup(tg);
        rblA.setSelected(true);
        rblA.setFocusTraversable(true);
        rblA.setUserData("Administrator");
        gridPane.add(rblA, 1, 5);
        
        
        RadioButton rblU=new RadioButton("User");
        rblU.setToggleGroup(tg);
        gridPane.add(rblU, 1,6);
        rblU.setUserData("User");
        
        // Add Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setPrefHeight(40);
        submitButton.setPrefWidth(100);
        
        Button cancelButton = new Button("Cancel");
        cancelButton.setPrefHeight(40);
        cancelButton.setPrefWidth(100);
        
        gridPane.add(submitButton, 1, 7, 2, 1);
        gridPane.add(cancelButton, 0, 7, 2, 1);
       
        GridPane.setHalignment(submitButton, HPos.LEFT);
        GridPane.setHalignment(cancelButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
			boolean successSer=false;
			String encryptPass;
		

		    
		    @Override
		    public void handle(ActionEvent event) {
		        if(nameField.getText().isEmpty()) {
		            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your name");
		            return;
		        }
		        if(emailField.getText().isEmpty()) {
		            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your email id");
		            return;
		        }
		        if(passwordField.getText().isEmpty()) {
		            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a password");
		            return;
		        }
		        if(confirmPasswordField.getText().isEmpty()) {
		            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a Confirm password");
		            return;
		        }
		        if(!confirmPasswordField.getText().equals(passwordField.getText())) {
		            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Passwords donot match");
		            return;
		        }
		        
		        if(!(nameField.getText().isEmpty()) && !(emailField.getText().isEmpty()) && !(passwordField.getText().isEmpty()) && !(confirmPasswordField.getText().isEmpty())) {
		        	Password_Hashing passHash=new Password_Hashing();
		  			try {
						 encryptPass=passHash.get_SecurePassword(passwordField.getText());
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        	accReg=new Account_Registration();
		        	accReg.setName(nameField.getText());
		        	accReg.setEmail(emailField.getText());
		        	accReg.setPassWord(encryptPass);
		        	accReg.setTypeOfUser(tg.getSelectedToggle().getUserData().toString());
		   
		        	System.out.println("Name:"+accReg.getName());
		        	System.out.println("Email:"+accReg.getEmail());
		        	System.out.println("Password:"+accReg.getPassWord());
		        	System.out.println("Type:"+accReg.getTypeOfUser());
		        	regList.add(accReg);
		        	DaoModel dm=new DaoModel();
		        	try {
					successSer=dm.insertRecords(regList);
					if(successSer) {
						//Stage primaryStage=new Stage();
						OSEGMain.commStage.setTitle("Success");

				        // Create the registration form grid pane
				        GridPane gridPane = createRegistrationFormPane();
				        // Add UI controls to the registration form grid pane
				        addSuccess(gridPane);
				        
				        // Create a scene with registration form grid pane as the root node
				        Scene scene = new Scene(gridPane, 800, 500);
				        // Set the scene in primary stage	
				        OSEGMain.commStage.setScene(scene);
				        
				        OSEGMain.commStage.show();
					}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	
		        }
		        
		       // showAlert(Alert.AlertType.INFORMATION, gridPane.getScene().getWindow(), "Registration Successful!", "Welcome " + nameField.getText());
		   
		    }
		});
   
    //
       

        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
        	
            @Override
            public void handle(ActionEvent event) {
            	Logout lg=new Logout();
        		try {
					lg.logout();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	}
            }
        );
    	
    }

   


	private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    private void addSuccess(GridPane gridPane) {
    	Label headerLabel = new Label("Your Registration is successfull");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));
        
        Button submitButton = new Button("Login");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 6, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
        	
            @Override
            public void handle(ActionEvent event) {
            	Logout lg=new Logout();
        		try {
					lg.logout();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	}
            }
        );
    }
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public String getTypeOfUser() {
		return typeOfUser;
	}


	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}


	public String getLoginDate() {
		return loginDate;
	}


	public void setLoginDate(String today) {
		this.loginDate = today;
	}

}