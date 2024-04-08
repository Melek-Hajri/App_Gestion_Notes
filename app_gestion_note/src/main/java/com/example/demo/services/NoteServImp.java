package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Note;
import com.example.demo.repository.INoteRepository;

@Service
public class NoteServImp implements INoteServ{
	@Autowired
	INoteRepository noteRepo;
	
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
		Optional<Note> optionalNote = noteRepo.findById(id);
        if (optionalNote.isPresent()) {
            Note existingNote = optionalNote.get();

            existingNote.setType(updatedNote.getType());
            //existingNote.setMatiere(updatedNote.getMatiere());
            existingNote.setEtudiant(updatedNote.getEtudiant());
            noteRepo.save(existingNote);
        } else {
            // Handle the case where the student with the given id does not exist
        }
	}
	@Override
	public List<Note> afficher_Note_ETDCLASSE(Long idEtd, Long idClasse){
		List<Note> notes = (List<Note>) noteRepo.findByEtdMatiere(idEtd, idClasse);
		return notes;
	}
	@Override 
	public List<Note> NotesByEtd(Long idEtd){
		return (List<Note>) noteRepo.findByEtd(idEtd);
	}

}
