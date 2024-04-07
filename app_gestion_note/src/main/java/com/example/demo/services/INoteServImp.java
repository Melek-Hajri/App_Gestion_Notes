package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Note;
import com.example.demo.repository.INoteRepository;

@Service
public class INoteServImp implements INoteServ{
	@Autowired
	INoteRepository noteRepo;
	
	@Override
	public void ajouter_NOTE (Note note) {
		Note notes =noteRepo.save(note);
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

}
