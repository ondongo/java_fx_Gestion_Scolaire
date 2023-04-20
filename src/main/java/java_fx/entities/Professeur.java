package java_fx.entities;

import java.util.ArrayList;
import java.util.List;

public class Professeur extends Utilisateurs {
    private String grade;  
    private String nci; 


public String getNci() {
        return nci;
    }

    public void setNci(String nci) {
        this.nci = nci;
    }


    // Many to Many 
    List<Classe> classes=new ArrayList<>();
  

    public Professeur(int id, String nomcomplet, String grade,String nci) {
        super(id, nomcomplet);
        this.grade = grade;
        this.nci = nci;

        roles=RoleNonAdmin.PROFESSEUR;
    }

    public Professeur(String nomcomplet, String grade,String nci) {
        super(nomcomplet);
        this.grade = grade;
        this.nci = nci;
        roles=RoleNonAdmin.PROFESSEUR;
    }

    public Professeur() {
        roles=RoleNonAdmin.PROFESSEUR;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    
    @Override
    public String toString() {
        return super.toString()+ "grade=" + grade + "]";
    }

    
    
}
