package com.nurds.fastfillco.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nurds.fastfillco.DoctorListResponse;
import com.nurds.fastfillco.DoctorMedcineResponse;
import com.nurds.fastfillco.DoctorMedicineRequest;
import com.nurds.fastfillco.DoctorResponse;
import com.nurds.fastfillco.LocationRequest;
import com.nurds.fastfillco.MrMedcineResponse;
import com.nurds.fastfillco.Response;
import com.nurds.fastfillco.ResponseListStr;
import com.nurds.fastfillco.ResponseString;
import com.nurds.fastfillco.model.Doctor;
import com.nurds.fastfillco.model.DoctorMedicine;
import com.nurds.fastfillco.model.DoctorMedicineDao;
import com.nurds.fastfillco.model.Location;
import com.nurds.fastfillco.model.MedicalRep;
import com.nurds.fastfillco.model.MrMedicine;
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
			Location loc = new Location();
			loc.setLabel("default");
			List locs = new ArrayList<>();
			
			userDao.createLocation(loc);
			locs.add(loc);
			doctor.setLocations(locs);
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
	
	@RequestMapping(value="/getDoctorList")
	@ResponseBody
	public Response getDoctor(String username) {
		Response res = new Response();
		List<Doctor> doc = null;
		try {

			doc = userDao.getAll();
		}
		catch (Exception ex) {
			System.out.println(ex);
			res.setResponseCode("500");
			res.setError("Login Failed");
			return res;
		}
		res.setResponseCode("200");
		DoctorListResponse list = new DoctorListResponse();
		list.setDoctors(doc);
		res.setObject(list);
		return res;
	}
	
	@RequestMapping(value="/getClasses")
	@ResponseBody
	public Response getClasses(String username) {
		Response res = new Response();
		List<String> mClasses = null;
		try {

			mClasses = docMedicineDao.getAllClasses();
		}
		catch (Exception ex) {
			System.out.println(ex);
			res.setResponseCode("500");
			res.setError("Login Failed");
			return res;
		}
		res.setResponseCode("200");
		ResponseListStr list = new ResponseListStr();
		list.setResponse(mClasses);
		res.setObject(list);
		return res;
	}
	
	@RequestMapping(value="/getDocs")
	@ResponseBody
	public Response getDocs() {
		Response res = new Response();
		List<String> mClasses = null;
		try {

			mClasses = userDao.getAllDoc();
		}
		catch (Exception ex) {
			System.out.println(ex);
			res.setResponseCode("500");
			res.setError("Login Failed");
			return res;
		}
		res.setResponseCode("200");
		ResponseListStr list = new ResponseListStr();
		list.setResponse(mClasses);
		res.setObject(list);
		return res;
	}
	@RequestMapping(value="/getMrs")
	@ResponseBody
	public Response getMrs() {
		Response res = new Response();
		List<String> mClasses = null;
		try {

			mClasses = userDao.getAllMr();
		}
		catch (Exception ex) {
			System.out.println(ex);
			res.setResponseCode("500");
			res.setError("Login Failed");
			return res;
		}
		res.setResponseCode("200");
		ResponseListStr list = new ResponseListStr();
		list.setResponse(mClasses);
		res.setObject(list);
		return res;
	}
	
	@RequestMapping(value="/getNames")
	@ResponseBody
	public Response getNames(String username) {
		Response res = new Response();
		List<String> mClasses = null;
		try {

			mClasses = docMedicineDao.getAllNames();
		}
		catch (Exception ex) {
			System.out.println(ex);
			res.setResponseCode("500");
			res.setError("Login Failed");
			return res;
		}
		res.setResponseCode("200");
		ResponseListStr list = new ResponseListStr();
		list.setResponse(mClasses);
		res.setObject(list);
		return res;
	}
	
	@RequestMapping(value="/getSubClasses")
	@ResponseBody
	public Response getSubClasses(String username) {
		Response res = new Response();
		List<String> mClasses = null;
		try {

			mClasses = docMedicineDao.getAllSubClasses();
		}
		catch (Exception ex) {
			System.out.println(ex);
			res.setResponseCode("500");
			res.setError("Login Failed");
			return res;
		}
		res.setResponseCode("200");
		ResponseListStr list = new ResponseListStr();
		list.setResponse(mClasses);
		res.setObject(list);
		return res;
	}
	
	@RequestMapping(value="/registermr" , method = RequestMethod.POST)
	@ResponseBody Response registerMR(@RequestBody MedicalRep mrRep) {
		Response res = new Response();
		try {
			
			userDao.createMr(mrRep);
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
	@RequestMapping(value="/loginmr")
	@ResponseBody
	public Response loginMr(String username, String password) {
		System.out.println(username+password);
		Response res = new Response();
		MedicalRep mr = null;
		try {

			mr = userDao.loginMr(username, password);
		}
		catch (Exception ex) {
			System.out.println(ex);
			res.setResponseCode("500");
			res.setError("Login Failed");
			return res;
		}
		res.setResponseCode("200");
		res.setObject(mr);
		return res;
	}
	
	@RequestMapping(value="/addLocation")
	@ResponseBody
	public Response addLocation(@RequestBody LocationRequest location) {
		System.out.println(location);
		Doctor doc = userDao.getDoctor(location.getUserName());
		Location loc = new Location();
		loc.setLabel(location.getLabel());
		loc.setAddressline1(location.getAddressline1());
		loc.setAddressline2(location.getAddressline2());
		loc.setCity(location.getCity());
		loc.setState(location.getState());
		loc.setPinCode(location.getPinCode());
		Response res = new Response();		
		userDao.createLocation(loc);
		Location loc1 = userDao.getLocation(loc.getId());
		doc.getLocations().add(loc1);
		userDao.create(doc);
		res.setResponseCode("200");
		return res;
	}
	@RequestMapping(value="/viewDocDetails")
	@ResponseBody
	public Response getDoctorDetails(String docName,String location) {
		Doctor doc = userDao.getLocation(location,docName);
		DoctorResponse resp = new DoctorResponse();
		Response response = new Response();
		resp.setFirstName(doc.getFirstName());
		resp.setLastName(doc.getLastName());
		resp.setMobileNumber(doc.getMobileNumber());
		
		Location loc = doc.getLocations().get(0);
		resp.setAddressline1(loc.getAddressline1());
		resp.setAddressline2(loc.getAddressline2());
		resp.setCity(loc.getCity());
		resp.setPinCode(loc.getPinCode());
		resp.setSpeciality(doc.getSpeciality());
		resp.setClinicName(doc.getClinicName());
		resp.setState(loc.getState());
		response.setObject(resp);
		response.setResponseCode("200");
		return response;
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
	
	@RequestMapping(value="/getMrMedicineDetails")
	@ResponseBody
	public Response getMrMedicineDetails(String userName) {
		Response res = new Response();
		List<MrMedicine> docList = null;
		try {

			docList = docMedicineDao.getMrMedicineDetails(userName);
		}
		catch (Exception ex) {
			System.out.println(ex);
			res.setResponseCode("500");
			res.setError("Login Failed");
			return res;
		}
		MrMedcineResponse resp = new MrMedcineResponse();
		resp.setMedicines(docList);
		res.setResponseCode("200");
		res.setObject(resp);
		return res;
	}
	
	@RequestMapping(value="/getAllMrMedicineDetails")
	@ResponseBody
	public Response getAllMrMedicineDetails() {
		Response res = new Response();
		List<MrMedicine> docList = null;
		try {

			docList = docMedicineDao.getallMrMedicineDetails();
		}
		catch (Exception ex) {
			System.out.println(ex);
			res.setResponseCode("500");
			res.setError("Login Failed");
			return res;
		}
		MrMedcineResponse resp = new MrMedcineResponse();
		resp.setMedicines(docList);
		res.setResponseCode("200");
		res.setObject(resp);
		return res;
	}
	
	@RequestMapping(value="/addMrMedicineDetails")
	@ResponseBody
	public Response addDoctorMedicineDetails(int id,String boxNum,String voucherNum,String couponNum,String doctor) {
		Response res = new Response();
		MrMedicine mrMedicine = null;
		DoctorMedicine doc = null;
		Doctor docObj = userDao.getDoctor(doctor);
		try {
			
			mrMedicine = docMedicineDao.getMrMedicineDetail(id);
			doc = new DoctorMedicine();
			doc.setMedicineName(mrMedicine.getMedicineName());
			doc.setDosage(mrMedicine.getDosage());
			doc.setCouponInsurance(mrMedicine.getCouponInsurance());
			doc.setNumOfBoxes(boxNum);
			doc.setNumVoucher(voucherNum);
			doc.setNumCoupons(couponNum);
			doc.setExpiryDate(mrMedicine.getExpiryDate());
			doc.setVoucherInsurance(mrMedicine.getVoucherInsurance());
			doc.setSubClass(mrMedicine.getSubClass());
			doc.setmClass(mrMedicine.getmClass());
			doc.setNumPillPerBox(mrMedicine.getNumPillPerBox());
			doc.setMr(mrMedicine.getMr());
			doc.setDoctor(docObj);
			docMedicineDao.create(doc);
		}
		catch (Exception ex) {
			System.out.println(ex);
			res.setResponseCode("500");
			res.setError("Login Failed");
			return res;
		}
		ResponseString str = new ResponseString();
		str.setResponse("User succesfully created!");
		res.setObject(str);
		res.setResponseCode("200");
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
		Location loc = userDao.getLocation(medicineReq.getLocation());
		Doctor doc = userDao.getDoctor(medicineReq.getUserName());
		DoctorMedicine medicine = new DoctorMedicine();
		medicine.setCouponsExpiryDate(medicineReq.getCouponsExpiryDate());
		medicine.setDoctor(doc);
		medicine.setNumCoupons(medicineReq.getNumCoupons());
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
		medicine.setLocation(loc);
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
	@RequestMapping(value="/mrMedicine/create")
	@ResponseBody
	public Response createMrMedicine(@RequestBody DoctorMedicineRequest medicineReq) {
		System.out.println(medicineReq);
		MedicalRep doc = userDao.getMr(medicineReq.getUserName());
		MrMedicine medicine = new MrMedicine();
		medicine.setCouponsExpiryDate(medicineReq.getCouponsExpiryDate());
		medicine.setMr(doc);
		medicine.setExpiryDate(medicineReq.getExpiryDate());
		medicine.setmClass(medicineReq.getmClass());
		medicine.setMedicineName(medicineReq.getMedicineName());
		medicine.setNumPillPerBox(medicineReq.getNumPillPerBox());
		medicine.setSubClass(medicineReq.getSubClass());
		medicine.setVoucherExpiryDate(medicineReq.getVoucherExpiryDate());
		medicine.setVoucherInsurance(medicineReq.getVoucherInsurance());
		Response res = new Response();
		try {
			
			docMedicineDao.createMrMedicine(medicine);
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
