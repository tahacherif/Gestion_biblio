package com.Gestion_biblioteque.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Gestion_biblioteque.metier.*;

public interface AuteurDAO extends JpaRepository<Auteur, Long>{

}
