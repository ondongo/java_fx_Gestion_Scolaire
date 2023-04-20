package java_fx.repositories;

import java.util.List;

// import java.util.List;

import java_fx.entities.Inscription;
import java_fx.entities.Utilisateurs;


public interface IinscriptionRepository {
    public Inscription inscrireEtudiant(Inscription inscription);

    // public List<Inscription> listerEtudiantInscrit(String annee);

    public List<Utilisateurs> listerEtudiantInscrit(String annee);

    public List<Utilisateurs> listerEtudiantInscritAN_Classe(String annee,int id);





}