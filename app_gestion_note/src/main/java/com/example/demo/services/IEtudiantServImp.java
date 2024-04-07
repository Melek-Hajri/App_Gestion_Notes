package com.example.demo.services;


import java.util.List;
import java.util.Optional;

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
	
	@Override
    public void modifier_ETD(Long id, Etudiant updatedEtd) {
        Optional<Etudiant> optionalEtd = etudiantRepo.findById(id);
        if (optionalEtd.isPresent()) {
            Etudiant existingEtd = optionalEtd.get();

            existingEtd.setCin(updatedEtd.getCin());
            existingEtd.setDaten(updatedEtd.getDaten());
            existingEtd.setLieun(updatedEtd.getLieun());
            existingEtd.setAdresse(updatedEtd.getAdresse());
            existingEtd.setTel(updatedEtd.getTel());
            existingEtd.setEmail(updatedEtd.getEmail());
            existingEtd.setNom(updatedEtd.getNom());
            existingEtd.setPrenom(updatedEtd.getPrenom());
            //existingEtd.setClasse(updatedEtd.getClasse());
            existingEtd.setNotes(updatedEtd.getNotes());
            etudiantRepo.save(existingEtd);
        } else {
            // Handle the case where the student with the given id does not exist
        }
    }
}

