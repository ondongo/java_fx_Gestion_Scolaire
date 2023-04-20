package java_fx.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;




import java_fx.App;
import java_fx.core.Fabrique;
import java_fx.core.Validator;
import java_fx.entities.UsersAdmin;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;




public class ConnectController implements Initializable{



    @FXML
    Text lblError,errorLogin,errorPassword;

    @FXML
    TextField txtlogin;
    
    @FXML
    PasswordField txtpassword;

    @FXML
    Button btnconnexion;


         //Observable
         SimpleBooleanProperty smpl=new SimpleBooleanProperty(true);

    public  static  UsersAdmin user;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblError.setVisible(false);
        errorLogin.setVisible(false);
        errorPassword.setVisible(false);


        // old==> valeur avant de taper au clavier et newV===> valeur après avoir taper
        txtlogin.textProperty().addListener((obv,old,newV)->{


            if(newV.isEmpty()){


                errorLogin.setVisible(true);

            }else{
                if(!Validator.isEmail(newV)){
                    errorLogin.setText("veuillez saisir un email");
                    errorLogin.setVisible(true);
                }else{
                    smpl.set(txtpassword.getText().isEmpty() );
                    errorLogin.setVisible(false);
                } 
            }
        });



        txtpassword.textProperty().addListener((obv,old,newV)->{
            if(newV.isEmpty()){
                errorPassword.setVisible(true);
            }else{
                  smpl.set(!Validator.isEmail(txtlogin.getText()));
                  errorPassword.setVisible(false);  
            }
        });
        
        btnconnexion.disableProperty().bind(smpl);
    }

    public void boutonConnexion() throws IOException{
        String login =txtlogin.getText().trim(); 
        String password =txtpassword.getText().trim();
        // lblError.setVisible(true);
       user=Fabrique.getService().connexion(login, password);

        if(user==null){
            lblError.setVisible(true);  
        }else{
            lblError.setVisible(false);
            App.setRoot("gloire");

        
        }

    }
}