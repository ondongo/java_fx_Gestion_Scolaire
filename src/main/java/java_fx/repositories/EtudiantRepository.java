package java_fx.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java_fx.core.Mysql;
import java_fx.entities.Etudiant;
import java_fx.entities.RoleNonAdmin;
import java_fx.entities.Utilisateurs;

public class EtudiantRepository extends Mysql implements IEtudiantRepository{


    private static final String SQL_INSERT="insert into utilisateurs(nom_complet,tuteur,matricule,roles) values(?,?,?,?)";
    
    private static final String SQL_SELECT_ALL="select * from utilisateurs where roles like ?";
    private static final String SQL_SELECT_BY_ID="select * from utilisateurs where id=? and roles like ? ";
    private static final String SQL_SELECT_BY_NOM="select * from utilisateurs where nom_complet=? and roles like ? ";
    List<Utilisateurs> listeUsersNonAdmins=new ArrayList<>();

    @Override
    public Utilisateurs ajouterEtudiant(Utilisateurs utilisateurs) {
        this.ouvertureConnexion();
        try {
            ps=conn.prepareStatement(SQL_INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,utilisateurs.getNomcomplet());
           
            ps.setString(2,((Etudiant) utilisateurs).getTuteur());
            ps.setString(3,((Etudiant) utilisateurs).getMatricule());
            ps.setString(4,(utilisateurs.getRoles().name()));
           
           
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                utilisateurs.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }

       this.fermetureConnexion();
        return utilisateurs;
    }
    

    @Override
    public List<Utilisateurs> listerEtudiant() {
        this.ouvertureConnexion();
        try {
            ps=conn.prepareStatement(SQL_SELECT_ALL);
            
             ps.setString(1,RoleNonAdmin.ETUDIANT.name());
            ResultSet rs=ps.executeQuery();
            while(rs.next()){


                
                // Lister Etudiant
                Utilisateurs utilisateur2=new Etudiant(
                    rs.getInt("id"),
                    rs.getString("nom_complet"),
                    rs.getString("tuteur"),
                    rs.getString("matricule"));
             
                   
                   
                    listeUsersNonAdmins.add(utilisateur2);
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        this.fermetureConnexion();
        return listeUsersNonAdmins;
    }
    @Override
    public Utilisateurs filterEtudiantParId(int id) {
        Etudiant etudiantUser=null;
        this.ouvertureConnexion();
        try {
            ps=conn.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1,id);
            ps.setString(2,RoleNonAdmin.ETUDIANT.name());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                etudiantUser=new Etudiant(
                    rs.getInt("id"),
                    rs.getString("nom_complet"),
                    rs.getString("tuteur"),
                    rs.getString("matricule"));
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        this.fermetureConnexion();
        return etudiantUser;
    }



    // methode Sup

    @Override
    public Utilisateurs filterEtudiantParNom(String nom) {
        Etudiant etudiantUser=null;
        this.ouvertureConnexion();
        try {
            ps=conn.prepareStatement(SQL_SELECT_BY_NOM);
            ps.setString(1,nom);
            ps.setString(2,RoleNonAdmin.ETUDIANT.name());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                etudiantUser=new Etudiant(
                    rs.getInt("id"),
                    rs.getString("nom_complet"),
                    rs.getString("tuteur"),
                    rs.getString("matricule"));
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        this.fermetureConnexion();
        return etudiantUser;
    }


    }
    

