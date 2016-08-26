package com.nurds.fastfillco.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.nurds.fastfillco.ResponseObject;

/**
 * Represents an User for this web application.
 */
@Entity
@Table(name = "medicine")
public class DoctorMedicine extends ResponseObject implements Serializable {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
@Id
  private String medicineName;
  
  @Id 
  private String expiryDate;
  
  private String mClass;
  
  private String subClass;
  
  private String numPillPerBox;
  
  private String numOfBoxes;
  
  private String lotNumber;
  
  private String locationSample;
  
  private int numVoucher;
  
  private String voucherInsurance;
  
  private String voucherExpiryDate;
  
  private String couponsExpiryDate;
  
  @ManyToOne
  private Doctor doctor;

  public String getMedicineName() {
	return medicineName;
  }

public void setMedicineName(String medicineName) {
	this.medicineName = medicineName;
}

public String getExpiryDate() {
	return expiryDate;
}

public void setExpiryDate(String expiryDate) {
	this.expiryDate = expiryDate;
}

public String getmClass() {
	return mClass;
}

public void setmClass(String mClass) {
	this.mClass = mClass;
}

public String getSubClass() {
	return subClass;
}

public void setSubClass(String subClass) {
	this.subClass = subClass;
}

public String getNumPillPerBox() {
	return numPillPerBox;
}

public void setNumPillPerBox(String numPillPerBox) {
	this.numPillPerBox = numPillPerBox;
}

public String getNumOfBoxes() {
	return numOfBoxes;
}

public void setNumOfBoxes(String numOfBoxes) {
	this.numOfBoxes = numOfBoxes;
}

public String getLotNumber() {
	return lotNumber;
}

public void setLotNumber(String lotNumber) {
	this.lotNumber = lotNumber;
}

public String getLocationSample() {
	return locationSample;
}

public void setLocationSample(String locationSample) {
	this.locationSample = locationSample;
}

public int getNumVoucher() {
	return numVoucher;
}

public void setNumVoucher(int numVoucher) {
	this.numVoucher = numVoucher;
}

public String getVoucherInsurance() {
	return voucherInsurance;
}

public void setVoucherInsurance(String voucherInsurance) {
	this.voucherInsurance = voucherInsurance;
}

public String getVoucherExpiryDate() {
	return voucherExpiryDate;
}

public void setVoucherExpiryDate(String voucherExpiryDate) {
	this.voucherExpiryDate = voucherExpiryDate;
}

public String getCouponsExpiryDate() {
	return couponsExpiryDate;
}

public void setCouponsExpiryDate(String couponsExpiryDate) {
	this.couponsExpiryDate = couponsExpiryDate;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public Doctor getDoctor() {
	return doctor;
}

public void setDoctor(Doctor doctor) {
	this.doctor = doctor;
}

@Override
public String toString() {
	return "DoctorMedicine [id=" + id + ", medicineName=" + medicineName
			+ ", expiryDate=" + expiryDate + ", mClass=" + mClass
			+ ", subClass=" + subClass + ", numPillPerBox=" + numPillPerBox
			+ ", numOfBoxes=" + numOfBoxes + ", lotNumber=" + lotNumber
			+ ", locationSample=" + locationSample + ", numVoucher="
			+ numVoucher + ", voucherInsurance=" + voucherInsurance
			+ ", voucherExpiryDate=" + voucherExpiryDate
			+ ", couponsExpiryDate=" + couponsExpiryDate + ", doctor=" + doctor
			+ "]";
}


  
  // ------------------------
  // PUBLIC METHODS
  // ------------------------

  
  
} // class User
