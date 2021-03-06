package com.ty.stores.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.stores.message.Messages;
import com.ty.stores.model.Store;
import com.ty.stores.service.ServiceImplementation;

@RestController

@RequestMapping("/api")
public class StoreController {
	@Autowired(required=true)
	private ServiceImplementation implementation;

	@GetMapping("/fetch/{storeId}")
	public ResponseEntity<Messages> fetchStoreDetailsByID(@PathVariable String storeId) {
		Store responseStoreDto = implementation.fetchByStoreId(storeId);
		if (responseStoreDto != null) {
			
			return new ResponseEntity<>(new Messages(false, "Displaying the Store Details", responseStoreDto),
					HttpStatus.OK);
		} else {
			
			return new ResponseEntity<>(new Messages(true, "No Store Details found  ", null),
					HttpStatus.NOT_FOUND);  
		}
	}

	@GetMapping("/fetchall/{condition}")
	public ResponseEntity<Messages> fetchAllStoreDetails(@PathVariable String condition) {
		List<Store> fetchAllStores = implementation.fetchAllStores(condition);
		if (fetchAllStores != null) {
			
			return new ResponseEntity<>(new Messages(false, "Displaying All the Stores Details", fetchAllStores),
					HttpStatus.OK);

		} else {
	
			return new ResponseEntity<>(new Messages(true, "No Store Details found  ", null),
					HttpStatus.NOT_FOUND); 
		}
	}
}
