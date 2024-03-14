package com.example.usingrecdtojava.repository;

import java.util.UUID;
import com.example.usingrecdtojava.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, UUID> {
}