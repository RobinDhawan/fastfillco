package com.nurds.fastfillco.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

/**
 * This class is used to access data for the User entity.
 * Repository annotation allows the component scanning support to find and 
 * configure the DAO wihtout any XML configuration and also provide the Spring 
 * exceptiom translation.
 * Since we've setup setPackagesToScan and transaction manager on
 * DatabaseConfig, any bean method annotated with Transactional will cause
 * Spring to magically call begin() and commit() at the start/end of the
 * method. If exception occurs it will also call rollback().
 */
@Repository
@Transactional
public class DoctorMedicineDao {
  
  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  /**
   * Save the user in the database.
   */
  public void create(DoctorMedicine medicine) {
   entityManager.persist(medicine);
    return;
  }
  
  public void createMrMedicine(MrMedicine medicine) {
	   entityManager.persist(medicine);
	    return;
	  }
	  
  /**
   * Delete the user from the database.
   */
  public void delete(Doctor user) {
    if (entityManager.contains(user))
      entityManager.remove(user);
    else
      entityManager.remove(entityManager.merge(user));
    return;
  }
  
  /**
   * Return all the users stored in the database.
   */
  @SuppressWarnings("unchecked")
  public List<Doctor> getAll() {
    return entityManager.createQuery("from Doctor").getResultList();
  }
  
  public List<String> getAllClasses() {
	   return entityManager.createQuery("select DISTINCT mClass from DoctorMedicine").getResultList();
	  }
  
  public List<String> getAllNames() {
	   return entityManager.createQuery("select DISTINCT medicineName from mrMedicine").getResultList();
	  }
  
  public List<String> getAllSubClasses() {
	   return entityManager.createQuery("select DISTINCT subClass from DoctorMedicine").getResultList();
	  }
  
  /**
   * Return the user having the passed email.
   */
  public List<DoctorMedicine> getMedicineDetails(String userName,long location) {
    return entityManager.createQuery(
        "from DoctorMedicine where doctor.username = :username and location.id=:id")
        .setParameter("username", userName)
        .setParameter("id", location)
        .getResultList();
  }
  
  public List<MrMedicine> getMrMedicineDetails(String userName) {
	    return entityManager.createQuery(
	        "from MrMedicine where mr.username = :username")
	        .setParameter("username", userName)
	        .getResultList();
	  }
  
  public MrMedicine getMrMedicineDetail(long id) {
	    return (MrMedicine) entityManager.createQuery(
	        "from MrMedicine where id = :id")
	        .setParameter("id", id)
	        .getSingleResult();
	  }
  
  
  
  public List<MrMedicine> getallMrMedicineDetails() {
	    return entityManager.createQuery(
	        "from MrMedicine")
	        .getResultList();
	  }
  
  public void updateMedicineDetails(DoctorMedicine medicine) {
	  	DoctorMedicine med = getMedicineDetail(medicine.getId());
	  	if(medicine.getNumOfBoxes()!=null)
	  	med.setNumOfBoxes(medicine.getNumOfBoxes());
	  	if(medicine.getNumVoucher()!=null)
		  	med.setNumVoucher(medicine.getNumVoucher());
	  	if(medicine.getNumOfBoxes()!=null)
		  	med.setNumCoupons(medicine.getNumCoupons());
	    entityManager.merge(med);
	    return;
	  }

  public DoctorMedicine getMedicineDetail(long id) {
	    return (DoctorMedicine) entityManager.createQuery(
	        "from DoctorMedicine where id = :id")
	        .setParameter("id", id)
	        .getSingleResult();
	  }


  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  // An EntityManager will be automatically injected from entityManagerFactory
  // setup on DatabaseConfig class.
  @PersistenceContext
  private EntityManager entityManager;
  
} // class UserDao
