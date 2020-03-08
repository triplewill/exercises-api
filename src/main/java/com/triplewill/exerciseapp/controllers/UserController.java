package com.triplewill.exerciseapp.controllers;

import org.openapitools.api.UserApi;
import com.triplewill.exerciseapp.services.UserService;
import com.triplewill.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class UserController implements UserApi {

	@Autowired
	UserService service;

	@Override
	public ResponseEntity<List<User>> getUsers() {
		List<User> myList = this.service.getAllUsers();
		Collections.sort(myList);
		return new ResponseEntity<List<User>>(myList, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> updateUserDates(Long id, String[] dates) {
		this.service.updateUserDates(id, dates);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
