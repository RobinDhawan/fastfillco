package com.nurds.fastfillco.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.nurds.fastfillco.ResponseObject;

/**
 * Represents an User for this web application.
 */
@Entity
@Table(name = "doctor")
public class Doctor extends ResponseObject{

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
  
  private String mobileNumber;
  
  private String speciality;
  
  private String clinicName;
  
  @OneToMany
  private List<DoctorMedicine> medicines;
  
  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  	
  
  public List<DoctorMedicine> getMedicines() {
	return medicines;
}

public void setMedicines(List<DoctorMedicine> medicines) {
	this.medicines = medicines;
}

public Doctor() { }

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

public String getMobileNumber() {
	return mobileNumber;
}

public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}

public String getSpeciality() {
	return speciality;
}

public void setSpeciality(String speciality) {
	this.speciality = speciality;
}

public String getClinicName() {
	return clinicName;
}

public void setClinicName(String clinicName) {
	this.clinicName = clinicName;
}

public Doctor(long id) { 
    this.id = id;
  }
  
  

  public long getId() {
    return id;
  }

  public void setId(long value) {
    this.id = value;
  }

  
} // class User
