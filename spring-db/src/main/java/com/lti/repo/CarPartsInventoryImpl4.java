package com.lti.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.lti.model.CarPart;
/**
 * In this example ,we will be using Hibernate/JPA for persistence
 * 
 * @author Rangu Srujana
 *
 */
@Component("carPartsInv4")
public class CarPartsInventoryImpl4 implements CarPartsInventory {
	//@Autowired doesn't works for injecting EntityManager object
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void addNewPart(CarPart carPart)  {
		em.persist(carPart);
		} 

	public List<CarPart> getAvailableParts() {
		return em
				.createQuery("select cp from CarPart cp")
				.getResultList();
     }
}
