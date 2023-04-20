package java_fx.core;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


  // private static final String DB_URL = "jdbc:postgresql://localhost:5432/mavengloire" ;
    // private static final String USER = "postgres" ;
    // private static final String PASS = "root" ;
    // private static final String DRIVERPOSTGRE_CLASS = "org.postgresql.Driver";

public class Mysql implements BaseDeDonne{
    protected Connection conn;
    protected PreparedStatement ps;


  

    private static final String DB_URL = "jdbc:mysql://localhost:3306/maven1";
    private static final String USER = "root";
    private static final String PASS = "";
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    

    @Override
    public void ouvertureConnexion() {
        try {
            // Class.forName(DRIVERPOSTGRE_CLASS);
           
            Class.forName(DRIVER_CLASS);
            // java.sql.Connection 
            
            
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connexion au serveur réussie");

            
        } catch (Exception e) {
            System.out.println("erreur");
          
         
        } 
        
    }
    //la fermeture
    @Override
    public void fermetureConnexion() {
        if(conn!=null){

            
            try {
                conn.close();
            } catch (SQLException e) {
                
                e.printStackTrace();
            }
        }
        
    }
    
    
}
