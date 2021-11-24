package com.sprint.assessingdatarest.repository;

import com.sprint.assessingdatarest.upcomingTournament;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "upcomingTournament", path = "upcomingTournament")
public interface upcomingTournamentRepository extends PagingAndSortingRepository <upcomingTournament, Long> {
        List<upcomingTournament> findByUpcomingTournamentDate(@Param("upcomingTournament") LocalDate upcomingTournament);
}


