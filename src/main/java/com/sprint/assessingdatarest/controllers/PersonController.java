package com.sprint.assessingdatarest.controllers;

import com.sprint.assessingdatarest.Person;
import com.sprint.assessingdatarest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/person")
    public ResponseEntity<List<Person>> getPerson(@RequestParam(required = false) String firstName, String lastName) {
        try {
            List<Person> person = new ArrayList<>();

            if (lastName == null && firstName == null)
                personRepository.findAll().forEach(person::add);
            else if (lastName == null)
                person.addAll(personRepository.findByFirstName(firstName));
            else
                person.addAll(personRepository.findByLastName(lastName));

            if (person.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(person, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/person")
    public ResponseEntity<Person> postPerson(@RequestBody Person person) {
        try {
            Person _person = personRepository
                    .save(new Person(person.getFirstName(), person.getLastName(), person.getEmail(), person.getPhone()));
            return new ResponseEntity<>(_person, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Person> putPerson(@PathVariable("Id") long id, @RequestBody Person person) {
        Optional<Person> personUpdate = personRepository.findById(id);

        if (personUpdate.isPresent()){
            Person _person = personUpdate.get();
            _person.setFirstName(person.getFirstName());
            _person.setLastName(person.getLastName());
            _person.setEmail(person.getEmail());
            _person.setPhone(person.getPhone());

            return  new ResponseEntity<>(personRepository.save(_person), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
