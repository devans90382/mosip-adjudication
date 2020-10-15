package io.mosip.adjudication.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.mosip.adjudication.model.Job;
import io.mosip.adjudication.repository.JobRepository;

@RestController
@RequestMapping("/api/job")
public class JobController {

    private JobRepository jobRepository;
    
    public JobController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @GetMapping("/")
    public List<Job> getAll() {
    	return jobRepository.findAll(); 
    }

    @GetMapping("/{job_id}")
    public Job getById(@PathVariable Long job_id) {
    	return jobRepository.findById(job_id).get(); 
    }

    @GetMapping("/user/{user_id}")
    public List<Job> getByUserId(@PathVariable Long user_id) { 
    	return jobRepository.findByUser_Id(user_id);
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
}
