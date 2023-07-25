package com.slot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slot.model.slot;
import com.slot.repo.slotrepo;
import com.slot.exception.slotNotFoundException;
@Service
public class slotserviceImpl implements Islotservice{

	@Autowired
	public slotrepo srepo;
	
	slot sobj=null;
	
	@Override
	public slot getSlotById(int slotid)
	{
		Optional<slot> slotoptional=this.srepo.findById(slotid);
		if(slotoptional.isPresent()) {
			sobj=slotoptional.get();
			
		}
		else {
			System.out.println("slot does not exists");
			throw new slotNotFoundException();
		}
		return sobj;
	}

	@Override
	public List<slot> getAllSlots(){
		return this.srepo.findAll();
	}
	
	@Override
	public slot sendSlot(slot sobj) {
		Optional<slot> slotoptional=this.srepo.findById(sobj.getSlotid());
		slot  sendsobj=null;
		
		sendsobj=this.srepo.save(sobj);
		
		return sendsobj;
	}
	

	
	@Override
	public slot updateSlotAvailability(slot sObj,int slotid)
	{
		Optional<slot> slotoptional=this.srepo.findById(slotid);
		sobj=slotoptional.get();
		slot updateavailability=null;

		
		sobj.setSlotdate(sObj.getSlotdate());
		sobj.setSlotid(sObj.getSlotid());
		sobj.setSlottime(sObj.getSlottime());
		sobj.setSlotavailability(sObj.isSlotavailability());
		
		updateavailability=this.srepo.save(sobj);
		return updateavailability;
	}
	
	@Override
	public List<slot> getSlotByslotavailabilty(boolean slotavailabilty) {
		System.out.println("IMPL: "+slotavailabilty);
		 return srepo.findBySlotavailability(slotavailabilty);
	}
	
}
