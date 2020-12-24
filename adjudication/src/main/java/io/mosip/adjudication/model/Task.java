package io.mosip.adjudication.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	  
	@OneToMany
	private List<Job> jobs = new ArrayList<>();
	
	@Column
	private String requestId;
	
	@OneToOne
	private Person primary;
	
	@OneToMany
	private List<Person> personList;
	
	@Enumerated(EnumType.STRING)
    private Status status;
	
	@Column
	private Timestamp updated_at;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public Person getPrimary() {
		return primary;
	}

	public void setPrimary(Person primary) {
		this.primary = primary;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	Task(){
		this.status = Status.OPEN;
		this.updated_at = new Timestamp(System.currentTimeMillis());
	}
//	public Person getPrimary() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
