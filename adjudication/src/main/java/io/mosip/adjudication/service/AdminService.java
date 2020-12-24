package io.mosip.adjudication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mosip.adjudication.model.Adjudicator;
import io.mosip.adjudication.model.Admin;
import io.mosip.adjudication.repository.AdjudicatorRepository;
import io.mosip.adjudication.repository.AdminRepository;
import io.mosip.adjudication.repository.JobRepository;
import io.mosip.adjudication.model.Job;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AdminService {

	@Autowired
    AdminRepository adminRepository;
	
	@Autowired
	JobRepository jobRepository;
	
	@Autowired
	AdjudicatorRepository adjudicatorRepository;

	public void addAdmin(Admin admin) {
		adminRepository.save(admin);
	}
	
	public List<Job> findAllJobs() {
		return jobRepository.findAll();
	}

	public String getNewAdjudicator(Long id) {
		List<Adjudicator> allAdjudicators = adjudicatorRepository.findAll();
		List<Adjudicator> allOnlineAdjudicators = new ArrayList<>();
		String currentUser = jobRepository.findById(id).orElse(null).getAdjudicator().getUsername();
		for(Adjudicator a : allAdjudicators) {
			if(a.isOnline()) {
				if(a.getUsername().equals(currentUser)) {
					continue;
				}
				allOnlineAdjudicators.add(a);
			}
		}
		return allOnlineAdjudicators.get(new Random().nextInt(allOnlineAdjudicators.size())).getUsername();
	}	
}
