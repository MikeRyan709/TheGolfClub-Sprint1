package com.sprint.assessingdatarest.repository;

import java.util.List;

import com.sprint.assessingdatarest.Tournaments;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Tournaments", path = "Tournaments" +
        "t")
public interface TournamentsRepository extends PagingAndSortingRepository<Tournaments, Long> {
    default List<Tournaments> findByStartDate(@Param("startDate") String startDate) {
        return null;
    }
}