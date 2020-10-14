package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;




import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import model.DaoModel;

public class FGServices{
	public FGServices fgService;
	public List<FGServices> fgServiceList=new ArrayList<>();
	private String serviceType;
	private String serviceName;
	private Hyperlink url;
	List<Hyperlink> links = new ArrayList<>();
	List<String> serNameList= new ArrayList<>();
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

	public Hyperlink getUrl() {
		return url;
	}

	public void setUrl(Hyperlink url) {
		this.url = url;
	}

	@SuppressWarnings("rawtypes")
	@FXML
	private ChoiceBox serviceSelect;
	  @SuppressWarnings("rawtypes")
	final ListView listView = new ListView();
	
	public void loadFgServices() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FGServices.fxml"));
		AnchorPane root = (AnchorPane)loader.load();
		OSEGMain.commStage.setScene(new Scene(root));
		
		
		 
		  TableView<FGServices> tableView=new TableView<FGServices>();
		  TableColumn<FGServices, String> serviceNameCol = new TableColumn<FGServices, String>("Service Name");
		  TableColumn<FGServices, Hyperlink> urlCol = new TableColumn<FGServices, Hyperlink>("URL");
		  
		
	
		  serviceNameCol.setCellValueFactory(new PropertyValueFactory<>("serviceName"));
		  urlCol.setCellValueFactory(new PropertyValueFactory<>("url"));
		  
	        AnchorPane pane = new AnchorPane();
	        pane.setLayoutX(20.0);
	        pane.setLayoutY(115.0);
	        pane.setPrefWidth(650.0);
	        pane.setPrefHeight(500.0);

	        VBox vBox = new VBox();
	     //   final Hyperlink link = new Hyperlink("http://blog.professional-webworkx.de");
	    //    Hyperlink link2= new Hyperlink("http://www.stackoverflow.com");
	        vBox.setPrefWidth(650);
	        vBox.setPrefHeight(500.0);
	        
	        DaoModel sm=new DaoModel();
	        fgServiceList=sm.retrieveFGUrls();
	        
	       ObservableList<FGServices> list = getAllServicesList(fgServiceList);
	    
	       serviceNameCol.prefWidthProperty().bind(tableView.widthProperty().multiply(0.3));
	       urlCol.prefWidthProperty().bind(tableView.widthProperty().multiply(0.7));
	      
	        tableView.setItems(list);
	        tableView.getColumns().addAll(serviceNameCol,urlCol);
	        
	       // tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	       
	        final WebView browser = new WebView();
	        final WebEngine webEngine = browser.getEngine();
	        
	        /*for(final Hyperlink hyperlink : links) {
	            hyperlink.setOnAction(new EventHandler<ActionEvent>() {

	                @Override
	                public void handle(ActionEvent t) {
	                	Stage Stage2=new Stage();
	                	webEngine.load(hyperlink.getText());
	                	
	                	AnchorPane ap2=new AnchorPane();
	                	
	                	ap2.getChildren().addAll(browser);
	        	       Scene scene2 = new Scene(ap2);
	        	       Stage2.setTitle("Government Services");
	        		   // UserLoginManager loginManager = new UserLoginManager(scene);
	        		    //loginManager.showLoginScreen();

	        	       Stage2.setScene(scene2);
	        	       Stage2.show();
	        			
	        			OSEGMain.commStage.show();
	                    //getHostServices().showDocument(hyperlink.getText());
	                }
	            });
	        }*/
	       // listView.getItems().addAll(serNameList);
	        
	     //  listView.getItems().addAll(links);
	       /* HBox hBox = new HBox();
	        final TextField urlField = new TextField();
	        Button b = new Button("Add Links");
	        hBox.getChildren().addAll(b, urlField);

	        b.setOnAction(new EventHandler<ActionEvent>() {

	            @Override
	            public void handle(ActionEvent t) {
	                addLink(urlField.getText().trim());
	                urlField.clear();
	            }
	        });
	        vBox.getChildren().add(hBox);*/
	        vBox.getChildren().add(tableView);
	        pane.getChildren().addAll(vBox);
	    //    Scene scene = new Scene(pane, 800, 600);
	        root.getChildren().addAll(pane);
	        
	        OSEGMain.commStage.setTitle("Services");
			OSEGMain.commStage.show();
	  //      primaryStage.setTitle("Hello World!");
	    //    primaryStage.setScene(scene);
	      //  primaryStage.show();
		
		
		///////////
		
	}
	public ObservableList<FGServices> getAllServicesList(List<FGServices> fgServiceList2){
		ObservableList<FGServices> listD = FXCollections.observableArrayList();
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        
		for(FGServices fgs:fgServiceList2) {
			fgService=new FGServices();
			fgService.setServiceName(fgs.getServiceName());
		fgService.setUrl(fgs.getUrl());
			
			fgService.getUrl().setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                	Stage Stage2=new Stage();
                	webEngine.load(fgService.getUrl().getText());
                	
                	AnchorPane ap2=new AnchorPane();
                	
                	ap2.getChildren().addAll(browser);
        	       Scene scene2 = new Scene(ap2);
        	       Stage2.setTitle("Government Services");
        		   // UserLoginManager loginManager = new UserLoginManager(scene);
        		    //loginManager.showLoginScreen();

        	       Stage2.setScene(scene2);
        	       Stage2.show();
        			
        			OSEGMain.commStage.show();
                    //getHostServices().showDocument(hyperlink.getText());
                }
            });
        	//links.add(new Hyperlink(fgs.getUrl()));
        //	serNameList.add(fgs.getServiceName());
			listD.add(fgService);
        	
        }
		
		
		
 	   return listD;
    }

	public void logout() throws IOException {
		System.out.println("Button is clicked");
		Logout lg=new Logout();
		lg.logout();
	}
	
	public void backFG() throws IOException{
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ServiceSelectionHeader.fxml"));
		Parent root = loader.load();
		OSEGMain.commStage.setScene(new Scene(root));
		OSEGMain.commStage.setTitle("Service Header");
		OSEGMain.commStage.show();
	}
	 	
}