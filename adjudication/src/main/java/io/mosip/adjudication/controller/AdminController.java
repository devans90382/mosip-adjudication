package io.mosip.adjudication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mosip.adjudication.model.Admin;
import io.mosip.adjudication.model.Job;
import io.mosip.adjudication.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("/post")
    public String addAdmin(@RequestBody Admin admin) {
    	adminService.addAdmin(admin);
    	return "Success";
    }
	
	@GetMapping("/")
	public List<Job> findAll() {
		return adminService.findAllJobs();
	}
	
	@PostMapping("/reassign")
	public String reassignJob(@RequestBody Job job) {
		return adminService.getNewAdjudicator(job.getId());
	}
}
