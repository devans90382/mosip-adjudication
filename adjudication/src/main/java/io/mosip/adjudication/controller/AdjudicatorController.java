package io.mosip.adjudication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import io.mosip.adjudication.model.Adjudicator;
import io.mosip.adjudication.repository.AdjudicatorRepository;

@RestController
@RequestMapping("/api/user")
public class AdjudicatorController {

private final AdjudicatorRepository adjudicatorRepository;
	
	public AdjudicatorController(AdjudicatorRepository adjudicatorRepository) {
        this.adjudicatorRepository = adjudicatorRepository;
    }
	
	@GetMapping("/")
    public List<Adjudicator> getAll() {
        return adjudicatorRepository.findAll();
    }

	@GetMapping("/{user_id}")
    public Adjudicator getById(@PathVariable Long user_id) {
    	return adjudicatorRepository.findById(user_id).get();
    }

    @PostMapping("/post")
    public Adjudicator addUser(@RequestBody Adjudicator adjudicator) {
    	return adjudicatorRepository.save(adjudicator);
    }
    
    @PostMapping("/update")
    @ResponseStatus(value = HttpStatus.OK)
    public void changeStatus(@RequestParam(name = "id") Long user_id, @RequestParam(name = "online") boolean on) {
    	Adjudicator adjudicator = adjudicatorRepository.findById(user_id).get();
    	adjudicator.setOnline(on);
    	adjudicatorRepository.save(adjudicator);
    }
}