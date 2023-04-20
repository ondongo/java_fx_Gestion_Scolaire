package java_fx.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java_fx.core.Mysql;
import java_fx.entities.Etudiant;
import java_fx.entities.Inscription;
import java_fx.entities.Utilisateurs;



public class InscriptionRepository extends Mysql implements IinscriptionRepository{
    
    private final String  SQL_INSERT_INS="insert into inscription(date_inscription,classe_id,user_id) values(?,?,?)";

    // private final String SQL_INSCR_ANNEE= "SELECT * FROM inscription` WHERE `date_inscription` LIKE ?";

    private final String SQL_INSCR_ANNEE="select e.* from utilisateurs e,inscription i  where e.id=i.user_id and i.date_inscription=?";


    private final String SQL_INSCR_AN_CLASSE="select e.* from utilisateurs e,inscription i  where e.id=i.user_id and i.date_inscription=? and i.classe_id=?";


    IEtudiantRepository etudiantRepository=new EtudiantRepository();
    IProfesseurRepository professeurRepository=new ProfesseursRepository();
    IClasseRepository classeRepository=new ClasseRepository(professeurRepository);
   

    @Override
    public Inscription inscrireEtudiant(Inscription inscription) {
       
        this.ouvertureConnexion();
        try {
            ps=conn.prepareStatement(SQL_INSERT_INS,PreparedStatement.RETURN_GENERATED_KEYS);
            //ps.setString(1,inscription.getDateinscription());
            ps.setInt(2,inscription.getClasse().getId());
            ps.setInt(3, inscription.getEtudiant().getId());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                inscription.setId(rs.getInt(1));
            }
        // System.out.println("ajout top");
        
        }catch (SQLException e) {
            
                e.printStackTrace();
            }
       
       this.fermetureConnexion();
        return inscription;
    }


    @Override
    public List<Utilisateurs> listerEtudiantInscrit(String annee) {
        List<Utilisateurs>  listetudiant=new ArrayList<>();
            this.ouvertureConnexion();
        try {
              ps= conn.prepareStatement(SQL_INSCR_ANNEE) ;
              ps.setString(1, annee); 
              
              
              ResultSet rs=ps.executeQuery();
              
              while(rs.next()){

                
                
                Utilisateurs etudiants  =new Etudiant
                (rs.getInt("id"),
                rs.getString("nom_complet"),
                rs.getString("tuteur"),
                rs.getString("matricule"));


                listetudiant.add(etudiants);
                       
                 }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.fermetureConnexion();
        return listetudiant;
    }


    @Override
    public List<Utilisateurs> listerEtudiantInscritAN_Classe(String annee, int id) {
        List<Utilisateurs>  listetudiantclasse=new ArrayList<>();
            this.ouvertureConnexion();
        try {
              ps= conn.prepareStatement(SQL_INSCR_AN_CLASSE) ;
              ps.setString(1, annee); 

              ps.setInt(2, id); 
              
              
              ResultSet rs=ps.executeQuery();
              
              while(rs.next()){

                
                
                Utilisateurs etudiants  =new Etudiant
                (rs.getInt("id"),
                rs.getString("nom_complet"),
                rs.getString("tuteur"),
                rs.getString("matricule"));


                listetudiantclasse.add(etudiants);
                       
                 }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.fermetureConnexion();
        return listetudiantclasse;
    }

    }


    // @Override
    // public List<Inscription> listerEtudiantInscrit(String a) {

    //     List<Inscription> inscriptionAn = new ArrayList<>();

    //     this.ouvertureConnexion();
    //     try {
            
    //        ps = conn.prepareStatement(SQL_INSCR_ANNEE);
    //        ps.setString(1, a+"%");
    //        ResultSet rs = ps.executeQuery();

    //        while(rs.next()){

    //         Inscription inscription = new Inscription(rs.getInt("id"),
    //         rs.getString("date_inscription"),

    //        classeRepository.rechercherClassebyid(rs.getInt("classe_id")),

    //        etudiantRepository.filterEtudiantParId(rs.getInt("user_id"))
    //        );

    //            inscriptionAn.add(inscription);
    //    }
    //     } catch (SQLException e) {
    //     e.printStackTrace();
    //     }

    //         this.fermetureConnexion();
    //     return inscriptionAn;
        
    // }
    

