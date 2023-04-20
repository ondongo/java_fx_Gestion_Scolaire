package java_fx.entities;

public class UsersAdmin {

   



    protected int id;
    protected String login;
    protected String password;
    protected String nomcomplet;

    protected RoleUsers roleUsers;

   

   



   


    public UsersAdmin(int id, String login, String password, String nomcomplet, RoleUsers roleUsers) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.nomcomplet = nomcomplet;
        this.roleUsers = roleUsers;
    }


    public UsersAdmin(String nomcomplet) {
        this.nomcomplet = nomcomplet;
        roleUsers=RoleUsers.RP;
    }
    public UsersAdmin(String login, String password, String nomcomplet) {
        this.login = login;
        this.password = password;
        this.nomcomplet = nomcomplet;
        roleUsers=RoleUsers.RP;
    }


    public UsersAdmin() {
        roleUsers=RoleUsers.RP;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleUsers getRoleUsers() {
        return roleUsers;
    }

    public void setRoleUsers(RoleUsers roleUsers) {
        this.roleUsers = roleUsers;
    }
   
    public String getNomcomplet() {
        return nomcomplet;
    }



    public void setNomcomplet(String nomcomplet) {
        this.nomcomplet = nomcomplet;
    }
    
   
    
}
