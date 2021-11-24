package com.sprint.assessingdatarest;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class upcomingTournament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate upcomingTournament;

    @ManyToOne
    @JoinColumn(name = "upcoming_tournament_id")
    private Tournament tournament;

    public upcomingTournament(long id, LocalDate upcomingTournament, Tournament tournament) {
        this.id = id;
        this.upcomingTournament = upcomingTournament;
        this.tournament = tournament;
    }
    //Getters and Setters //
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getUpcomingTournament() {
        return upcomingTournament;
    }

    public void setUpcomingTournament(LocalDate upcomingTournament) {
        this.upcomingTournament = upcomingTournament;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
}
