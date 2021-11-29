package com.sprint.assessingdatarest.controllers;

import com.sprint.assessingdatarest.previousTournament;
import com.sprint.assessingdatarest.repository.previousTournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class previousTournamentController {
    @Autowired
    previousTournamentRepository previousTournamentRepository;

    @GetMapping("/previousTournament")
    public ResponseEntity<List<previousTournament>> getPreviousTournament(@RequestParam(required = false) LocalDate previousTournamentDate) {
        try {
            List<previousTournament> previousTournament = new ArrayList<>();

            if (previousTournamentDate == null) {
                previousTournamentRepository.findAll().forEach(previousTournament::add);
            } else
                previousTournament.addAll(previousTournamentRepository.findByPreviousTournamentDate(previousTournamentDate));

            if (previousTournament.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(previousTournament, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/previousTournament")
    public ResponseEntity<previousTournament> postPreviousTournament(@RequestBody previousTournament previousTournament) {
        try {
            previousTournament _previousTournament = previousTournamentRepository
                    .save(new previousTournament(previousTournament.getId(), previousTournament.getPreviousTournamentDate(), previousTournament.getTournament()));
            return new ResponseEntity<>(_previousTournament, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/previousTournament/{id}")
    public ResponseEntity<previousTournament> putPreviousTournament(@PathVariable("Id") long id, @RequestBody previousTournament previousTournament) {
        Optional<previousTournament> previousTournamentUpdate = previousTournamentRepository.findById(id);

        if (previousTournamentUpdate.isPresent()) {
            previousTournament _previousTournament = previousTournamentUpdate.get();
            _previousTournament.setTournament(previousTournament.getTournament());
            _previousTournament.setPreviousTournamentDate(previousTournament.getPreviousTournamentDate());

            return new ResponseEntity<>(previousTournamentRepository.save(_previousTournament), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deletePreviousTournament (@PathVariable("id") long id) {
        try {
            previousTournamentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
