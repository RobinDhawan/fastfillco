package com.nurds.fastfillco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public Response getMedicineDetails(long id) {
	
		Response res = new Response();
		DoctorMedicine doc = null;
		try {

			doc = docMedicineDao.getMedicineDetail(id);
		}
		catch (Exception ex) {
			res.setResponseCode("500");
			res.setError("Login Failed");
			return res;
		}
		res.setResponseCode("200");
		res.setObject(doc);
		return res;
	}

	@RequestMapping(value="/doctormedicine/create")
	@ResponseBody
	public Response createDocMedicine(@RequestBody DoctorMedicine medicine) {
		System.out.println(medicine);
		Response res = new Response();
		try {
			
			docMedicineDao.create(medicine);
		}
		catch (Exception ex) {
			res.setResponseCode("500");
			res.setError("Medicine Creation Failed");
			return res;
		}
		res.setResponseCode("200");
		ResponseString str = new ResponseString();
		str.setResponse("Medicine Allocated Successfully");
		return res;
	}


} 
