package com.Gestion_biblioteque.metier;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Auteur implements Serializable{
	@Id
	private Long id;
	
	private String nomPrenom;
	private int nbrePoints;
	public Auteur(Long id, String nomPrenom) {
		super();
		this.id = id;
		this.nomPrenom = nomPrenom;
		this.nbrePoints=0;
	}
	
	public Auteur() {
		super();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomPrenom() {
		return nomPrenom;
	}
	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}
	public int getNbrePoints() {
		return nbrePoints;
	}
	public void setNbrePoints(int nbrePoints) {
		this.nbrePoints = nbrePoints;
	}
	@Override
	public String toString() {
		return "Auteur [id=" + id + ", nomPrenom=" + nomPrenom + ", nbrePoints=" + nbrePoints + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auteur other = (Auteur) obj;
		return Objects.equals(id, other.id);
	}
	
	public void addPoints(int p)
	{
		this.setNbrePoints(this.nbrePoints+p);
	}
}
