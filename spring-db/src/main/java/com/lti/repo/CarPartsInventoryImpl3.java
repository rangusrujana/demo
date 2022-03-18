package com.lti.repo;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.lti.model.CarPart;
/**
 * In this example ,we will be using a feature called as
 * Connection Pooling.
 * There is something called as DataSource in Java
 * which we will be using in this example.This DataSource
 * is going to be replacement of DriverManager class
 * which we use for establishing connection with the DB.
 * 
 * @author Rangu Srujana
 *
 */
@Component("carPartsInv3")
public class CarPartsInventoryImpl3 implements CarPartsInventory {
	
	@Autowired
	private DataSource dataSource;
	
	public void addNewPart(CarPart carPart)  {
		//TODO:write jdbc code for inserting car part details in the underlying table
		
		JdbcTemplate jt =new JdbcTemplate(dataSource);
		jt.update("insert into tbl_carpart values(?,?,?,?,?)",
			carPart.getPartno(),
			carPart.getPartName(),
			carPart.getCarModel(),
			 carPart.getPrice(),
			 carPart.getQuantity());
			
			
		} 

	public List<CarPart> getAvailableParts() {
		JdbcTemplate jt =new JdbcTemplate(dataSource);
		List<CarPart> list = jt.query("select * from tbl_carpart", (rs, index) ->{
		
		
		
		CarPart cp = new CarPart();
		cp.setPartno(rs.getInt("partno"));
		cp.setPartName(rs.getString("part_name"));
		cp.setCarModel(rs.getString("car_model"));
		cp.setPrice(rs.getDouble("price"));
		cp.setQuantity(rs.getInt("quantity"));
		return cp;
		});
       return list;
     }
}
