package java_fx.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java_fx.entities.Classe;
import java_fx.entities.Professeur;
import java_fx.entities.RoleNonAdmin;
import java_fx.core.Mysql;
import java_fx.entities.Utilisateurs;

public class ProfesseursRepository extends Mysql implements IProfesseurRepository{
    
    private static final String SQL_INSERT="insert into utilisateurs(nom_complet,grade,roles,nci) values(?,?,?,?)";
    private static final String SQL_SELECT_ALL="select * from utilisateurs where roles like ?";
    private static final String SQL_SELECT_BY_ID="select * from utilisateurs where id=? and roles like ? ";
    

    private static final String SQL_INSERT_AFFECT="insert into classe_prof(classe_id,utilisateurs_id) values(?,?)";
    List<Utilisateurs> listeProf=new ArrayList<>();

    @Override
    public Utilisateurs ajouterProfesseur(Utilisateurs utilisateurs) {
        this.ouvertureConnexion();
        try {
            ps=conn.prepareStatement(SQL_INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,utilisateurs.getNomcomplet());
            ps.setString(2,((Professeur) utilisateurs).getGrade());
            
           
            ps.setString(3,(utilisateurs.getRoles().name()));
            ps.setString(4,((Professeur) utilisateurs).getNci());
           
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

    // -----------------------------------------------Lister---------------------

    @Override
    public List<Utilisateurs> listerProfesseur() {
        this.ouvertureConnexion();
        try {
            ps=conn.prepareStatement(SQL_SELECT_ALL);
            ps.setString(1,RoleNonAdmin.PROFESSEUR.name());
            ResultSet rs=ps.executeQuery();
            while(rs.next()){


    // Lister Professeur
                Utilisateurs utilisateurs=new Professeur(
                    rs.getInt("id"),
                    rs.getString("nom_complet"),
                    rs.getString("grade"),
                    rs.getString("nci"));
             

    
                   
                    listeProf.add(utilisateurs);
                
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        this.fermetureConnexion();
        return listeProf;
    }

    @Override
    public Utilisateurs filterProfesseurParId(int id) {
        Professeur professeurUser=null;
        this.ouvertureConnexion();
        try {
            ps=conn.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1,id);
            ps.setString(2,RoleNonAdmin.PROFESSEUR.name());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                professeurUser=new Professeur(
                    rs.getInt("id"),
                    rs.getString("nom_complet"),
                    rs.getString("grade"),
                    rs.getString("nci")
                    );
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        this.fermetureConnexion();
        return professeurUser;
    }

    

    @Override
    public void affecterClasseProfesseur(Classe classe, Utilisateurs utilisateurs) {
        this.ouvertureConnexion();
        try {
            ps=conn.prepareStatement(SQL_INSERT_AFFECT);

            ps.setInt(1,classe.getId());
            ps.setInt(2, utilisateurs.getId());
            
        
            ps.executeUpdate();
        
        }catch (SQLException e) {
            
                e.printStackTrace();
            }
       
       this.fermetureConnexion();
        
    }

    
}
