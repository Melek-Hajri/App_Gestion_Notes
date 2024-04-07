package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Note;

@Repository
public interface INoteRepository extends CrudRepository<Note, Long>{
	@Query("SELECT n FROM Note WHERE n.etudiant_id = :idEtd and n.matiere_idmatiere = :idMatiere")
	List<Note> findByEtdMatiere(@Param("idEtd") Long idEtd, @Param("idMatiere") Long idMatiere);
}
