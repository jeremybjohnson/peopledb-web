package com.jeremybjohnson.peopledbweb.data;

import com.jeremybjohnson.peopledbweb.biz.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
    @Query(nativeQuery = true, value = "SELECT id FROM person WHERE id IN :ids")
    public Set<String> findFilenamesByIds(@Param("ids") Iterable<Long> ids);
}
