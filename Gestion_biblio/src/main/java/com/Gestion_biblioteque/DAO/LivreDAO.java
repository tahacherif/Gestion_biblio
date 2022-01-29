package com.Gestion_biblioteque.DAO;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Gestion_biblioteque.metier.*;
public interface LivreDAO extends JpaRepository<Livre, String> {
	public ArrayList<Livre> findByAnnee(int annee);
	public ArrayList<Livre> findByTitre(String titre);

}
