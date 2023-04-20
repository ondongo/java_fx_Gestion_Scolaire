package java_fx.entities;

public class Rp extends UsersAdmin{

    public Rp(String login, String password, String nomcomplet) {
        super(login, password, nomcomplet);
    }

    public Rp() {
        
        roleUsers=RoleUsers.RP;
    }
    
}
