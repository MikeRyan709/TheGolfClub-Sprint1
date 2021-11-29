package com.sprint.assessingdatarest.controllers;

import com.sprint.assessingdatarest.Tournament;
import com.sprint.assessingdatarest.repository.TournamentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins ="http://localhost:8080")
@RestController
@RequestMapping("/api")
public class TournamentController {
    @Autowired
    TournamentsRepository tournamentsRepository;
    public ResponseEntity<List<Tournament>> getTournaments(@RequestParam(required = false) String startDate){
        try {
            List<Tournament> tournament = new ArrayList<>();

            if (startDate == null)
                tournamentsRepository.findAll().forEach(tournament::add);
            else
                tournament.addAll(tournamentsRepository.findByStartDate(startDate));

            if (tournament.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tournament, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
