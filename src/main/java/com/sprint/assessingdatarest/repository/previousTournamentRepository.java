package com.sprint.assessingdatarest.repository;

import com.sprint.assessingdatarest.previousTournament;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "previousTournament", path = "previousTournament")
public interface previousTournamentRepository  extends PagingAndSortingRepository <previousTournament, Long> {
    List<previousTournament> findByPreviousTournamentDate(@Param("previousTournamentDate") LocalDate previousTournamentDate);
}
