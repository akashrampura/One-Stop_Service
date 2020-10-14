package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import model.DaoModel;

public class PServices{

	
		
		
		public PServices pService;
		public List<PServices> pServiceList=new ArrayList<>();
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
		
		public void loadPServices() throws IOException {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Pservices.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			OSEGMain.commStage.setScene(new Scene(root));
			
			
			 
			  TableView<PServices> tableView=new TableView<PServices>();
			  TableColumn<PServices, String> serviceNameCol = new TableColumn<PServices, String>("Service Name");
			  TableColumn<PServices, Hyperlink> urlCol = new TableColumn<PServices, Hyperlink>("URL");
			  
			
		
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
		        pServiceList=sm.retrievePUrls();
		        
		       ObservableList<PServices> list = getAllServicesList(pServiceList);
		    
		       serviceNameCol.prefWidthProperty().bind(tableView.widthProperty().multiply(0.3));
		       urlCol.prefWidthProperty().bind(tableView.widthProperty().multiply(0.7));
		      
		        tableView.setItems(list);
		        tableView.getColumns().addAll(serviceNameCol,urlCol);
		        
		       // tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		       
		       
		  
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
		public ObservableList<PServices> getAllServicesList(List<PServices> pServiceList2){
			ObservableList<PServices> listD = FXCollections.observableArrayList();
	        final WebView browser = new WebView();
	        final WebEngine webEngine = browser.getEngine();
	        
			for(PServices fgs:pServiceList2) {
				pService=new PServices();
				pService.setServiceName(fgs.getServiceName());
			pService.setUrl(fgs.getUrl());
				
				pService.getUrl().setOnAction(new EventHandler<ActionEvent>() {

	                @Override
	                public void handle(ActionEvent t) {
	                	Stage Stage2=new Stage();
	                	webEngine.load(pService.getUrl().getText());
	                	
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
				listD.add(pService);
	        	
	        }
			
			
			
	 	   return listD;
	    }
	
		public void logout() throws IOException {
			System.out.println("Button is clicked");
			Logout lg=new Logout();
			lg.logout();
		}
		
		public void backP() throws IOException{
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ServiceSelectionHeader.fxml"));
			Parent root = loader.load();
			OSEGMain.commStage.setScene(new Scene(root));
			OSEGMain.commStage.setTitle("Service Header");
			OSEGMain.commStage.show();
}
}
