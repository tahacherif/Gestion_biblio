package com.Gestion_biblioteque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.Gestion_biblioteque.DAO.*;
import com.Gestion_biblioteque.metier.Auteur;
import com.Gestion_biblioteque.metier.Livre;

@SpringBootApplication
public class Tp21Application {

	public static void main(String[] args) {
		
		ApplicationContext app =SpringApplication.run(Tp21Application.class, args);
		AuteurDAO bdauteur=app.getBean(AuteurDAO.class);
		
		Auteur a1=new Auteur(1l,"Khemakhem Aida");
		Auteur a2=new Auteur(2l,"Gargouri Bilel");
		Auteur a3=new Auteur(3l,"Gargouri Faiez");
		Auteur a4=new Auteur(4l,"Bouaziz Rafik");
		bdauteur.save(a1);
		bdauteur.save(a2);
		bdauteur.save(a3);
		bdauteur.save(a4);
		LivreDAO bdlivre=app.getBean(LivreDAO.class);
		Livre l1=new Livre("IB2222",2015,"LMF-ISO-24613");
		l1.addAuteur(a1);
		l1.addAuteur(a2);
		bdlivre.save(l1);
		Livre l2=new Livre("IB3333",2009,"UML-Diagramme de Classe");
		l2.addAuteur(a3);
		l2.addAuteur(a4);
		bdlivre.save(l2);
		Livre l3=new Livre("IB4444",2017,"POO-Avancée");
		l3.addAuteur(a1);
		l3.addAuteur(a3);
		bdlivre.save(l3);
		bdauteur.save(a1);
		bdauteur.save(a2);
		bdauteur.save(a3);
		bdauteur.save(a4);
		for(Livre li : bdlivre.findByAnnee(2015))
            System.out.println(li);
		for(Livre li : bdlivre.findByTitre("POO-Avancée"))
            System.out.println(li);
  System.out.println(a1.getNbrePoints());

	}

}
