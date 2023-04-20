package java_fx.repositories;
import java.util.List;

import java_fx.entities.Classe;
import java_fx.entities.Utilisateurs;
public interface IClasseRepository {



    public Classe ajouterUneClasse(Classe classe);



    public List<Classe> listerClasses();




    
    // public Boolean supprimerClasse(Classe classe);
    public Classe rechercherClassebylibelle(String libelle);

    public Classe rechercherClassebyid(int id);



    
    public  List<Classe> filtrerprofclasse(int id);




}

