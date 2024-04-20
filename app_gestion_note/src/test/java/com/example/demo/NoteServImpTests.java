package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyLong;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Matiere;
import com.example.demo.entities.Note;
import com.example.demo.repository.IEtudiantRepository;
import com.example.demo.repository.IMatiereRepository;
import com.example.demo.repository.INoteRepository;
import com.example.demo.services.NoteServImp;

@ExtendWith(MockitoExtension.class)
public class NoteServImpTests {

    @Mock
    private INoteRepository noteRepository;

    @Mock
    private IEtudiantRepository etudiantRepository;

    @Mock
    private IMatiereRepository matiereRepository;

    @InjectMocks
    private NoteServImp noteService;

    @Test
    public void testAjouterNote() {
        Note note = new Note();
        note.setId(1L);
        when(noteRepository.save(note)).thenReturn(note);

        Note savedNote = noteService.ajouter_NOTE(note);

        assertNotNull(savedNote);
        assertEquals(1L, savedNote.getId());
    }

    @Test
    public void testAddListNotes() {
        Note note1 = new Note();
        note1.setId(1L);
        Note note2 = new Note();
        note2.setId(2L);
        List<Note> notes = new ArrayList<>();
        notes.add(note1);
        notes.add(note2);

        when(noteRepository.saveAll(notes)).thenReturn(notes);

        List<Note> savedNotes = noteService.addlistNotes(notes);

        assertNotNull(savedNotes);
        assertEquals(2, savedNotes.size());
    }

    @Test
    public void testChercherNote() {
        Note note = new Note();
        note.setId(1L);
        Optional<Note> optionalNote = Optional.of(note);
        when(noteRepository.findById(anyLong())).thenReturn(optionalNote);

        Note retrievedNote = noteService.chercher_Note(1L);

        assertNotNull(retrievedNote);
        assertEquals(1L, retrievedNote.getId());
    }

    // Ajoutez des tests pour les autres méthodes de service comme modifier_NOTE, supprimer_NOTE, etc.
}

