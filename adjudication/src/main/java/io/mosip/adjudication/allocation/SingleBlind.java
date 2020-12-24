package io.mosip.adjudication.allocation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import io.mosip.adjudication.model.Job;
import io.mosip.adjudication.model.Task;
import io.mosip.adjudication.model.Adjudicator;
import io.mosip.adjudication.repository.AdjudicatorRepository;
import io.mosip.adjudication.repository.JobRepository;

public class SingleBlind {
	
	@Autowired
	private AdjudicatorRepository adjudicatorRepository;
	
	@Autowired
	private JobRepository jobRepository;
	
	public SingleBlind(AdjudicatorRepository userRespository, JobRepository jobRepository) {
		this.adjudicatorRepository = userRespository;
		this.jobRepository = jobRepository;
	}
	
	public void allocateTask(Task t) {
		
		List<Job> jobList = t.getJobs();
		Adjudicator adjudicator = adjudicatorRepository.findNewUser();
		
		if(adjudicator == null)
			adjudicator = adjudicatorRepository.findbyJobs();
		
		Job j = jobList.get(0);
		j.setAdjudicator(adjudicator);
		jobRepository.save(j);
		
		for(int i = 1; i < jobList.size(); i++) {
			adjudicator = adjudicatorRepository.findNewUser();
			if(adjudicator == null)
				adjudicator = adjudicatorRepository.findbyJobs();
			j = jobList.get(i);
			j.setAdjudicator(adjudicator);
			jobRepository.save(j);
		}
		
	}

}