package java_fx.entities;

public class Utilisateurs {
    protected int id;
  
    protected String nomcomplet;

    protected RoleNonAdmin roles;

    public Utilisateurs(int id, String nomcomplet) {
        this.id = id;
        this.nomcomplet = nomcomplet;
    }


    public Utilisateurs() {


        
    }

  
    public Utilisateurs(String nomcomplet) {
        this.nomcomplet = nomcomplet;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomcomplet() {
        return nomcomplet;
    }

    public void setNomcomplet(String nomcomplet) {
        this.nomcomplet = nomcomplet;
    }
    
    public RoleNonAdmin getRoles() {
        return roles;
    }

    public void setRoles(RoleNonAdmin roles) {
        this.roles = roles;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", nomComplet=" + nomcomplet + ", role=" + roles +" ,";
    }


}
