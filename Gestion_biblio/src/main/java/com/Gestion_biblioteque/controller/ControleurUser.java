package com.Gestion_biblioteque.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class ControleurUser 
{	@RequestMapping(value ="/index")
	@ResponseBody
	public String Index(String nom) {

		return "<h1>JavaEE 2021"
				+ "<h1>bonjour mr " +  nom +  "</h1>";
	}
@RequestMapping(value ="/presentation")
@ResponseBody
public String cv () {
	return "presentaion";
}

}		