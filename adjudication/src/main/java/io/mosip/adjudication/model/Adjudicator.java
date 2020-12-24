package io.mosip.adjudication.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "adjudicator")
public class Adjudicator {
	
    @Id
    @Column(unique = true)
    private String username;
    
    @Column(name = "Location") 
    private String location;
    
    @Column(name = "isOnline")
    private boolean online;
    
    @OneToMany
    private List<Job> assignedJobs;
    
    public Adjudicator() {
    
    }
    
    public Adjudicator(String username) {
		this.username = username;
	}
	
	public Adjudicator(String location, boolean online) {
		super();
		this.location = location;
		this.online = online;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Adjudicator [username=" + username + ", location=" + location + ", online=" + online + ", assignedJobs="
				+ assignedJobs + "]";
	}
}
