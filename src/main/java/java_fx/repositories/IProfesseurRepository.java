package java_fx.repositories;

import java.util.List;

import java_fx.entities.Classe;
import java_fx.entities.Utilisateurs;

public interface IProfesseurRepository {
    public Utilisateurs ajouterProfesseur(Utilisateurs utilisateurs);
    public List<Utilisateurs> listerProfesseur();
    public Utilisateurs filterProfesseurParId(int id);
    public void affecterClasseProfesseur(Classe classe,Utilisateurs utilisateurs);
    // public Boolean supprimerProfesseur(Professeur professeur);
}
