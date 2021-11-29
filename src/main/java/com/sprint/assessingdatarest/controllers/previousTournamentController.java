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
}
