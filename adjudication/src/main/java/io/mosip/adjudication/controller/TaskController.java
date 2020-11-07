package io.mosip.adjudication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mosip.adjudication.allocation.SingleBlind;
import io.mosip.adjudication.model.Job;
import io.mosip.adjudication.model.Person;
import io.mosip.adjudication.model.Status;
import io.mosip.adjudication.model.Task;
import io.mosip.adjudication.model.Adjudicator;
import io.mosip.adjudication.repository.JobRepository;
import io.mosip.adjudication.repository.PersonRepository;
import io.mosip.adjudication.repository.TaskRepository;
import io.mosip.adjudication.repository.AdjudicatorRepository;

@RestController
@RequestMapping("/api/task")
public class TaskController {
	
	private TaskRepository taskRepository;
	private JobRepository jobRespository;
	private PersonRepository personRespository;
	private AdjudicatorRepository adjudicatorRepository;
	
	public TaskController(TaskRepository taskRepository, JobRepository jobRepository, 
			PersonRepository personRepository, AdjudicatorRepository adjudicatorRepository) {
		this.jobRespository = jobRepository;
		this.taskRepository = taskRepository;
		this.personRespository = personRepository;
		this.adjudicatorRepository = adjudicatorRepository;
		
	}
	
	@GetMapping("/")
	public List<Task> getAll() {
		return taskRepository.findAll();
	}
	
	@GetMapping("/{task_id}")
	public Task getTask(@PathVariable Long task_id) {
		return taskRepository.findById(task_id).get();
	}
	
	@PostMapping("/post")
	public void createJobs(@RequestBody Task t) {
		
		List<Person> compareList = t.getPersonList();
		personRespository.save(t.getPrimary());
		List<Job> jobList = new ArrayList<Job>();
		for(Person p : compareList) {
			personRespository.save(p);
			Job job = new Job();
			job.setFirstPerson(t.getPrimary());
			job.setSecondPerson(p);
			job.setStatus(Status.OPEN);
			jobList.add(job);
			jobRespository.save(job);
			
		}
		t.setJobs(jobList);
		taskRepository.save(t);
		(new SingleBlind(adjudicatorRepository, jobRespository)).allocateTask(t);
//		Job j = new Job();
//		j.setStatus(Status.OPEN);
//		User user = userRepository.findFirstByAssignedJobsOrderByAssignedJobsAsc(j);
//		System.out.println(user);
//		SingleBlind.allocateTask(t);
	}
	
	public void allocate_task(Task t) {
		
	}

}
