package java_fx.repositories;

import java.util.List;

import java_fx.entities.Utilisateurs;

public interface IEtudiantRepository {
    public Utilisateurs ajouterEtudiant(Utilisateurs utilisateurs);
    public List<Utilisateurs> listerEtudiant();
    public Utilisateurs filterEtudiantParId(int id);

    public Utilisateurs filterEtudiantParNom(String nom);


    
    


   
}
