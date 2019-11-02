/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2605assignment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jihanbing
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:petsDatabase.db");
        Statement st = conn.createStatement();
        String createTableSql = "CREATE TABLE IF NOT EXISTS Activities "
                + "(ID INTEGER PRIMARY KEY autoincrement, "
                + "NAME TEXT NOT NULL, "
                + "PHONE TEXT NOT NULL,"
                + "CATEGORY TEXT NOT NULL, "
                + "COLOUR TEXT NOT NULL, "   
                + "DATETIME TEXT NOT NULL,"
                + "DESCRIPTION TEXT NOT NULL"
                +");";
        st.execute(createTableSql);  
            
        st.close();
        conn.close();
        System.out.println("Successful");
        launch(args);
    }
    
}
