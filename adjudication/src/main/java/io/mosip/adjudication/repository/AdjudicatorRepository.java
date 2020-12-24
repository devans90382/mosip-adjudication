package io.mosip.adjudication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.mosip.adjudication.model.Adjudicator;

@Repository
public interface AdjudicatorRepository extends JpaRepository<Adjudicator, String>{
//	Adjudicator findFirstByAssignedJobsOrderByAssignedJobsAsc(Job job);
	
	@Query(value = "select * from adjudicator u where u.username = (select adjudicator_username from job j where adjudicator_username is not null group by adjudicator_username order by count(*) asc limit 1)", nativeQuery = true)
	Adjudicator findbyJobs();

	@Query(value = "select * from adjudicator a where a.username in (select username from adjudicator) and a.username not in (select adjudicator_username from job where adjudicator_username is not null) limit 1", nativeQuery = true)
	Adjudicator findNewUser();
	
	//@Query(value = "select * from adjudicator a where a.online = true", nativeQuery = true)
	//List<Adjudicator> allOnlineUser();
}