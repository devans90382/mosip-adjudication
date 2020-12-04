package io.mosip.adjudication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.mosip.adjudication.model.Adjudicator;
import io.mosip.adjudication.model.Job;
import io.mosip.adjudication.model.Status;
import io.mosip.adjudication.repository.AdjudicatorRepository;
import io.mosip.adjudication.repository.JobRepository;

@RestController
@RequestMapping("/api/job")
public class JobController {

    private JobRepository jobRepository;
    private AdjudicatorRepository adjudicatorRepository;
    
    public JobController(JobRepository jobRepository, AdjudicatorRepository adjudicatorRepository) {
        this.jobRepository = jobRepository;
        this.adjudicatorRepository = adjudicatorRepository;
    }

    @GetMapping("/")
    public List<Job> getAll() {
    	return jobRepository.findAll(); 
    }

    @GetMapping("/{job_id}")
    public Job getById(@PathVariable Long job_id) {
    	return jobRepository.findById(job_id).get(); 
    }

    @GetMapping("/user")
    public List<Job> getByUserId(@RequestParam(name = "username") String username) {
    	Adjudicator adj = adjudicatorRepository.findByUserName(username);
    	return jobRepository.findByAdjudicator(adj);
    }

    @GetMapping("/firstperson/{first_person_id}")
    public List<Job> getByFirstPersonId(@PathVariable Long first_person_id) { 
    	return jobRepository.findByFirstPerson_Id(first_person_id);
    }

    @GetMapping("/secondperson/{second_person_id}")
    public List<Job> getBySecondPersonId(@PathVariable Long second_person_id) { 
    	return jobRepository.findBySecondPerson_Id(second_person_id);
    }

    @PostMapping("/post")
    public Job addJob(@RequestBody Job job) {
    	return jobRepository.save(job);
    }
    
    @PostMapping("/update")
    public String updateJobStatus(@RequestParam(name = "id") Long jobId, @RequestParam(name = "status") String status) {
    	Job job = jobRepository.findById(jobId).get();
    	if(job != null)
    	{
    		if(job.getStatus() == Status.MATCH || job.getStatus() == Status.NO_MATCH)
    			return "Cannot update status";
    		else {
    			job.setStatus(Status.valueOf(status));
        		jobRepository.save(job);
        		return "Status updated";
    		}
    	}
    	return "Please check the job id";
    }
}
