package io.mosip.adjudication.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(uniqueConstraints= @UniqueConstraint(columnNames = {"firstName", "lastName"}))
public class Person {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    
    @Column(name = "firstName") 
    private String firstName;
    
    @Column(name = "lastName") 
    private String lastName;
    
    private String address;
    
    private String number;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date date_of_birth;

    public Person() {

    }
    
	public Person(String firstName, String lastName, String address, String number, Date date_of_birth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.number = number;
		this.date_of_birth = date_of_birth;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", number=" + number + ", date_of_birth=" + date_of_birth + "]";
	}
}
