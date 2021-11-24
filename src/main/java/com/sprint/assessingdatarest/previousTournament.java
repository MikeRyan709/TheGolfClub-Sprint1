package com.sprint.assessingdatarest;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class previousTournament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate previousTournamentDate;
    @ManyToOne
    @JoinColumn(name = "previous_tournament_id")
    private Tournament tournament;

    public previousTournament(long id, LocalDate previousTournamentDate, Tournament tournament) {
        this.id = id;
        this.previousTournamentDate = previousTournamentDate;
        this.tournament = tournament;
    }
    // Geters and Setters //
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getPreviousTournamentDate() {
        return previousTournamentDate;
    }

    public void setPreviousTournamentDate(LocalDate previousTournamentDate) {
        this.previousTournamentDate = previousTournamentDate;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
}
