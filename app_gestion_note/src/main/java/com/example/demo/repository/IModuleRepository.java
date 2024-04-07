package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Module;

@Repository
public interface IModuleRepository extends CrudRepository<Module,Long>{

}
