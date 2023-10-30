package com.spring.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="person")
public class Person {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="person_id")
	public long id;
	@Column(name="last_name")
	public String nom;
	@Column(name="first_name")
	public String prenom;
	
	
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
}
