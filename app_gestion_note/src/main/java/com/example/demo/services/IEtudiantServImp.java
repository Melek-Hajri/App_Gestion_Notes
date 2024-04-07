package com.example.demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Etudiant;
import com.example.demo.repository.IEtudiantRepository;

@Service
public class IEtudiantServImp implements IEtudiantServ{
	@Autowired
	IEtudiantRepository etudiantRepo;
	
	@Override
	public void ajouter_ETD(Etudiant etd) {
	    Etudiant etds =etudiantRepo.save(etd);
	}

	@Override
	public void supprimer_ETD(Long id) {
		etudiantRepo.deleteById(id);
	}

	@Override
	public List<Etudiant> afficher_ETD() {
		List<Etudiant> etudiants= (List<Etudiant>) etudiantRepo.findAll();
		return etudiants;
	}
}

