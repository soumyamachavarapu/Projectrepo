package com.slot.service;

import java.util.List;

import com.slot.exception.slotAlreadyExistsException;
import com.slot.exception.slotNotFoundException;
import com.slot.model.slot;

public interface Islotservice {
	
	public slot getSlotById(int slotid) throws slotNotFoundException;
	public List <slot> getAllSlots();
	public slot sendSlot(slot sobj) throws slotAlreadyExistsException;
	public slot updateSlotAvailability(slot sobj,int slotid) throws slotNotFoundException;
	public  List<slot> getSlotByslotavailabilty(boolean slotavailability);
}
