package com.lti.repo;

import java.util.List;

import com.lti.model.CarPart;

public interface CarPartsInventory {

	public void addNewPart(CarPart carPart);
	public List<CarPart> getAvailableParts();
}
