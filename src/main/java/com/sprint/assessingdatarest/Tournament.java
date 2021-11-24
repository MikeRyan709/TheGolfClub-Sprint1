package com.sprint.assessingdatarest;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tournament_Id;

    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private float entryFee;
    private float prize;
    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Person participant;
    @ManyToOne
    @JoinColumn(name = "final_standings_id")
    private finalStandings finalStandings;

    public Tournament(long tournament_Id, LocalDate startDate, LocalDate endDate, String location, float entryFee, float prize, Person participant, com.sprint.assessingdatarest.finalStandings finalStandings) {
        this.tournament_Id = tournament_Id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.entryFee = entryFee;
        this.prize = prize;
        this.participant = participant;
        this.finalStandings = finalStandings;
    }
    //Getters and Setters //

    public long getTournament_Id() {
        return tournament_Id;
    }

    public void setTournament_Id(long tournament_Id) {
        this.tournament_Id = tournament_Id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(float entryFee) {
        this.entryFee = entryFee;
    }

    public float getPrize() {
        return prize;
    }

    public void setPrize(float prize) {
        this.prize = prize;
    }

    public Person getParticipant() {
        return participant;
    }

    public void setParticipant(Person participant) {
        this.participant = participant;
    }

    public com.sprint.assessingdatarest.finalStandings getFinalStandings() {
        return finalStandings;
    }

    public void setFinalStandings(com.sprint.assessingdatarest.finalStandings finalStandings) {
        this.finalStandings = finalStandings;
    }
}
