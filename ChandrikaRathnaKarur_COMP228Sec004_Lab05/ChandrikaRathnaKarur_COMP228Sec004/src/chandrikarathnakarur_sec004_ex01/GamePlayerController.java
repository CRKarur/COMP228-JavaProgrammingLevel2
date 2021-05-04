package chandrikarathnakarur_sec004_ex01;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class GamePlayerController implements Initializable//controller class 
{
// JDBC driver name and database URL                              
static final String DRIVER = "oracle.jdbc.OracleDriver";             
static final String DATABASE_URL = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD";
String query, query1;
int numberOfColumns;
Connection connection = null; // manages connection
Statement statement = null; // query statement
ResultSet game_resultSet = null; // manages results
ResultSet game_resultSet2 = null; // manages results

@FXML
private TextField gameGameID;

@FXML
private TextField gameGameName;

@FXML
private Label gameMessage;

@FXML
private Button gameSubmitbtn;

@FXML
private Button gameSearchbtn;

@FXML
private Button gameGameDisplaybtn;

@FXML
private Button gameUpdatebtn;

@FXML
private TableView<GameData> DisplayGameData;

@FXML
private TableColumn<GameData, String> gameColGameID;

@FXML
private TableColumn<GameData, String> gameColGameName;

ObservableList<GameData> game_result_list = FXCollections.observableArrayList();

//launch application for game data

@FXML
void getGameData(ActionEvent event) {

	// connect to database books and query database
	   try 
	   {
	      // load the driver class
	      Class.forName( DRIVER );

	      // establish connection to database                              
	      connection =                                                     
	         DriverManager.getConnection( DATABASE_URL, "comp214_f20_160", "password" );

	      // create Statement for querying database
	      statement = connection.createStatement();
	      
	      query = "INSERT INTO GAME Values(game_id_seq.nextval,'"+gameGameName.getText()+"')";
	      query1="SELECT * FROM GAME";
	      // query database                                        
	      game_resultSet2 = statement.executeQuery(query);
	      
	      //DisplayGameData.refresh();
	      game_resultSet = statement.executeQuery(query1);
	      
		 //System.out.printf("\nExecuted with Insert for game %s\n", gameGameName.getText());

	     game_result_list.clear();

	      while ( game_resultSet.next() ) 
	      {
	 		// System.out.printf("\n game_resultSet is %s\n", (String) game_resultSet.getObject(1));
	 		 //System.out.printf("\n game_resultSet is %s\n", (String) game_resultSet.getObject(2));

	  	    game_result_list.add(new GameData((String)game_resultSet.getObject(1), (String) game_resultSet.getObject(2)));
	  	   // System.out.print(game_result_list);
	      } // end while
	      
	   }  // end try
	   
	   catch ( SQLException sqlException )                                
	   {                                                                  
	      sqlException.printStackTrace();
	   } // end catch                                                     
	   catch ( ClassNotFoundException classNotFound )                     
	   {                                                                  
	      classNotFound.printStackTrace();            
	   } // end catch                                                     
	   finally // ensure resultSet, statement and connection are closed
	   {                                                             
	      try                                                        
	      {                                                          
	         game_resultSet.close();                                      
	         statement.close();                                      
	         connection.close();     
	      } // end try                                               
	      catch ( Exception exception )                              
	      {                                                          
	         exception.printStackTrace();                            
	      } // end catch                                             
	   } // end finally 
	
}


@FXML
public void updateGameData(CellEditEvent<GameData, String> editedcell){

	// connect to database books and query database
	   try 
	   {
		  //ObservableList<GameData> editGameData = FXCollections.observableArrayList();
		  GameData SelectedGameData = DisplayGameData.getSelectionModel().getSelectedItem();
		  
		  //editGameData=DisplayGameData.getSelectionModel().getSelectedItems();
	  	  //System.out.printf("\nDisplayGameData\n");

	  	 // System.out.print(SelectedGameData.gameName);
	  	  
	  	  SelectedGameData.setGameName(editedcell.getNewValue());
		  
	  	 // System.out.print(SelectedGameData.gameName);

	  	  //System.out.printf("\n%s\n", editGameData.get(1).toString());
	  	  //System.out.printf("\n%s\n", editGameData.get(2).toString());

		 // load the driver class
	      Class.forName( DRIVER );

	      // establish connection to database                              
	      connection =                                                     
	         DriverManager.getConnection( DATABASE_URL, "comp214_f20_160", "password" );

	      // create Statement for querying database
	      statement = connection.createStatement();
	   
	      query = "UPDATE GAME SET game_name='"+SelectedGameData.getGameName()+"' WHERE game_id='"+SelectedGameData.getGameID()+"'";
	     // System.out.printf(query);
	      
	      query1="SELECT * FROM GAME";
	      // query database                                        
	      game_resultSet2 = statement.executeQuery(query);
	      game_resultSet = statement.executeQuery(query1);
	      
		// System.out.printf("\nExecuted with Insert for game %s\n", gameGameName.getText());

	     game_result_list.clear();

	      while ( game_resultSet.next() ) 
	      {
	 		// System.out.printf("\n game_resultSet is %s\n", (String) game_resultSet.getObject(1));
	 		 //System.out.printf("\n game_resultSet is %s\n", (String) game_resultSet.getObject(2));

	  	    game_result_list.add(new GameData((String)game_resultSet.getObject(1), (String) game_resultSet.getObject(2)));
	  	    //System.out.print(game_result_list);
	      } // end while
	     
	   }  // end try
	   catch ( SQLException sqlException )                                
	   {                                                                  
	      sqlException.printStackTrace();
	   } // end catch                                                     
	   catch ( ClassNotFoundException classNotFound )                     
	   {                                                                  
	      classNotFound.printStackTrace();            
	   } // end catch                                                     
	   finally // ensure resultSet, statement and connection are closed
	   {                                                             
	      try                                                        
	      {                                                          
	         game_resultSet.close();                                      
	         statement.close();                                      
	         connection.close();     
	      } // end try                                               
	      catch ( Exception exception )                              
	      {                                                          
	         exception.printStackTrace();                            
	      } // end catch                                             
	   } // end finally 
	
}

//player tab



@FXML
private TextField playerFirstName;

@FXML
private TextField playerLastName;

@FXML
private TextField playerPostalCode;

@FXML
private TextField playerAddress;

@FXML
private TextField playerProvince;

@FXML
private TextField playerPhone;

@FXML
private Button btnPlayerInsert;

@FXML
private TableView<PlayerData> displayPlayerData;

@FXML
private TableColumn<PlayerData, String> colPlayerID;

@FXML
private TableColumn<PlayerData, String> colPlayerFirstName;

@FXML
private TableColumn<PlayerData, String> colPlayerLastName;

@FXML
private TableColumn<PlayerData, String> colPlayerAddress;

@FXML
private TableColumn<PlayerData, String> colPostalCode;

@FXML
private TableColumn<PlayerData, String> colPlayerProvince;

@FXML
private TableColumn<PlayerData, String> colPhoneNumber;

ResultSet player_resultSet=null; 
ResultSet player_resultSet2=null; 
ObservableList<PlayerData> player_result_list = FXCollections.observableArrayList();

@FXML
void getPlayerData(ActionEvent event) {
	try 
	   {
	      // load the driver class
	      Class.forName( DRIVER );

	      // establish connection to database                              
	      connection = DriverManager.getConnection( DATABASE_URL, "comp214_f20_160", "password" );

	      // create Statement for querying database
	      statement = connection.createStatement();
	      
	      query = "INSERT INTO PLAYER VALUES(player_id_seq.nextval,'"+playerFirstName.getText()+"','"+playerLastName.getText()+"','"+playerAddress.getText()+"','"+playerPostalCode.getText()+"','"+playerProvince.getText()+"','"+playerPhone.getText()+"')";
	      query1="SELECT * FROM PLAYER";
	      // query database                                        
	      player_resultSet2 = statement.executeQuery(query);
	     
	      player_resultSet = statement.executeQuery(query1);
	      
	      player_result_list.clear();

	      while ( player_resultSet.next() ) 
	      {
	 		 System.out.printf("\n player_resultSet is %s\n", (String) player_resultSet.getObject(1));
	 		 System.out.printf("\n player_resultSet is %s\n", (String) player_resultSet.getObject(2));

	 		 player_result_list.add(new PlayerData((String)player_resultSet.getObject(1), (String) player_resultSet.getObject(2), (String) player_resultSet.getObject(3), (String) player_resultSet.getObject(4), (String) player_resultSet.getObject(5), (String) player_resultSet.getObject(6), (String) player_resultSet.getObject(7)));
	  	    System.out.print(player_result_list);
	      } // end while
	     
	      
	   }  // end try
	   
	   catch ( SQLException sqlException )                                
	   {                                                                  
	      sqlException.printStackTrace();
	   } // end catch                                                     
	   catch ( ClassNotFoundException classNotFound )                     
	   {                                                                  
	      classNotFound.printStackTrace();            
	   } // end catch                                                     
	   finally // ensure resultSet, statement and connection are closed
	   {                                                             
	      try                                                        
	      {                                                          
	    	  player_resultSet.close();                                      
	         statement.close();                                      
	         connection.close();     
	      } // end try                                               
	      catch ( Exception exception )                              
	      {                                                          
	         exception.printStackTrace();                            
	      } // end catch                                             
	   } // end finally 
	

}

@FXML
void updatePlayerData(CellEditEvent<PlayerData, String> editedcell) {
	// connect to database books and query database
	   try 
	   {
		  //ObservableList<GameData> editGameData = FXCollections.observableArrayList();
		  PlayerData SelectedPlayerData = displayPlayerData.getSelectionModel().getSelectedItem();
		  
		  //editGameData=DisplayGameData.getSelectionModel().getSelectedItems();
	  	  System.out.printf("\nDisplayPlayerData\n");

	  	  System.out.print(SelectedPlayerData.firstName);
	  	  

	  	  //System.out.printf("\n%s\n", editGameData.get(1).toString());
	  	  //System.out.printf("\n%s\n", editGameData.get(2).toString());

		 // load the driver class
	      Class.forName( DRIVER );

	      // establish connection to database                              
	      connection =                                                     
	         DriverManager.getConnection( DATABASE_URL, "comp214_f20_160", "password" );

	      // create Statement for querying database
	      statement = connection.createStatement();
	      
	      query="UPDATE PLAYER SET ";
	   
	  	  if(editedcell.getTableColumn().toString().matches("colPlayerFirstName"))
	  	  	{
	  	  	SelectedPlayerData.setFirstName(editedcell.getNewValue());
	  	  	query=query+"first_name='"+SelectedPlayerData.getFirstName();
	  	  	}
	  	  if(editedcell.getTableColumn().toString().matches("colPlayerLastName"))
	  	  	{
	    	  SelectedPlayerData.setPhoneNumber(editedcell.getNewValue());
	    	  query=query+"last_name='"+SelectedPlayerData.getLastName();
	  	  	}
	      if(editedcell.getTableColumn().toString().matches("colPlayerAddress"))
	  	  	{
		  	SelectedPlayerData.setLastName(editedcell.getNewValue());
		  	query=query+"address='"+SelectedPlayerData.getAddress();
	  	  	}
	      
	      if(editedcell.getTableColumn().toString().matches("colPlayerAddress"))
	  	  	{
	    	  SelectedPlayerData.setAddress(editedcell.getNewValue());
	    	  query=query+"postal_code='"+SelectedPlayerData.getPostalCode();
	  	  	}
	      if(editedcell.getTableColumn().toString().matches("colPlayerPostalCode"))
	  	  	{
	    	  SelectedPlayerData.setPostalCode(editedcell.getNewValue());
	    	  query=query+"province='"+SelectedPlayerData.getProvince();
	  	  	}
	      if(editedcell.getTableColumn().toString().matches("colPlayerProvince"))
	  	  	{
	    	  SelectedPlayerData.setProvince(editedcell.getNewValue());
	    	  query=query+"phone_number='"+SelectedPlayerData.getPhoneNumber();
	  	  	}
	      
		  	
	      query=query+"' WHERE player_id='"+SelectedPlayerData.getPlayerID()+"'";
	  	  
	      System.out.printf(query);
	      
	      query1="SELECT * FROM PLAYER";
	      // query database                                        
	      game_resultSet2 = statement.executeQuery(query);
	      game_resultSet = statement.executeQuery(query1);
	      
		 System.out.printf("\nExecuted with Insert for game %s\n", gameGameName.getText());

	     player_result_list.clear();

	      while ( player_resultSet.next() ) 
	      {
	 		 System.out.printf("\n player_resultSet is %s\n", (String) player_resultSet.getObject(1));
	 		 System.out.printf("\n player_resultSet is %s\n", (String) player_resultSet.getObject(2));

	 		 player_result_list.add(new PlayerData((String)player_resultSet.getObject(1), (String) player_resultSet.getObject(2), (String) player_resultSet.getObject(3), (String) player_resultSet.getObject(4), (String) player_resultSet.getObject(5), (String) player_resultSet.getObject(6), (String) player_resultSet.getObject(7)));
	  	    System.out.print(player_result_list);
	      } // end while
	     
	   }  // end try
	   catch ( SQLException sqlException )                                
	   {                                                                  
	      sqlException.printStackTrace();
	   } // end catch                                                     
	   catch ( ClassNotFoundException classNotFound )                     
	   {                                                                  
	      classNotFound.printStackTrace();            
	   } // end catch                                                     
	   finally // ensure resultSet, statement and connection are closed
	   {                                                             
	      try                                                        
	      {                                                          
	         player_resultSet.close();
	         statement.close();                                      
	         connection.close();     
	      } // end try                                               
	      catch ( Exception exception )                              
	      {                                                          
	         exception.printStackTrace();                            
	      } // end catch                                             
	   } // end finally 
	

}

@FXML
private AnchorPane gameTab;
@FXML
private AnchorPane playerTab;

//tables
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	
	try {
		
		//if(gameTab.isFocused())
		//{
		 // load the driver class
	      Class.forName( DRIVER );

	      // establish connection to database                              
	      connection =                                                     
	         DriverManager.getConnection( DATABASE_URL, "comp214_f20_160", "password" );

	      // create Statement for querying database
	      statement = connection.createStatement();
	     
	    //game tab
	      //query1="SELECT * FROM GAME";
	      game_resultSet = statement.executeQuery("SELECT * FROM GAME");
	      
	      game_result_list.clear();

	      while ( game_resultSet.next() ) 
	      {
	 		 //System.out.printf("\n game_resultSet is %s\n", (String) game_resultSet.getObject(1));
	 		// System.out.printf("\n game_resultSet is %s\n", (String) game_resultSet.getObject(2));

	  	    game_result_list.add(new GameData((String)game_resultSet.getObject(1), (String) game_resultSet.getObject(2)));
	  	   // System.out.print(game_result_list);
	      } // end while
	      
	      gameColGameID.setCellValueFactory(new PropertyValueFactory<GameData, String> ("gameID"));
	      gameColGameName.setCellValueFactory(new PropertyValueFactory<GameData, String> ("gameName"));
	
	      DisplayGameData.setItems(game_result_list);
	
	      DisplayGameData.setEditable(true);
	      gameColGameName.setCellFactory(TextFieldTableCell.forTableColumn());
		//}//end of if game tab
	//player tab
	//	if(playerTab.isFocused())
		//{
	    	displayPlayerData.refresh();
	      player_resultSet = statement.executeQuery("SELECT * FROM PLAYER");
	      
		 System.out.printf("\nExecuted with Insert for player %s\n", playerFirstName.getText());

	     player_result_list.clear();

	      while ( player_resultSet.next() ) 
	      {
	 		 System.out.printf("\n player_resultSet is %s\n", (String) player_resultSet.getObject(1));
	 		 System.out.printf("\n player_resultSet is %s\n", (String) player_resultSet.getObject(2));

	  	    player_result_list.add(new PlayerData((String)player_resultSet.getObject(1), (String) player_resultSet.getObject(2), (String) player_resultSet.getObject(3), (String) player_resultSet.getObject(4), (String) player_resultSet.getObject(5), (String) player_resultSet.getObject(6), (String) player_resultSet.getObject(7)));
	  	    System.out.print(player_result_list);
	      } // end while
	      
	      
	      colPlayerID.setCellValueFactory(new PropertyValueFactory<PlayerData, String> ("playerID"));
	      colPlayerFirstName.setCellValueFactory(new PropertyValueFactory<PlayerData, String> ("firstName"));
	      colPlayerLastName.setCellValueFactory(new PropertyValueFactory<PlayerData, String> ("lastName"));
	      colPlayerAddress.setCellValueFactory(new PropertyValueFactory<PlayerData, String> ("address"));
	      colPostalCode.setCellValueFactory(new PropertyValueFactory<PlayerData, String> ("postalCode"));
	      colPlayerProvince.setCellValueFactory(new PropertyValueFactory<PlayerData, String> ("province"));
	      colPhoneNumber.setCellValueFactory(new PropertyValueFactory<PlayerData, String> ("postalCode"));
	      
	      displayPlayerData.setItems(player_result_list);
	
	      displayPlayerData.setEditable(true);
	      colPlayerFirstName.setCellFactory(TextFieldTableCell.forTableColumn());
	      colPlayerLastName.setCellFactory(TextFieldTableCell.forTableColumn());
	      colPlayerAddress.setCellFactory(TextFieldTableCell.forTableColumn());
	      colPostalCode.setCellFactory(TextFieldTableCell.forTableColumn());
	      colPlayerProvince.setCellFactory(TextFieldTableCell.forTableColumn());
	      colPhoneNumber.setCellFactory(TextFieldTableCell.forTableColumn());
//		} //end of if for player tab 
	 //Player and Game Tab
	      
	      
	      
	}//end of try block
	catch ( SQLException sqlException )                                
	   {                                                                  
	      sqlException.printStackTrace();
	   } // end catch                                                     
	   catch ( ClassNotFoundException classNotFound )                     
	   {                                                                  
	      classNotFound.printStackTrace();            
	   } // end catch                                                     
	   finally // ensure resultSet, statement and connection are closed
	   {                                                             
	      try                                                        
	      {                                                          
	         game_resultSet.close();
	         player_resultSet.close();
	         statement.close();                                      
	         connection.close();     
	      } // end try                                               
	      catch ( Exception exception )                              
	      {                                                          
	         exception.printStackTrace();                            
	      } // end catch                                             
	   } // end finally 
}
} // end class GamePlayerCOntroller