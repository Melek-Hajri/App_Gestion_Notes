package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.demo.entities.Classe;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Note;
import com.example.demo.repository.IClasseRepository;
import com.example.demo.repository.IEtudiantRepository;
import com.example.demo.repository.INoteRepository;
import com.example.demo.services.EtudiantServImp;
@ExtendWith(MockitoExtension.class)
public class EtudiantServImpTests {
    @Mock
    private IEtudiantRepository etudiantRepository;
    @Mock
    private IClasseRepository classeRepository;
    @Mock
    private INoteRepository noteRepository;
    @InjectMocks
    private EtudiantServImp etudiantService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testAjouterEtudiant() {
        Etudiant etudiant = new Etudiant();
        etudiant.setId(1L);
        etudiant.setNom("John");
        etudiant.setPrenom("Doe");
        when(etudiantRepository.save(etudiant)).thenReturn(etudiant);
        Etudiant savedEtudiant = etudiantService.ajouter_ETD(etudiant);
        assertNotNull(savedEtudiant);
        assertEquals(1L, savedEtudiant.getId());
        assertEquals("John", savedEtudiant.getNom());
        assertEquals("Doe", savedEtudiant.getPrenom());
    }
    @Test
    public void testChercherEtudiant() {
        Etudiant etudiant = new Etudiant();
        etudiant.setId(1L);
        Optional<Etudiant> optionalEtudiant = Optional.of(etudiant);
        when(etudiantRepository.findById(1L)).thenReturn(optionalEtudiant);
        Etudiant retrievedEtudiant = etudiantService.chercher_ETD(1L);
        assertNotNull(retrievedEtudiant);
        assertEquals(1L, retrievedEtudiant.getId());
    }
    @Test
    public void testSupprimerEtudiant() {
        Etudiant etudiant = new Etudiant();
        etudiant.setId(1L);
        List<Note> notes = new ArrayList<>();
        when(noteRepository.findByEtd(1L)).thenReturn(notes);
        etudiantService.supprimer_ETD(1L);
        assertNull(etudiantService.chercher_ETD(1L));
    }
    @Test
    public void testAfficherEtudiants() {
        List<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(new Etudiant());
        etudiants.add(new Etudiant());
        when(etudiantRepository.findAll()).thenReturn(etudiants);
        List<Etudiant> retrievedEtudiants = etudiantService.afficher_ETD();
        assertNotNull(retrievedEtudiants);
        assertEquals(2, retrievedEtudiants.size());
    }
    // Ajoutez des tests pour les autres méthodes ici...
}

