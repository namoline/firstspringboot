package com.spring.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.demo.model.Person;

public interface PersonRepository extends JpaRepository<Person,Long> {
	@Query("select p from Person p where p.nom = ?1 and p.prenom=?2")
	List<Person> findByNomAndPrenom(String nom,String prenom);
}
