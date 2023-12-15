package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	public Optional<Person> findById(Long id);

}
