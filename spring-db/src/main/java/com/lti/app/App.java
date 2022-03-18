package com.lti.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.model.CarPart;
import com.lti.repo.CarPartsInventory;

public class App {

	public static void main(String[] args) {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("spring-config.xml");
		CarPartsInventory cpInv = (CarPartsInventory) ctx.getBean("carPartsInv4");
		/*CarPart cp=new CarPart();
		cp.setPartno(111);
		cp.setPartName("Nut & Bolt");
		cp.setCarModel("Maruti 800");
		cp.setPrice(500);
		cp.setQuantity(99);
		
		cpInv.addNewPart(cp);*/
		List<CarPart> list= cpInv.getAvailableParts();
		for(CarPart cp : list)
			System.out.println(cp.getPartno()+","+cp.getPartName()+","+cp.getCarModel()+","+cp.getPrice()+","+cp.getQuantity());
	}
	

	}


