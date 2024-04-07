package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Module;
import com.example.demo.entities.Specialite;
@Repository
public interface ISpecialiteRepository extends CrudRepository <Specialite,Long>{

}
