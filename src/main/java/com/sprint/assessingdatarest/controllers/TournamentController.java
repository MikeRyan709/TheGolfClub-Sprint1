package com.sprint.assessingdatarest.controllers;

import com.sprint.assessingdatarest.Tournament;
import com.sprint.assessingdatarest.repository.TournamentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/Tournament")
    public ResponseEntity<Tournament> postTournament (@RequestBody Tournament tournament) {
        try {
            Tournament _tournament = tournamentsRepository
                    .save(new Tournament(tournament.getTournament_Id(), tournament.getStartDate(), tournament.getEndDate(), tournament.getLocation(), tournament.getEntryFee(), tournament.getPrize(), tournament.getParticipant(), tournament.getFinalStandings()));
            return new ResponseEntity<>(_tournament, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
