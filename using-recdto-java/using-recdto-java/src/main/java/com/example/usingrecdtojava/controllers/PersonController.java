package com.example.usingrecdtojava.controllers;

import com.example.usingrecdtojava.exceptions.NotFoundPersonException;
import com.example.usingrecdtojava.model.Person;
import com.example.usingrecdtojava.model.dto.PersonDTO;
import com.example.usingrecdtojava.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @PostMapping
    public ResponseEntity<PersonDTO> create(@RequestBody PersonDTO person){
        Person personObj = person.toPerson();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/personUUID")
    public ResponseEntity<PersonDTO> getPersonByUUID(@PathVariable UUID personUUID){
        Person personFindByID = this.personRepository.findById(personUUID)
                .orElseThrow(()-> new NotFoundPersonException("Nenhuma pessoa encontrada com este UUID" + personUUID));
        return ResponseEntity.ok().body(new PersonDTO(personFindByID));
    }
}
