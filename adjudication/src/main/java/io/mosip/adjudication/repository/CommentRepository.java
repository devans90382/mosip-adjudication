package io.mosip.adjudication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.mosip.adjudication.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

}
