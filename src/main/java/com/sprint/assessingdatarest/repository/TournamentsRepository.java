package com.sprint.assessingdatarest.repository;

import java.util.List;

import com.sprint.assessingdatarest.Tournament;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Tournaments", path = "Tournaments" +
        "t")
public interface TournamentsRepository extends PagingAndSortingRepository<Tournament, Long> {
    default List<Tournament> findByStartDate(@Param("startDate") String startDate) {
        return null;
    }
}