package com.sprint.assessingdatarest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Tournaments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tournament_Id;

    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private float entryFee;
    private float cashPrize;
    private String participant;
    private String finalStandings;

    public Tournaments(long tournament_Id, LocalDate startDate, LocalDate endDate, String location, float entryFee, float cashPrize, String participant, String finalStandings) {
        super();
        this.tournament_Id = tournament_Id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.entryFee = entryFee;
        this.cashPrize = cashPrize;
        this.participant = participant;
        this.finalStandings = finalStandings;
    }

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

    public float getCashPrize() {
        return cashPrize;
    }

    public void setCashPrize(float cashPrize) {
        this.cashPrize = cashPrize;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public String getFinalStandings() {
        return finalStandings;
    }

    public void setFinalStandings(String finalStandings) {
        this.finalStandings = finalStandings;
    }
}
