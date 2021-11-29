package com.sprint.assessingdatarest.controllers;

import com.sprint.assessingdatarest.finalStandings;
import com.sprint.assessingdatarest.repository.finalStandingsRepository;
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
public class finalStandingsController {
    @Autowired
    finalStandingsRepository finalStandingsRepository;

    @GetMapping("/finalStandings")
    public ResponseEntity<List<finalStandings>> getFinalStandings(@RequestParam(required = false) Integer id) {
        try {
            List<finalStandings> finalStandings = new ArrayList<>();

            if (id == null) {
                finalStandingsRepository.findAll().forEach(finalStandings::add);
            } else
                finalStandings.addAll(finalStandingsRepository.findById(id));

            if (finalStandings.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(finalStandings, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/finalStandings")
    public ResponseEntity<finalStandings> postFinalStandings(@RequestBody finalStandings finalStandings) {
        try {
            finalStandings _finalStandings = finalStandingsRepository
                    .save(new finalStandings(finalStandings.getId(), finalStandings.getPerson(), finalStandings.getFinalScore(), finalStandings.getTournament()));
            return new ResponseEntity<>(_finalStandings, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/finalStandings/{id}")
    public ResponseEntity<finalStandings> putFinalStandings(@PathVariable("Id") long id, @RequestBody finalStandings finalStandings){
        Optional<finalStandings> finalStandingsUpdate = finalStandingsRepository.findById(id);
        if (finalStandingsUpdate.isPresent()) {
            finalStandings _finalStandings = finalStandingsUpdate.get();
            _finalStandings.setPerson(finalStandings.getPerson());
            _finalStandings.setTournament(finalStandings.getTournament());
            _finalStandings.setFinalScore(finalStandings.getFinalScore());

            return new ResponseEntity<>(finalStandingsRepository.save(_finalStandings), HttpStatus.OK);
        } else {
            return new ResponseEntity<>((HttpStatus.NOT_FOUND));
        }
    }

    @DeleteMapping("/finalStandings/{id}")
    public ResponseEntity<HttpStatus> deleteFinalStandings (@PathVariable("id") long id) {
        try {
            finalStandingsRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
