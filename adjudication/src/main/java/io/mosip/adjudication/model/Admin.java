package io.mosip.adjudication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	
	@Id
    @Column(unique = true)
    private String username;

	public Admin() {
		super();
	}

	public Admin(String username) {
		this.username = username;
	}
}
