package com.sprint.assessingdatarest;

import javax.persistence.*;

@Entity
public class finalStandings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
    private int finalScore;
    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    public finalStandings(long id, Person person, int finalScore, Tournament tournament) {
        this.id = id;
        this.person = person;
        this.finalScore = finalScore;
        this.tournament = tournament;
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

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
}



