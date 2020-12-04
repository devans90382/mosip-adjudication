package io.mosip.adjudication.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


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

    public Adjudicator getUser() {
        return adjudicator;
    }

    public void setUser(Adjudicator adjudicator) {
        this.adjudicator = adjudicator;
    }

    @ManyToOne Adjudicator adjudicator;

    public Job() {
    }

    public Job(Status status, Person firstPerson, Person secondPerson) {
        this.status = status;
        this.firstPerson = firstPerson;
        this.secondPerson = secondPerson;
    }

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

	@Override
	public String toString() {
		return "Job [id=" + id + ", status=" + status + ", firstPerson=" + firstPerson + ", secondPerson="
				+ secondPerson + ", adj=" + adjudicator + "]";
	}
    
}
