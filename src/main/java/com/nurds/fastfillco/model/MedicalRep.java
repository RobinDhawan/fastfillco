package com.nurds.fastfillco.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Represents an User for this web application.
 */
@Entity
@Table(name = "medicalRep")
public class MedicalRep {

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @NotNull
  private String username;
  
  @NotNull
  private String firstName;
  
  private String lastName;
  
  @NotNull
  private String password;
  
  private int mobileNumber;
  
  private String companyName;
  
  
  public MedicalRep() { }

 

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
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

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getMobileNumber() {
	return mobileNumber;
}

public void setMobileNumber(int mobileNumber) {
	this.mobileNumber = mobileNumber;
}



public String getCompanyName() {
	return companyName;
}

public void setCompanyName(String companyName) {
	this.companyName = companyName;
}

public MedicalRep(long id) { 
    this.id = id;
  }
  
  

  public long getId() {
    return id;
  }

  public void setId(long value) {
    this.id = value;
  }

  
} // class User
