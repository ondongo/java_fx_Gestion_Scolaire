package java_fx.entities;

public class Ac extends UsersAdmin{

    public Ac() {
        roleUsers=RoleUsers.AC;
    }

    public Ac(String login, String password, String nomcomplet) {
        super(login, password, nomcomplet);
    }


    
}
