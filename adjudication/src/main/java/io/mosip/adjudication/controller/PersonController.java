package io.mosip.adjudication.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.mosip.adjudication.model.Person;
import io.mosip.adjudication.repository.PersonRepository;

@RestController
@RequestMapping("/api/person")
public class PersonController {

	private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/")
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @GetMapping("/{person_id}")
    public Person getById(@PathVariable Long person_id) {
    	return personRepository.findById(person_id).get(); 
    }

    @PostMapping("/post")
    public Person addPerson(@RequestBody Person person) {
    	return personRepository.save(person); 
    }
}