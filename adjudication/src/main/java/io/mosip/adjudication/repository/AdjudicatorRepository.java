package io.mosip.adjudication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.mosip.adjudication.model.Job;
import io.mosip.adjudication.model.Adjudicator;

@Repository
public interface AdjudicatorRepository extends JpaRepository<Adjudicator, Long>{
//	Adjudicator findFirstByAssignedJobsOrderByAssignedJobsAsc(Job job);
	
	@Query(value = "select * from adjudicator u where u.id = (select adjudicator_id from job j where adjudicator_id is not null group by adjudicator_id order by count(*) asc limit 1)", nativeQuery = true)
	Adjudicator findbyJobs();

	@Query(value = "select * from adjudicator a where a.id in (select id from adjudicator) and a.id not in (select adjudicator_id from job where adjudicator_id is not null) limit 1", nativeQuery = true)
	Adjudicator findNewUser();
	
	Adjudicator findByUsername(String username);
	
	
}
