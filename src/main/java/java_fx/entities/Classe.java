package java_fx.entities;

import java.util.ArrayList;
import java.util.List;

// import java.util.ArrayList;
// import java.util.List;

public class Classe {
    private int id;
    private String niveau;
    private String filiere;
    private String libelle;
    
    

    // Many to Many
    List<Professeur> professeur=new ArrayList<>();
  
    public Classe(int id) {
        this.id = id;
    }

    public Classe(String niveau, String filiere) {
        this.niveau = niveau;
        this.filiere = filiere;
        this.libelle =  niveau+" "+filiere;
    }

    public Classe() {

    }
    
    public Classe(int id, String niveau, String filiere, String libelle) {
        this.id = id;
        this.niveau = niveau;
        this.filiere = filiere;
        this.libelle = libelle;
    }

    public Classe(String niveau, String filiere, String libelle) {
        this.niveau = niveau;
        this.filiere = filiere;
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNiveau() {
        return niveau;
    }
    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
    public String getFiliere() {
        return filiere;
    }
    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle =  niveau+" "+filiere;
    }
    @Override
    public String toString() {
        return libelle;
    }
    
}
