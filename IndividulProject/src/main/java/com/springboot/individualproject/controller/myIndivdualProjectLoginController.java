package com.springboot.individualproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.individualproject.exception.ResourceNotFoundException;
import com.springboot.individualproject.model.myIndivdualProjectLoginModel;
import com.springboot.individualproject.repository.myIndivdualProjectLoginRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class myIndivdualProjectLoginController {
	
	@Autowired
	myIndivdualProjectLoginRepository myRepository;
	
	// Method to create a new Login
		@PostMapping("/login")
		public myIndivdualProjectLoginModel createLogin(@Valid @RequestBody myIndivdualProjectLoginModel mSDM) {
			return myRepository.save(mSDM);
		}

		// Method to get a Book
		@GetMapping("login/{id}")
		public void getloginbyID(@PathVariable(value = "id") Long loginID) {
			myIndivdualProjectLoginModel mSDM = myRepository.findById(loginID)
					.orElseThrow(() -> new ResourceNotFoundException("Login", "id", loginID));
		}

		// Method to get all Book
		@GetMapping("/login")
		public List<myIndivdualProjectLoginModel> getAllLogins() {
			return myRepository.findAll();
		}

		// Method to update a Book
		@PutMapping("/login/{login_id}")
		public myIndivdualProjectLoginModel updateBook(@PathVariable(value = "id") long loginID,
				@Valid @RequestBody myIndivdualProjectLoginModel loginDetails) {

			myIndivdualProjectLoginModel mSDM = myRepository.findById(loginID)
					.orElseThrow(() -> new ResourceNotFoundException("Login", "id", loginID));

			mSDM.setPassword(loginDetails.getPassword());
			mSDM.setLogin(loginDetails.getLogin());
		
			myIndivdualProjectLoginModel updateData = myRepository.save(mSDM);
			return updateData;
		}

		// Method to remove a Book
		@DeleteMapping("/login/{id}")
		public ResponseEntity<?> deletelogin(@PathVariable(value = "id") Long loginID) {
			myIndivdualProjectLoginModel mSDM = myRepository.findById(loginID)
					.orElseThrow(() -> new ResourceNotFoundException("Login", "id", loginID));

			myRepository.delete(mSDM);
			return ResponseEntity.ok().build();

		}
	}



