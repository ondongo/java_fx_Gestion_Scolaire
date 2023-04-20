package java_fx.entities;


import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Inscription {

   private int id;
   private Date dateinscription;

    // classe association
    private Classe classe;
    private Utilisateurs etudiant;

    public Inscription() {
    }
    
    public Inscription(int id, Date  dateinscription, Classe classe, Utilisateurs etudiant) {
        this.id = id;
        this.dateinscription = dateinscription;
        this.classe = classe;
        this.etudiant = etudiant;
    }

    public Inscription(Date  dateinscription, Classe classe, Utilisateurs etudiant) {
        this.dateinscription = dateinscription;
        this.classe = classe;
        this.etudiant = etudiant;
    }

    public  Utilisateurs getEtudiant() {
        return etudiant;
    }
    public void setEtudiant(Utilisateurs etudiant) {
        this.etudiant = etudiant;
    }
    public Classe getClasse() {
        return classe;
    }
    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getDateinscription() {
        return dateinscription;
    }
    public void setDateinscription(Date dateinscription) {
        this.dateinscription = dateinscription;
    }

    @Override
    public String toString() {
        return "Inscription [id=" + id + ", dateinscription=" + dateinscription + ", classe=" + classe + ", etudiant="
                + etudiant + "]";
    }
    
}
