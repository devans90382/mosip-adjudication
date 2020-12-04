package io.mosip.adjudication.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "adjudicator")
public class Adjudicator {
	
    @Id 
    @GeneratedValue(strategy= GenerationType.IDENTITY) 
    private Long id;
    
    @Column(name = "location")
    private String location;
    
    @Column(name = "user_name", unique = true)
    private String userName;
    
    @OneToMany
    private List<Job> assignedJobs;
    
    public Adjudicator() {
    }

    public Adjudicator(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	@Override
	public String toString() {
		return "User [id=" + id + "]";
	}
}
