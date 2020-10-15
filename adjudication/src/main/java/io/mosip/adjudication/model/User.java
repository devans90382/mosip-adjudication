package io.mosip.adjudication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adjudicator")
public class User {
	
    @Id 
    @GeneratedValue(strategy= GenerationType.IDENTITY) 
    private Long id;
    
    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	@Override
	public String toString() {
		return "User [id=" + id + "]";
	}
}
