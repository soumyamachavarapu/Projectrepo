package com.slot.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.slot.model.slot;

@Repository
public interface slotrepo extends MongoRepository<slot, Integer> {
	 List<slot> findBySlotavailability(boolean slotavailability);
}
