package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Matiere;
import com.example.demo.entities.Module;
import com.example.demo.entities.Note;
import com.example.demo.repository.IEtudiantRepository;
import com.example.demo.repository.IMatiereRepository;
import com.example.demo.repository.INoteRepository;

@Service
public class NoteServImp implements INoteServ{
	@Autowired
	INoteRepository noteRepo;
	@Autowired
	IEtudiantRepository etdRepo;
	@Autowired
	IMatiereRepository matRepo;
	
	@Override
	public Note ajouter_NOTE (Note note) {
		return (Note) noteRepo.save(note);
	}
	@Override
	public List<Note> addlistNotes(List<Note> notes){
		return (List<Note>) noteRepo.saveAll(notes);
	}
	@Override
	public Note chercher_Note(Long id) {
		return noteRepo.findById(id).get();
	}
	@Override
	public void supprimer_NOTE(Long id) {
		noteRepo.deleteById(id);
	}
	@Override
	public List<Note> afficher_NOTE(){
		List<Note> notes= (List<Note>) noteRepo.findAll();
		return notes;
	}
	@Override
	public void modifier_NOTE(Long id, Note updatedNote) {
		Note n = noteRepo.findById(id).get();
		n.setType(updatedNote.getType());
		n.setNote(updatedNote.getNote());
		n.setMatiere(updatedNote.getMatiere());
        n.setEtudiant(updatedNote.getEtudiant());
        noteRepo.save(n);
	}
	@Override
	public List<Note> afficher_Note_ETDMATIERE(Long idEtd, Long idClasse){
		List<Note> notes = (List<Note>) noteRepo.findByEtdMatiere(idEtd, idClasse);
		return notes;
	}
	@Override 
	public List<Note> NotesByEtd(Long idEtd){
		return (List<Note>) noteRepo.findByEtd(idEtd);
	}
	
	@Override
	public List<Note> findByClasse(Long idClasse){
		return (List<Note>) noteRepo.findByClasse(idClasse);
	}
	
	@Override
	public void addEtudiant(Long idNote, Long idEtd) {
		Note n = noteRepo.findById(idNote).get();
		Etudiant etd = etdRepo.findById(idEtd).get();
		n.setEtudiant(etd);
		noteRepo.save(n);
	}
	
	@Override
	public void addMatiere(Long idNote, Long idMat) {
		Note n = noteRepo.findById(idNote).get();
		Matiere m = matRepo.findById(idMat).get();
		n.setMatiere(m);
		noteRepo.save(n);
	}

}
