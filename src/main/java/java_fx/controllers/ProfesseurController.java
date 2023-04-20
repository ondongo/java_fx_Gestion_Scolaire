package java_fx.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import java_fx.core.Fabrique;
import java_fx.entities.Classe;
import java_fx.entities.Professeur;
import java_fx.entities.Utilisateurs;
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
import javafx.scene.layout.Pane;

public class ProfesseurController implements Initializable{

    @FXML
    TableView<Utilisateurs> tbprof=new TableView<>();
    
    @FXML 
    TableColumn<Utilisateurs,Integer> tcprofid=new TableColumn<>();


    @FXML 
    TableColumn<Utilisateurs,String> tcprofnci=new TableColumn<>();
    
    @FXML
    TableColumn<Utilisateurs,String> tcprofgrade=new TableColumn<>();

    @FXML
    TableColumn<Utilisateurs,String> tcprofnom=new TableColumn<>();

    @FXML
    TextField txtnom, txtnci,txtgrade ;


    @FXML
    TableView<Classe> tbfilter;

    @FXML
    TableColumn<Classe, Integer> tcfilteridcclasse;

    @FXML
    TableColumn<Classe, String> tcfilternomclasse;




    @FXML
    TextField affectclasserecup,affectprofrecup,affectclasseid,affectprofid;

    @FXML
    Pane plprof,plclasse;








    @FXML 
    Button disp;
// tableview ne prend pas d'objet de types listes===>mais de type ObservableList
    private  ObservableList obprof=FXCollections.observableList(Fabrique.getService().selectAllProfesseur());


    
    
    
    
    @FXML
    ComboBox<Classe> box = new ComboBox<>();
        private  ObservableList obClasses=FXCollections.observableList(Fabrique.getService().selectAllClasses());
    
        public void www(){
        box.setItems(obClasses);

        }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tcprofid.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcprofnci.setCellValueFactory(new PropertyValueFactory<>("nci"));
        tcprofgrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        tcprofnom.setCellValueFactory(new PropertyValueFactory<>("nomcomplet"));
        tbprof.setItems(obprof);
        www();
        
    
    
    }


    public void selection(){
        Classe classes=box.getSelectionModel().getSelectedItem();
        String l=classes.getLibelle();
        Classe cl =Fabrique.getService().selectClasseByLibelle(l);

        if(cl!=null){
            affectclasserecup.setText(cl.getLibelle());}

    }


    public void insert(){
        String nomcomplet=txtnom.getText().trim();
        String ncis=txtnci.getText().trim();
        String grade=txtgrade.getText().trim();

        if (nomcomplet!="" && ncis!="" && grade!=""){
        Utilisateurs professeur = Fabrique.getService().insertProfesseur(new Professeur(nomcomplet,grade,ncis));

    Alert alert=new Alert(AlertType.INFORMATION);
        alert.setTitle("Gestion ISM(Professeur)");
        alert.setContentText("le professeur " + nomcomplet +  " a ete ajoute avec succes");
        alert.show();
        obprof.add(professeur);
        txtnom.clear();
        txtnci.clear();
        txtgrade.clear();
    }

    else{
        Alert alert=new Alert(AlertType.INFORMATION);
        alert.setTitle("Gestion ISM(Professeur)");
        alert.setContentText("saisissez avant d'ajouter");
        alert.show();
    }

}



    

    public void buttonrechercherclasse(){
        String id =affectclasseid.getText().trim();
        // convertion id
        int resultatclasseid = Integer.parseInt(id);
        Classe cl =Fabrique.getService().selectClasseByID(resultatclasseid);
       if(cl!=null){
          plclasse.setDisable(true);
          affectclasserecup.setText(cl.getLibelle());
       }else{
          plclasse.setDisable(false);
          Alert alert=new Alert(AlertType.INFORMATION);
          alert.setTitle("Gestion Baila(Prince de gloire javaConnect)");
          alert.setContentText("secretaire tu cherches quel id comme ça c'est invalide");
          alert.show();
       }
   }





   

//    affecter prof
public void affectbutton(){
    String classe_id =affectclasserecup.getText().trim();
    Classe cl =Fabrique.getService().selectClasseByLibelle(classe_id);

        if(cl!=null){
            int resultatclasseid = cl.getId();
    String prof_id =affectprofid.getText().trim();

    // convertion id
   
    // convertion id
    int resultatprofid = Integer.parseInt(prof_id);
    Utilisateurs prof=Fabrique.getService().selectProfesseurByID(resultatprofid);
    Classe classe=Fabrique.getService().selectClasseByID(resultatclasseid);
    Fabrique.getService().affectation(classe,prof);


    Alert alert=new Alert(AlertType.INFORMATION);
    alert.setTitle("Gestion Baila(Prince de gloire javaConnect)");
    alert.setContentText("la classe "+classe_id+" a ete affecte au prof "+prof_id);
    alert.show();
    
    affectclasserecup.clear();
    affectprofid.clear();
}

}








 ObservableList obsListCp;
 private void princesse(int id){
    //Conversion List-> ObservableList
    obsListCp=FXCollections.observableList(Fabrique.getService().filterprofclasse(id));
    tcfilteridcclasse.setCellValueFactory(new PropertyValueFactory<>("id"));
    // tcfilteridprof.setCellValueFactory(new PropertyValueFactory<>(""));
    tcfilternomclasse.setCellValueFactory(new PropertyValueFactory<>("libelle"));
    // tcfilternomprof.setCellValueFactory(new PropertyValueFactory<>("solde"));
    tbfilter.setItems(obsListCp);

 }

















 public void buttonrechercherprof(){
    String id =affectprofid.getText().trim();
    
    // convertion id
    int resultatid = Integer.parseInt(id);
    Utilisateurs prof =Fabrique.getService().selectProfesseurByID(resultatid);

   if(prof!=null){
      plprof.setDisable(true);
      affectprofrecup.setText(prof.getNomcomplet());


    //   apres recuperation de id prof
    princesse(resultatid);


    
   }else{
      plprof.setDisable(false);
      Alert alert=new Alert(AlertType.INFORMATION);
      alert.setTitle("Gestion Baila(Prince de gloire javaConnect)");
      alert.setContentText("secretaire tu cherches quel id comme ça c'est invalide");
      alert.show();
   }
}


    }


    
    

