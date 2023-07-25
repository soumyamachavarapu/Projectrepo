package com.slot.model;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class slot {
	@Id
	private int slotid;
	private boolean slotavailability;
	private LocalDate slotdate;
	private LocalTime slottime;
	
	
	public int getSlotid() {
		return slotid;
	}
	public void setSlotid(int slotid) {
		this.slotid = slotid;
	}
	public boolean isSlotavailability() {
		return slotavailability;
	}
	public void setSlotavailability(boolean slotavailability) {
		this.slotavailability = slotavailability;
	}
	@Override
	public String toString() {
		return "slot [slotid=" + slotid + ", slotavailability=" + slotavailability + ", slotdate=" + slotdate
				+ ", slottime=" + slottime + "]";
	}
	public LocalDate getSlotdate() {
		return slotdate;
	}
	public void setSlotdate(LocalDate slotdate) {
		this.slotdate = slotdate;
	}
	public LocalTime getSlottime() {
		return slottime;
	}
	public void setSlottime(LocalTime slottime) {
		this.slottime = slottime;
	}
}
