package com.sprint.assessingdatarest.controllers;

import com.sprint.assessingdatarest.Person;
import com.sprint.assessingdatarest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/person")
    public ResponseEntity<List<Person>> getPerspn(@RequestParam(required = false) String firstName, String lastName) {
        try {
            List<Person> people = new ArrayList<>();

            if (lastName == null && firstName == null)
                personRepository.findAll().forEach(people::add);
            else if (lastName == null)
                people.addAll(personRepository.findByFirstName(firstName));
            else
                people.addAll(personRepository.findByLastName(lastName));

            if (people.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(people, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
