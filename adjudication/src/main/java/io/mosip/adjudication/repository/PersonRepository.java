package io.mosip.adjudication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.mosip.adjudication.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
