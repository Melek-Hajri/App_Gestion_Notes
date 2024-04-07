package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Note;

public interface INoteServ {

	public void ajouter_NOTE (Note note);
	public void supprimer_NOTE(Long id);
	public List<Note> afficher_NOTE();
	public void modifier_NOTE(Long id, Note updatedNote);
}
