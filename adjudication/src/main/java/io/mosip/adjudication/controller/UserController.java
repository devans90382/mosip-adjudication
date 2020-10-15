package io.mosip.adjudication.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.mosip.adjudication.model.User;
import io.mosip.adjudication.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {

private final UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	@GetMapping("/")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{user_id}")
    public User getById(@PathVariable Long user_id) {
    	return userRepository.findById(user_id).get(); 
    }

    @PostMapping("/post")
    public User addUser(@RequestBody User user) {
    	return userRepository.save(user); 
    }
}
