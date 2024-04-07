package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Etudiant;

public interface IEtudiantServ {
	public void ajouter_ETD (Etudiant etd);
	public void supprimer_ETD(Long id);
	public List<Etudiant> afficher_ETD();
}
