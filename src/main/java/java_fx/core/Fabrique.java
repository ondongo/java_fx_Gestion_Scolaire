package java_fx.core;

import java_fx.repositories.AdminRepository;
import java_fx.repositories.ClasseRepository;
import java_fx.repositories.EtudiantRepository;
import java_fx.repositories.IAdminRepository;
import java_fx.repositories.IClasseRepository;
import java_fx.repositories.IEtudiantRepository;
import java_fx.repositories.IProfesseurRepository;
import java_fx.repositories.IinscriptionRepository;
import java_fx.repositories.InscriptionRepository;
import java_fx.repositories.ProfesseursRepository;
import java_fx.services.IService;
import java_fx.services.Service;

public class Fabrique {
    public static IService getService(){
   
    IProfesseurRepository professeurRepository=new  ProfesseursRepository();
    IClasseRepository classeRepository=new ClasseRepository(professeurRepository);
    IEtudiantRepository etudiantRepository=new  EtudiantRepository();
    IAdminRepository adminRepository=new AdminRepository();
    IinscriptionRepository  inscriptionsRepository=new InscriptionRepository();
   return new Service(classeRepository,professeurRepository,etudiantRepository, inscriptionsRepository,adminRepository);
}






}
