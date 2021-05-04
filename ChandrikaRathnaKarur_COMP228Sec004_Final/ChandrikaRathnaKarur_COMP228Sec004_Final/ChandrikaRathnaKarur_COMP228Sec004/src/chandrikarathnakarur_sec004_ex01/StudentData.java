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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentData implements Initializable//controller class 
{
// JDBC driver name and database URL                              
static final String DRIVER = "oracle.jdbc.OracleDriver";             
static final String DATABASE_URL = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD";
String query;
int numberOfColumns;
Connection connection = null; // manages connection
Statement statement = null; // query statement
ResultSet resultSet = null; // manages results

@FXML
private TextField searchCityName;

@FXML
private Button searchQuery;


@FXML
private TableView<studentDataSet> studentDataTable;

@FXML
private TableColumn<studentDataSet, String> StudentID;

@FXML
private TableColumn<studentDataSet, String> FirstName;

@FXML
private TableColumn<studentDataSet, String> LastName;

@FXML
private TableColumn<studentDataSet, String> Address;

@FXML
private TableColumn<studentDataSet, String> City;

@FXML
private TableColumn<studentDataSet, String> Province;

@FXML
private TableColumn<studentDataSet, String> PostalCode;

ObservableList<studentDataSet> result_list = FXCollections.observableArrayList();


// launch the application
@FXML
void getAndPutResults(ActionEvent event)
{
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
      
      if (searchCityName.getText().equals("")) 
         query = "SELECT * FROM Students";
      else
         query = "SELECT * FROM Students where city='"+searchCityName.getText()+"'";
      // query database                                        
      resultSet = statement.executeQuery(query);
      
	 System.out.printf("\nExecuted with %s\n", searchCityName.getText());
     result_list.clear();

      while ( resultSet.next() ) 
      {
  	    result_list.add(new studentDataSet((String) resultSet.getObject(1), (String) resultSet.getObject(2), (String) resultSet.getObject(3), (String) resultSet.getObject(4), (String) resultSet.getObject(5), (String) resultSet.getObject(6), (String) resultSet.getObject(7)));
  	    //System.out.print(result_list);
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
         resultSet.close();                                      
         statement.close();                                      
         connection.close();     
      } // end try                                               
      catch ( Exception exception )                              
      {                                                          
         exception.printStackTrace();                            
      } // end catch                                             
   } // end finally 
  }//end of action event handler


@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	StudentID.setCellValueFactory(new PropertyValueFactory<studentDataSet, String> ("StudentID"));
	FirstName.setCellValueFactory(new PropertyValueFactory<studentDataSet, String> ("FirstName"));
	LastName.setCellValueFactory(new PropertyValueFactory<studentDataSet, String> ("LastName"));
	Address.setCellValueFactory(new PropertyValueFactory<studentDataSet, String> ("Address"));
	City.setCellValueFactory(new PropertyValueFactory<studentDataSet, String> ("City"));
	Province.setCellValueFactory(new PropertyValueFactory<studentDataSet, String> ("Province"));
	PostalCode.setCellValueFactory(new PropertyValueFactory<studentDataSet, String> ("PostalCode"));
	
    studentDataTable.setItems(result_list);

}
} // end class StudentData





