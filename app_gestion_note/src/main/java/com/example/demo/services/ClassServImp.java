package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Classe;
import com.example.demo.entities.Module;
import com.example.demo.entities.Specialite;
import com.example.demo.repository.IClasseRepository;
import com.example.demo.repository.IModuleRepository;
import com.example.demo.repository.ISpecialiteRepository;

@Service
public class ClassServImp implements IClasseServ{
@Autowired
private IClasseRepository classerep;
@Autowired
private IModuleRepository modulerep;
@Autowired
private ISpecialiteRepository specrep;
	@Override
	public Classe addClasse(Classe u) {
		
		return classerep.save(u);
	}

	@Override
	public List<Classe> addlistclasses(List<Classe> c) {
		return(List<Classe>) classerep.saveAll(c);
	}

	@Override
	public Classe getclassebyid(Long id) {
		return classerep.findById(id).get();
	}

	@Override
	public Classe UpdateClasse(Classe c, Long idclasse) {
		Classe Cl=classerep.findById(idclasse).get();
		Cl.setNomClasse(c.getNomClasse());
		Cl.setNiveauClasse(c.getNiveauClasse());
  
		return classerep.save(Cl);
	}

	@Override
	public void DeleteClasse(Long idclasse) {
       classerep.deleteById(idclasse);		
	}

	@Override
	public List<Classe> getAllClasses() {

		return(List<Classe>) classerep.findAll();
	}

	@Override
	public Classe addaModuleclasse(Long idclasse, Long idModule) {
		Classe CL= classerep.findById(idclasse).get();
		Module MD= modulerep.findById(idModule).get();
		CL.addModule(MD);
		return classerep.save(CL);
	}

	@Override
	public Classe addSpecialiteclasse(Long idclasse, Long idspecialite) {
		Classe CL= classerep.findById(idclasse).get();
		Specialite sp= specrep.findById(idspecialite).get();
		CL.addSpecialite(sp);
		return classerep.save(CL);
	}

}
