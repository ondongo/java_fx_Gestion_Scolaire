package java_fx.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import java_fx.core.Fabrique;
import java_fx.entities.Classe;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClasseController implements Initializable{
    @FXML
    TableView<Classe> tblvClasse=new TableView<>();
   
   
    @FXML
    TableColumn<Classe,Integer> tblcid=new TableColumn<>();
    
    @FXML
    TableColumn<Classe,String> tblclibelle=new TableColumn<>();

    @FXML
    TableColumn<Classe,String> tbNiv=new TableColumn<>();

    @FXML
    TableColumn<Classe,String> tbFil=new TableColumn<>();

    @FXML
     TextField txtniveau,txtfiliere;



     @FXML
     ComboBox<Classe> boxFiltre = new ComboBox<>();
    
     private  ObservableList obClasseCharger=FXCollections.observableList(Fabrique.getService().selectAllClasses());

    private  ObservableList obClasses=FXCollections.observableList(Fabrique.getService().selectAllClasses());


    //  événement en java pour récupérer la valeur sélectionnée combobox
     // Ajout d'un événement pour stocker la valeur sélectionnée dans la variable?
    
    




    


    SimpleBooleanProperty smpl=new SimpleBooleanProperty(true);

    @FXML
    Button disparition;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       tblcid.setCellValueFactory(new PropertyValueFactory<>("id"));
       tblclibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));

       tbFil.setCellValueFactory(new PropertyValueFactory<>("filiere"));

       tbNiv.setCellValueFactory(new PropertyValueFactory<>("niveau"));

       tblvClasse.setItems(obClasses);

      


  
 
  
    disparition.setDisable(true);
    txtniveau.textProperty().addListener((obv,oldV,newV)->{
          if(!txtniveau.getText().isEmpty()   ){
            txtfiliere.setDisable(false);
            disparition.setDisable(true);
          }else{
            txtfiliere.setDisable(true);
          }
      });

      txtfiliere.textProperty().addListener((obv,oldV,newV)->{
        if(!txtfiliere.getText().isEmpty()){
            disparition.setDisable(false);
        }
        else{
            disparition.setDisable(true);
          }
 
     });

     boxFiltre.setItems(obClasseCharger);
     
     

     
        
    }




    //----------------------------------Filtre-------------------------
    public void clickBox(){
      String selectedValue = boxFiltre.getSelectionModel().getSelectedItem().toString();
      Classe classe = Fabrique.getService().selectClasseByLibelle(selectedValue);
      obClasses.clear();
      obClasses.add(classe);
      tblvClasse.refresh();
  
      //tblvClasse.setItems(FXCollections.emptyObservableList()); 

      
      



      //Alert alert=new Alert(AlertType.INFORMATION);
      //alert.setContentText(selectedValue);
      //alert.show();
    }












    public void buttonCreerClasse(){
        String niveau=txtniveau.getText().trim();
        String filiere=txtfiliere.getText().trim();
        Classe classe = Fabrique.getService().insertClasse(new Classe(niveau,filiere));
        
        
        Alert alert=new Alert(AlertType.INFORMATION);
        alert.setTitle("Gestion ISM(inscription)");
        alert.setContentText("Une classe a ete cree avec succes");
        alert.show();
        obClasses.add(classe);
        txtniveau.clear();
        txtfiliere.clear();

    }
    
}
