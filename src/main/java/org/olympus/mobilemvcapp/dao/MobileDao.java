package org.olympus.mobilemvcapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.olympus.mobilemvcapp.dto.Mobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MobileDao {
	
	@Autowired
	private EntityManager manager;
	
	@Autowired
	private EntityTransaction transaction;
	
	public Mobile save(Mobile mobile) {
		transaction.begin();
		manager.persist(mobile);
		transaction.commit();
		return mobile;
	}
	
	public Mobile update(Mobile mobile) {
		transaction.begin();
		manager.merge(mobile);
		transaction.commit();
		return mobile;
	}
	
	public Mobile findMobile(int id) {
		Mobile m = manager.find(Mobile.class, id);
		if(m!=null) {
			return m;
		}
		return null;
	}
	
	public List<Mobile> fetchAllData() {
		Query q = manager.createQuery("select m from Mobile m");
		List<Mobile> mobiles = q.getResultList();
		if(mobiles.size()>0) {
			return mobiles;
		}
		return null;
	}
	
	public boolean delete(int id) {
		Mobile mobile = manager.find(Mobile.class, id);
		if(mobile!=null) {
			transaction.begin();
			manager.remove(mobile);
			transaction.commit();
			return true;
		}
		return false;
	}

}
