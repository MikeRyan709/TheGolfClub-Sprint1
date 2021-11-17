package com.sprint.assessingdatarest.repository;

import java.util.List;

import com.sprint.assessingdatarest.Members;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Members", path = "Members")
public interface MemberRepository extends PagingAndSortingRepository<Members, Long> {
    default List<Members> findByLastName(@Param("name") String name) {
        return null;
    }
}
