package com.sprint.assessingdatarest;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    @JoinColumn(name = "personID")
    private Person person;
    private LocalDate membershipStart;
    private String membershipType;
    private String currentTournament;
    private String previousTournament;

    public Members(long id, Person person, LocalDate membershipStart, String membershipType, String currentTournament, String previousTournament) {
        this.id = id;
        this.person = person;
        this.membershipStart = membershipStart;
        this.membershipType = membershipType;
        this.currentTournament = currentTournament;
        this.previousTournament = previousTournament;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LocalDate getMembershipStart() {
        return membershipStart;
    }

    public void setMembershipStart(LocalDate membershipStart) {
        this.membershipStart = membershipStart;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String getCurrentTournament() {
        return currentTournament;
    }

    public void setCurrentTournament(String currentTournament) {
        this.currentTournament = currentTournament;
    }

    public String getPreviousTournament() {
        return previousTournament;
    }

    public void setPreviousTournament(String previousTournament) {
        this.previousTournament = previousTournament;
    }
}


