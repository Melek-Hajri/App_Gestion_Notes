package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Note;

public interface INoteServ {

	public Note ajouter_NOTE (Note note);
	public List<Note> addlistNotes(List<Note> notes);
	public Note chercher_Note(Long id);
	public void supprimer_NOTE(Long id);
	public List<Note> afficher_NOTE();
	public void modifier_NOTE(Long id, Note updatedNote);
	public List<Note> afficher_Note_ETDCLASSE(Long idEtd, Long idClasse);
	public List<Note> NotesByEtd(Long idEtd);
}
