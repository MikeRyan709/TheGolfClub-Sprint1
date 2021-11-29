package com.sprint.assessingdatarest.controllers;

import com.sprint.assessingdatarest.Members;
import com.sprint.assessingdatarest.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
}

