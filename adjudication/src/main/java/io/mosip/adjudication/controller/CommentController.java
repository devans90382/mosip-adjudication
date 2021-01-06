package io.mosip.adjudication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.mosip.adjudication.model.Comment;
import io.mosip.adjudication.repository.CommentRepository;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

	private CommentRepository commentRepository;
	
	public CommentController(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	@PostMapping("/post")
    public Comment addComment(@RequestBody Comment comment) {
    	return commentRepository.save(comment);
    }
	
	@GetMapping("/{job_id}")
	public List<Comment> getComments(@PathVariable Long job_id) {
		List<Comment> l = commentRepository.findAll();
		List<Comment> res = new ArrayList<>();
		for(Comment c : l) {
			if(c.getId() == job_id) {
				res.add(c);
			}
		}
		return res;
	}
}
