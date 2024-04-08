package com.example.demo.controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Note;
import com.example.demo.services.INoteServ;
import com.example.demo.services.NoteServImp;

@RestController
public class NoteController {
    @Autowired
    private NoteServImp noteServ;

    @PostMapping(value = "/addNote")
    public Note addNote(@RequestBody Note note) {
        return noteServ.ajouter_NOTE(note);
    }

    @PostMapping(value = "/addListNotes")
    public List<Note> addListNotes(@RequestBody List<Note> notes){
        return noteServ.addlistNotes(notes);
    }

    @GetMapping(value = "/getNote/{id}")
    public Note getNote(@PathVariable("id") Long id) {
        return noteServ.chercher_Note(id);
    }

    @DeleteMapping(value = "/deleteNote/{id}")
    public void deleteNote(@PathVariable("id") Long id) {
        noteServ.supprimer_NOTE(id);
    }

    @GetMapping(value = "/getAllNotes")
    public List<Note> getAllNotes() {
        return noteServ.afficher_NOTE();
    }

    @PutMapping(value = "/updateNote/{id}")
    public void updateNote(@PathVariable("id") Long id, @RequestBody Note updatedNote) {
        noteServ.modifier_NOTE(id, updatedNote);
    }

    @GetMapping(value = "/getNotesByEtudiantAndClasse/{idEtd}/{idClasse}")
    public List<Note> getNotesByEtudiantAndClasse(@PathVariable("idEtd") Long idEtd, @PathVariable("idClasse") Long idClasse) {
        return noteServ.afficher_Note_ETDCLASSE(idEtd, idClasse);
    }
}