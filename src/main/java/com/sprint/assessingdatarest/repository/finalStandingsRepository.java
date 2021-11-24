package com.sprint.assessingdatarest.repository;

import com.sprint.assessingdatarest.finalStandings;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "finalStandings", path = "finalStandings")

public interface finalStandingsRepository extends PagingAndSortingRepository<finalStandings, Long> {
    List<finalStandings> findById(@Param("id") int id);
}
