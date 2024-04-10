package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Classe;
import com.example.demo.entities.Matiere;
import com.example.demo.entities.Module;
import com.example.demo.entities.Note;
import com.example.demo.entities.Specialite;
import com.example.demo.repository.IMatiereRepository;
import com.example.demo.repository.IModuleRepository;
import com.example.demo.repository.INoteRepository;

@Service
public class MatiereservImp  implements IMatiereServ{
@Autowired
private IMatiereRepository matRep;
@Autowired
private IModuleRepository modrep;
@Autowired
private INoteRepository noteRepo;

	@Override
	public Matiere addMatiere(Matiere u) {
		
	    
		return matRep.save(u);
	}

	@Override
	public List<Matiere> addlistMatieres(List<Matiere> c) {
		
		return (List<Matiere>) matRep.saveAll(c);
	}

	@Override
	public Matiere getmatierebyid(Long id) {
		return matRep.findById(id).get();
	}
	@Override
	public void DeleteMatiere(Long id) {
		for(Note n: noteRepo.findByMatiere(id))
			noteRepo.deleteById(n.getId());
		matRep.deleteById(id);
		
	}

	@Override
	public Matiere UpdateMatiere(Matiere c, Long id) {
		Matiere Cl = matRep.findById(id).get();
		Cl.setNomMatiere(c.getNomMatiere());
		Cl.setCoifMatiere(c.getCoifMatiere());
		return matRep.save(Cl);
	
	}
	@Override
	public List<Matiere> getAllMatieres() {

		return (List<Matiere>) matRep.findAll();
	}

	@Override
	public void addMatiereModule(Long idmat, Long idmodule) {
		Module c = modrep.findById(idmodule).get();
		Matiere m = matRep.findById(idmat).get();
		m.setM(c);
		matRep.save(m);
	}


}
