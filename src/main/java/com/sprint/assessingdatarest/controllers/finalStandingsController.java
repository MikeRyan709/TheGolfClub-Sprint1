package com.sprint.assessingdatarest.controllers;

import com.sprint.assessingdatarest.finalStandings;
import com.sprint.assessingdatarest.repository.finalStandingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
}
