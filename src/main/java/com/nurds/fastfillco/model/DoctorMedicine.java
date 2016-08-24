package com.nurds.fastfillco.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Represents an User for this web application.
 */
@Entity
@Table(name = "medicine")
public class DoctorMedicine implements Serializable{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
  
  // ------------------------
  // PUBLIC METHODS
  // ------------------------

  
  
} // class User
