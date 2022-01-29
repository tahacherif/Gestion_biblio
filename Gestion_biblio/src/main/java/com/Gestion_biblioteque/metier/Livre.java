package com.Gestion_biblioteque.metier;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
public class Livre implements Serializable{
	@Id
	@Column (length = 20)
	private String isbn;
	
	private int annee;
	private String titre;
	
	@ManyToMany (fetch = FetchType.EAGER)
	private List<Auteur> lesAuteurs=new ArrayList<Auteur>();
	
	public Livre() {
		super();
	}
	
	public Livre(String isbn, int annee, String titre) {
		super();
		this.isbn = isbn;
		this.annee = annee;
		this.titre = titre;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public  List<Auteur> getLesAuteurs() {
		return lesAuteurs;
	}

	public void setLesAuteurs(List<Auteur> lesAuteurs) {
		this.lesAuteurs = lesAuteurs;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livre other = (Livre) obj;
		return Objects.equals(isbn, other.isbn);
	}

	@Override
	public String toString() {
		return "Livre [isbn=" + isbn + ", annee=" + annee + ", titre=" + titre + "]";
	}
	public void addAuteur(Auteur a)
	{
		this.lesAuteurs.add(a);
		 a.addPoints(3);
	}
	
}
