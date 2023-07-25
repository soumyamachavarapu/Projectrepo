package com.slot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slot.exception.slotAlreadyExistsException;
import com.slot.model.slot;
import com.slot.service.Islotservice;

@RestController
@RequestMapping("slot/v1")
public class slotcontroller {

//	http://localhost:8087/slot/v1/getAllSlots
//	http://localhost:8087/slot/v1/getSlotById
//	http://localhost:8087/slot/v1/updateSlotAvailability
//	http://localhost:8087/slot/v1/addSlot
//	http://localhost:8087/slot/v1/getSlotByavailability
	@Autowired
	private Islotservice sservice;
	
	private ResponseEntity<?> responseEntity;
	
	@GetMapping("/getAllSlots")
	public ResponseEntity<?> getAllNotesHandler()
	{
		List<slot> allSlots = this.sservice.getAllSlots();
		responseEntity = new ResponseEntity<>(allSlots,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/getSlotById/{slotid}")
	public ResponseEntity<?> getSlotByIdHandler(@PathVariable int slotid) 
	{
		slot sObj = this.sservice.getSlotById(slotid);
		responseEntity = new ResponseEntity<>(sObj,HttpStatus.OK);
		return responseEntity;
	}

	
	@PutMapping("/updateslotAvailability/{slotid}")
	public ResponseEntity<?> updateNoteHandler(@RequestBody slot sobj,@PathVariable int slotid) 
	{
		slot newSlot = this.sservice.updateSlotAvailability(sobj,slotid);
		responseEntity = new ResponseEntity<>(newSlot,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PostMapping("/addSlot")
	public ResponseEntity<?> sendSlotHandler(@RequestBody slot sobj)
	{
		slot newSlot=null;
//		try {
			newSlot = this.sservice.sendSlot(sobj);
//		}
//		catch(slotAlreadyExistsException e) {
//			e.printStackTrace();
//		}
		responseEntity = new ResponseEntity<>(newSlot,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/getSlotByavailability/{slotavailabilty}")
	public ResponseEntity<?> getSlotByIdHandler(@PathVariable boolean slotavailabilty) 
	{	
		System.out.println("mapping: "+slotavailabilty);
		List<slot> sObj = this.sservice.getSlotByslotavailabilty(slotavailabilty);
		responseEntity = new ResponseEntity<>(sObj,HttpStatus.OK);
		return responseEntity;
	}
}
