package com.sprint.assessingdatarest.controllers;

import com.sprint.assessingdatarest.Members;
import com.sprint.assessingdatarest.finalStandings;
import com.sprint.assessingdatarest.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class MemberController {
    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/Members")
    public ResponseEntity<List<Members>> getMembers(@RequestParam(required = false) Integer id) {
        try {
            List<Members> member = new ArrayList<>();

            if (id == null) {
                memberRepository.findAll().forEach(member::add);
            } else
                member.addAll(memberRepository.findById(id));

            if (member.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(member, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/Members")
    public ResponseEntity<Members> postMembers(@RequestBody Members member) {
        try {
            Members _member = memberRepository
                    .save(new Members(member.getPerson(), member.getCurrentTournament(), member.getPreviousTournament(), member.getMembershipType(), member.getMembershipStart()));
            return new ResponseEntity<>(_member, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/Members/{id}")
    public ResponseEntity<Members> putMembers(@PathVariable("Id") long id, @RequestBody Members members) {
        Optional<Members> memberUpdate = memberRepository.findById(id);

        if (memberUpdate.isPresent()) {
            Members _member = memberUpdate.get();
            _member.setPerson(members.getPerson());
            _member.setMembershipType(members.getMembershipType());
            _member.setMembershipStart(members.getMembershipStart());
            _member.setCurrentTournament(members.getCurrentTournament());
            _member.setPreviousTournament(members.getPreviousTournament());

            return new ResponseEntity<>(memberRepository.save(_member), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<Members> deleteMembers(@PathVariable("id") long id) {
        try {
            memberRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}