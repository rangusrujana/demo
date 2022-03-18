package com.lti.repo;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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
@Component("carPartsInv2")
public class CarPartsInventoryImpl2 implements CarPartsInventory {
	
	@Autowired
	private DataSource dataSource;
	
	public void addNewPart(CarPart carPart)  {
		//TODO:write jdbc code for inserting car part details in the underlying table
		
		Connection conn=null;
		try {
			
			
			conn = dataSource.getConnection();
			System.out.println("Successfull Connection");
			PreparedStatement stmt=conn.prepareStatement("insert into tbl_carpart values(?,?,?,?,?)");
			stmt.setInt(1, carPart.getPartno());
			stmt.setString(2, carPart.getPartName());;
			stmt.setString(3,carPart.getCarModel());
			stmt.setDouble(4, carPart.getPrice());
			stmt.setInt(5, carPart.getQuantity());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();//rather we should throw user defined exception
		} 
			
			finally {
				try {conn.close();
				}catch(Exception e) {
				
				}
			}
	}

	public List<CarPart> getAvailableParts() {
		Connection conn = null;
		try {
		
		conn = dataSource.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from tbl_carpart");
		ResultSet rs = stmt.executeQuery();

		List<CarPart> list = new ArrayList<CarPart>();
		while(rs.next()) {
		CarPart cp = new CarPart();
		cp.setPartno(rs.getInt("partno"));
		cp.setPartName(rs.getString("part_name"));
		cp.setCarModel(rs.getString("car_model"));
		cp.setPrice(rs.getDouble("price"));
		cp.setQuantity(rs.getInt("quantity"));
		list.add(cp);
		}
		return list;
		}
		catch(Exception e) {
		e.printStackTrace(); //rather we should throw user defined exception
		return null; //very bad, we should throw some exception
		}
		finally {
		try { conn.close(); } catch(Exception e) { }
		}



		}
}
