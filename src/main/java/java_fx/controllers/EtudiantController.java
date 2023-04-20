package java_fx.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import java_fx.core.Fabrique;
import java_fx.entities.Classe;
import java_fx.entities.Etudiant;
import java_fx.entities.Inscription;
import java_fx.entities.Utilisateurs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class EtudiantController implements Initializable{

    @FXML
     TextField txtaffect;

    @FXML
     TextField txtclasse;

    @FXML
     TextField txtdateinscription;

    @FXML
    TextField txtidetudiantIns;

    // @FXML
    // TextField txtmatricule;

    @FXML
    TextField txtnomcomplet;

    @FXML
    TextField txttuteur;


    // Partie de l'inscription lister
    @FXML
    TableView<Utilisateurs> tbinsAn;

 

    @FXML
    private TableColumn<Utilisateurs, Integer> tcidAn;

    @FXML
    private TableColumn<Utilisateurs, String> tcmatricule;

    @FXML
    private TableColumn<Utilisateurs, String> tcnomAn;

    @FXML
    private TableColumn<Utilisateurs, String> tctuteur;  


    public void insertEtudiant(){
        String nometud=txtnomcomplet.getText().trim();
        String nomtuteur=txttuteur.getText().trim();


        if (nometud!="" && nomtuteur!=""){
        // String matricule=txtmatricule.getText().trim();
        Utilisateurs etudiant= Fabrique.getService().insertEtudiant(new Etudiant(nometud,nomtuteur));

        buttoninscription();
        Alert alert=new Alert(AlertType.INFORMATION);
        alert.setTitle("Gestion ISM(etudiant)");
        alert.setContentText("etudiant  a ete inscrit avec succes");
        alert.show();
        // obprof.add(professeur);
        txtnomcomplet.clear();
        txttuteur.clear();
        // txtmatricule.clear();
    }
    else{

        Alert alert=new Alert(AlertType.INFORMATION);
        alert.setTitle("Gestion ISM(etudiant)");
        alert.setContentText("saisissez avant d'insciption");
        alert.show();

    }
    }



    // Inscription ajout
    public void buttoninscription(){
        String date=txtdateinscription.getText().trim();
        String classe_id =txtclasse.getText().trim();
        String nometud=txtnomcomplet.getText().trim();

        Utilisateurs et =Fabrique.getService().selectEtudiantByNom(nometud);
        Classe cl =Fabrique.getService().selectClasseByLibelle(classe_id);
        if(et!=null && cl!=null){
           int recup=et.getId();
           Utilisateurs etudiant=Fabrique.getService().selectEtudiantByID(recup);
        //   String etud_id =txtidetudiantIns.getText().trim();


            int recupclasse_id=cl.getId();
        // convertion id
        // int resultatclasseid = Integer.parseInt(classe_id);
        // plus besoin
        // int resultatetudiantid = Integer.parseInt(etud_id);
        Classe classe=Fabrique.getService().selectClasseByID(recupclasse_id);
       // Inscription inscriptions=new Inscription(date,classe,etudiant);
        //Inscription inscriptionsAvecId=Fabrique.getService().InsertEtudiant(inscriptions);
        }
    }






    @FXML
    TextField anText;

    
   ObservableList obsListInscrit;

    public void test(){
    String recupan=anText.getText().trim();

        
    //Conversion List-> ObservableList
       obsListInscrit=FXCollections.observableList(Fabrique.getService().filtreAn(recupan));
       
       tcidAn.setCellValueFactory(new PropertyValueFactory<>("id"));
       tcmatricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));

       tcnomAn.setCellValueFactory(new PropertyValueFactory<>("nomcomplet"));
       tctuteur.setCellValueFactory(new PropertyValueFactory<>("tuteur"));

    
    // tcnomAn.setCellValueFactory(new PropertyValueFactory<>("classe_id"));

    //    tcClasseAn.setCellValueFactory(new PropertyValueFactory<>("user_id"));

       tbinsAn.setItems(obsListInscrit);

    }


    @FXML
    TextField anText1,txtclasse1;
    
    


    @FXML
    ComboBox<Classe> box = new ComboBox<>();
    private  ObservableList obClasses=FXCollections.observableList(Fabrique.getService().selectAllClasses());

    public void www(){
    box.setItems(obClasses);

}
        // 
    // comboBox.getSelectionModel().select(1);

    // tableview ne prend pas d'objet de types listes===>mais de type ObservableList
    public void selection(){
        Classe classes=box.getSelectionModel().getSelectedItem();
        String l=classes.getLibelle();
        Classe cl =Fabrique.getService().selectClasseByLibelle(l);

        if(cl!=null){
            txtclasse1.setText(cl.getLibelle());}

    }

    public static Utilisateurs etudiant;
    public void classeAn(){

        // avec methode des champs
        String recup1=txtclasse1.getText().trim();
        // int idclasse=Integer.parseInt(recup1);

        String recup2=anText1.getText().trim();


        selection();

 
        

        Classe cli =Fabrique.getService().selectClasseByLibelle(recup1);
        if(cli!=null){
        int recup3=cli.getId(); 

        //Conversion List-> ObservableList
           obsListInscrit=FXCollections.observableList(Fabrique.getService().filtreAnClasse(recup2,recup3));
           
           tcidAn.setCellValueFactory(new PropertyValueFactory<>("id"));
          tcmatricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));

          tcnomAn.setCellValueFactory(new PropertyValueFactory<>("nomcomplet"));
          tctuteur.setCellValueFactory(new PropertyValueFactory<>("tuteur"));

        
           tbinsAn.setItems(obsListInscrit);
        }

        
           else{
            Alert alert=new Alert(AlertType.INFORMATION);
            alert.setTitle("Gestion ISM(etudiant)");
            alert.setContentText("toi");
            alert.show();
        }
    

  
        }

    
          
    



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        www();
    }



    
}
