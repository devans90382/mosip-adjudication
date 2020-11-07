package io.mosip.adjudication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.mosip.adjudication.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
