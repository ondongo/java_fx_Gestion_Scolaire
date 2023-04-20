package java_fx.services;

import java.util.List;

import java_fx.entities.Classe;
import java_fx.entities.Inscription;
import java_fx.entities.UsersAdmin;
import java_fx.entities.Utilisateurs;
import java_fx.repositories.IAdminRepository;
import java_fx.repositories.IClasseRepository;
import java_fx.repositories.IEtudiantRepository;
import java_fx.repositories.IProfesseurRepository;
// import java_fx.repositories.ProfesseursRepository;
import java_fx.repositories.IinscriptionRepository;


public class Service implements IService{

    IClasseRepository classeRepository;
    IProfesseurRepository professeursRepository;
    IEtudiantRepository etudiantsRepository;
    IinscriptionRepository inscriptionsRepository;
    IAdminRepository adminRepository;
   





    public Service(IClasseRepository classeRepository,IProfesseurRepository professeursRepository,IEtudiantRepository etudiantsRepository,IinscriptionRepository inscriptionsRepository,IAdminRepository adminRepository) {
        this.classeRepository = classeRepository;
    
        this.professeursRepository = professeursRepository;
        
        this.etudiantsRepository = etudiantsRepository;
        this.inscriptionsRepository = inscriptionsRepository;
         this.adminRepository=adminRepository;

         
    }

    @Override
    public Classe insertClasse(Classe classe) {
        return classeRepository.ajouterUneClasse(classe);
    }

    @Override
    public List<Classe> selectAllClasses() {
        return classeRepository.listerClasses();
    }

    @Override
    public Classe selectClasseByID(int id) {
        return classeRepository.rechercherClassebyid(id);
    }

    @Override
    public Utilisateurs insertProfesseur(Utilisateurs utilisateurs) {
        return  professeursRepository.ajouterProfesseur(utilisateurs);
    }

    @Override
    public List<Utilisateurs> selectAllProfesseur() {
        return professeursRepository.listerProfesseur();
    }

    @Override
    public Utilisateurs selectProfesseurByID(int id) {
        return  professeursRepository.filterProfesseurParId(id);
    }



    
    @Override
    public Utilisateurs insertEtudiant(Utilisateurs utilisateurs) {
        return  etudiantsRepository.ajouterEtudiant(utilisateurs);
    }

    @Override
    public List<Utilisateurs> selectAllEtudiant() {
        return  etudiantsRepository. listerEtudiant();
    }

    @Override
    public Utilisateurs selectEtudiantByID(int id) {
        return  etudiantsRepository.filterEtudiantParId(id);
    }


    @Override
    public void affectation(Classe classe,Utilisateurs utilisateurs) {
        professeursRepository.affecterClasseProfesseur(classe, utilisateurs);
        
    }

    @Override
    public UsersAdmin connexion(String login, String password) {
        // TODO Auto-generated method stub
        return adminRepository.findUserByLoginAndPassword(login, password);
    }

    @Override
    public List<Classe> filterprofclasse(int id) {
        return classeRepository.filtrerprofclasse(id);
    }

    @Override
    public Utilisateurs selectEtudiantByNom(String nom) {
        // TODO Auto-generated method stub
        return etudiantsRepository.filterEtudiantParNom(nom);
    }


    @Override
    public Inscription InsertEtudiant(Inscription inscription) {
        // TODO Auto-generated method stub
        return inscriptionsRepository.inscrireEtudiant(inscription);
    }


    @Override
    public List<Utilisateurs> filtreAn(String annee) {
        // TODO Auto-generated method stub
        return inscriptionsRepository.listerEtudiantInscrit(annee);
    }

    @Override
    public List<Utilisateurs> filtreAnClasse(String annee, int id) {
        // TODO Auto-generated method stub
        return inscriptionsRepository.listerEtudiantInscritAN_Classe(annee, id);
    }

    @Override
    public Classe selectClasseByLibelle(String libelle) {
        // TODO Auto-generated method stub
        return classeRepository.rechercherClassebylibelle(libelle);
    }
   
    
}