package com.nurds.fastfillco.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nurds.fastfillco.DoctorMedcineResponse;
import com.nurds.fastfillco.DoctorMedicineRequest;
import com.nurds.fastfillco.Response;
import com.nurds.fastfillco.ResponseString;
import com.nurds.fastfillco.model.Doctor;
import com.nurds.fastfillco.model.DoctorMedicine;
import com.nurds.fastfillco.model.DoctorMedicineDao;
import com.nurds.fastfillco.model.UserDao;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private DoctorMedicineDao docMedicineDao;
	// ------------------------
	// PUBLIC METHODS
	// ------------------------

	/**
	 * Create a new user with an auto-generated id and email and name as passed 
	 * values.
	 */
	@RequestMapping(value="/registerdoctor" , method = RequestMethod.POST)
	@ResponseBody
	public Response registerDoctor(@RequestBody Doctor doctor) {
		Response res = new Response();
		try {
			userDao.create(doctor);
		}
		catch (Exception ex) {
			System.out.println(ex);
			res.setResponseCode("500");
			res.setError("Register Failed");
			return res;
		}
		res.setResponseCode("200");
		ResponseString str = new ResponseString();
		str.setResponse("User succesfully created!");
		res.setObject(str);
		return res;
	}

	/**
	 * Delete the user with the passed id.
	 */
	@RequestMapping(value="/logindoctor")
	@ResponseBody
	public Response loginDoctor(String username, String password) {
		System.out.println(username+password);
		Response res = new Response();
		Doctor doc = null;
		try {

			doc = userDao.login(username, password);
		}
		catch (Exception ex) {
			System.out.println(ex);
			res.setResponseCode("500");
			res.setError("Login Failed");
			return res;
		}
		res.setResponseCode("200");
		res.setObject(doc);
		return res;
	}
	
	@RequestMapping(value="/getdoctorMedicineDetails")
	@ResponseBody
	public Response getMedicineDetails(String userName) {
		Response res = new Response();
		List<DoctorMedicine> docList = null;
		try {

			docList = docMedicineDao.getMedicineDetails(userName);
		}
		catch (Exception ex) {
			System.out.println(ex);
			res.setResponseCode("500");
			res.setError("Login Failed");
			return res;
		}
		DoctorMedcineResponse resp = new DoctorMedcineResponse();
		resp.setMedicines(docList);
		res.setResponseCode("200");
		res.setObject(resp);
		return res;
	}

	@RequestMapping(value="/getdoctorMedicineDetail")
	@ResponseBody
	public Response getMedicineDetail(long id) {
		Response res = new Response();
		DoctorMedicine docList = null;
		try {

			docList = docMedicineDao.getMedicineDetail(id);
		}
		catch (Exception ex) {
			System.out.println(ex);
			res.setResponseCode("500");
			res.setError("Login Failed");
			return res;
		}
		res.setResponseCode("200");
		res.setObject(docList);
		return res;
	}
	@RequestMapping(value="/updatedoctorMedicineDetail")
	@ResponseBody
	public Response updateMedicineDetail(@RequestBody DoctorMedicine doc) {
		Response res = new Response();
		DoctorMedicine docList = null;
		try {

			docMedicineDao.updateMedicineDetails(doc);
		}
		catch (Exception ex) {
			System.out.println(ex);
			res.setResponseCode("500");
			res.setError("Login Failed");
			return res;
		}
		res.setResponseCode("200");
		ResponseString str = new ResponseString();
		str.setResponse("Medicine succesfully updated!");
		res.setObject(str);
		return res;
	}
	
	@RequestMapping(value="/doctormedicine/create")
	@ResponseBody
	public Response createDocMedicine(@RequestBody DoctorMedicineRequest medicineReq) {
		System.out.println(medicineReq);
		Doctor doc = userDao.getDoctor(medicineReq.getUserName());
		DoctorMedicine medicine = new DoctorMedicine();
		medicine.setCouponsExpiryDate(medicineReq.getCouponsExpiryDate());
		medicine.setDoctor(doc);
		medicine.setExpiryDate(medicineReq.getExpiryDate());
		medicine.setLocationSample(medicineReq.getLocationSample());
		medicine.setLotNumber(medicineReq.getLotNumber());
		medicine.setmClass(medicineReq.getmClass());
		medicine.setMedicineName(medicineReq.getMedicineName());
		medicine.setNumOfBoxes(medicineReq.getNumOfBoxes());
		medicine.setNumPillPerBox(medicineReq.getNumPillPerBox());
		medicine.setNumVoucher(medicineReq.getNumVoucher());
		medicine.setSubClass(medicineReq.getSubClass());
		medicine.setVoucherExpiryDate(medicineReq.getVoucherExpiryDate());
		medicine.setVoucherInsurance(medicineReq.getVoucherInsurance());
		Response res = new Response();
		try {
			
			docMedicineDao.create(medicine);
		}
		catch (Exception ex) {
			System.out.println(ex);
			res.setResponseCode("500");
			res.setError("Medicine Creation Failed");
			return res;
		}
		res.setResponseCode("200");
		ResponseString str = new ResponseString();
		str.setResponse("Medicine created successfully");
		return res;
	}


} 
