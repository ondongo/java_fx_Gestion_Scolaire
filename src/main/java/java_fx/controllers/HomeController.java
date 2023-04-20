package java_fx.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



import java_fx.App;
import java_fx.entities.RoleUsers;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class HomeController implements Initializable{

  
    

    
    public void buttonDeconnexion() throws IOException{
    
    App.setRoot("connect");

    }


    @FXML
    AnchorPane AnchorContent;
    
    
    @FXML
    Button btnmenuAC;

    @FXML
    Button btnmenuRP1;

    @FXML
     Button btnmenuRP2;

    public void buttonVueClasse() throws IOException{
        this.loadView("classe");
      

    }


    public void buttonVueEtudiant() throws IOException{
        this.loadView("etudiant");
    
    }



    public void buttonVueProf() throws IOException{
        this.loadView("professeur");
    
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
           
            if(ConnectController.user.getRoleUsers()==RoleUsers.RP) {
                isRp();
                this.loadView("classe");    
        
          }

          else{

            isAc();
          
          }

            
           
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
   

    private void  loadView(String fxml) throws IOException{
        AnchorPane root =(AnchorPane) App.loadFXML(fxml);
        AnchorContent.getChildren().clear();
        AnchorContent.getChildren().add(root);
    }



    //----------------------------- verification du user-----------------------------------
    public void isRp(){

        btnmenuRP1.setDisable(false);
        btnmenuRP2.setDisable(false);
    }

    public void isAc(){
        btnmenuAC.setDisable(false);
    }
}
