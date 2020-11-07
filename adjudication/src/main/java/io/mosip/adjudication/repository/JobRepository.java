package io.mosip.adjudication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.mosip.adjudication.model.Job;
import io.mosip.adjudication.model.Person;
import io.mosip.adjudication.model.Adjudicator;

@Repository
public interface JobRepository extends JpaRepository<Job,Long>{
//	public List<Job> findByUser_Id(Long id);
    public List<Job> findByFirstPerson_Id(Long id);
    public List<Job> findBySecondPerson_Id(Long id);
//    public List<Job> findByUser(Adjudicator adjudicator);
    public List<Job> findByFirstPerson(Person person);
    public List<Job> findBySecondPerson(Person person);
}
