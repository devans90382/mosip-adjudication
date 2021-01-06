package io.mosip.adjudication.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Job {
//    public enum Status {
//        OPEN, WAIT, APPROVED, REJECTED;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private Status status;
    
    @OneToOne Person firstPerson;
    
    @OneToOne Person secondPerson;
    
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "E, dd MMM yyyy HH:mm:ss z", timezone = "GMT+2")
	private Timestamp created_at;
    
    @OneToMany
    private List<Comment> comment;

    @ManyToOne Adjudicator adjudicator;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Person getFirstPerson() {
		return firstPerson;
	}

	public void setFirstPerson(Person firstPerson) {
		this.firstPerson = firstPerson;
	}

	public Person getSecondPerson() {
		return secondPerson;
	}

	public void setSecondPerson(Person secondPerson) {
		this.secondPerson = secondPerson;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	

	public Adjudicator getAdjudicator() {
		return adjudicator;
	}

	public void setAdjudicator(Adjudicator adjudicator) {
		this.adjudicator = adjudicator;
	}

	public Job() {
		super();
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public Job(Status status, Person firstPerson, Person secondPerson, Timestamp created_at, List<Comment> comment,
			Adjudicator adjudicator) {
		super();
		this.status = status;
		this.firstPerson = firstPerson;
		this.secondPerson = secondPerson;
		this.created_at = created_at;
		this.comment = comment;
		this.adjudicator = adjudicator;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", status=" + status + ", firstPerson=" + firstPerson + ", secondPerson="
				+ secondPerson + ", created_at=" + created_at + ", comment=" + comment + ", adjudicator=" + adjudicator
				+ "]";
	}
}
