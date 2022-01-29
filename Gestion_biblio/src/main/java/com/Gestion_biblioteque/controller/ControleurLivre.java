package com.Gestion_biblioteque.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Gestion_biblioteque.DAO.AuteurDAO;
import com.Gestion_biblioteque.DAO.LivreDAO;
import com.Gestion_biblioteque.metier.Auteur;
import com.Gestion_biblioteque.metier.Livre;

@Controller
@RequestMapping(value= "livre")
public class ControleurLivre 
{
	@Autowired
	LivreDAO livreDAO;
	@Autowired
	AuteurDAO auteurDAO;
	@RequestMapping(value= "/gerer")
	public String gererLivre(ModelMap modelMap)
	{
		modelMap.addAttribute("livres", livreDAO.findAll());
		modelMap.addAttribute("auteurs", auteurDAO.findAll());
		return "gestionLivre";
	}
	@RequestMapping(value= "/affectation")
	public String affectation(ModelMap modelMap)
	{
		modelMap.addAttribute("livres", livreDAO.findAll());
		modelMap.addAttribute("auteurs", auteurDAO.findAll());
		return "affecterAuteur";
	}
	
	@RequestMapping(value= "/affecter", method=RequestMethod.GET)
	public void affecterAuteur(ModelMap modelMap, String isbn, Long idAuteur, HttpServletResponse response)
	{
		Livre li=livreDAO.getById(isbn);
		Auteur au=auteurDAO.getById(idAuteur);
		li.addAuteur(au);
		auteurDAO.save(au);
		modelMap.addAttribute("livres", livreDAO.findAll());
		modelMap.addAttribute("auteurs", auteurDAO.findAll());
		try {
			response.sendRedirect("affectation");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value= "/addlivre", method=RequestMethod.GET)
	public void addLivre(ModelMap modelMap, Livre livre, HttpServletResponse response)
	{
		livreDAO.save(livre);
		modelMap.addAttribute("livres", livreDAO.findAll());
		try {
			response.sendRedirect("gerer");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}

