package com.spring.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.demo.model.Person;

public interface PersonRepository extends JpaRepository<Person,Long> {

}
