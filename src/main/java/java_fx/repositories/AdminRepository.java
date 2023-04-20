package java_fx.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import java_fx.core.Mysql;
import java_fx.entities.RoleUsers;
import java_fx.entities.UsersAdmin;

public class AdminRepository extends Mysql implements IAdminRepository {

    private final String SQL_CONNECT="SELECT * FROM `admin` WHERE `login` LIKE ? AND `password` LIKE ?";
    
    @Override
    public UsersAdmin findUserByLoginAndPassword(String login, String password) {
        UsersAdmin admin=null;
        

        this.ouvertureConnexion();
        
        try {
              ps= conn.prepareStatement(SQL_CONNECT) ;
              ps.setString(1, login); 
              ps.setString(2, password); 
              ResultSet rs=ps.executeQuery();
              if(rs.next()){
                admin=new UsersAdmin(
                    rs.getInt("id"), 
                    
                    rs.getString("login"),
                    rs.getString("password") ,

                    rs.getString("nomcomplet"),

                    rs.getString("role").compareTo("AC")==0? RoleUsers.AC:RoleUsers.RP
  
                  
                    );









                //   if(rs.getString("role").compareTo("Client")!=0){
                //        Agence agence =new Agence(rs.getInt("agence_id"));
                //        user.setAgence(agence);
                //   }
              }

        

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.fermetureConnexion();
        return admin;
    
    }
    
}
