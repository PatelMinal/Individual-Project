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
import com.springboot.individualproject.model.myIndivdualProjectBookModel;

import com.springboot.individualproject.repository.myIndivdualProjectBookRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class myIndivdualProjectBookController {

	@Autowired
	myIndivdualProjectBookRepository myRepository;
	
	
	
	// Method to create a new Book
	@PostMapping("/book")
	public myIndivdualProjectBookModel createBook(@Valid @RequestBody myIndivdualProjectBookModel mSDM) {
		return myRepository.save(mSDM);
	}

	// Method to get a Book
	@GetMapping("book/{id}")
	public void getbookbyID(@PathVariable(value = "id") Long bookID) {
		myIndivdualProjectBookModel mSDM = myRepository.findById(bookID)
				.orElseThrow(() -> new ResourceNotFoundException("Book", "id", bookID));
	}

	// Method to get all Book
	@GetMapping("/book")
	public List<myIndivdualProjectBookModel> getAllBooks() {
		return myRepository.findAll();
	}

	// Method to update a Book
	@PutMapping("/book/{book_id}")
	public myIndivdualProjectBookModel updateBook(@PathVariable(value = "id") long bookID,
			@Valid @RequestBody myIndivdualProjectBookModel bookDetails) {

		myIndivdualProjectBookModel mSDM = myRepository.findById(bookID)
				.orElseThrow(() -> new ResourceNotFoundException("Book", "id", bookID));

		mSDM.setTitle(bookDetails.getTitle());
		mSDM.setAuthor(bookDetails.getAuthor());
		mSDM.setDescription(bookDetails.getDescription());
		mSDM.setRating(bookDetails.getRating());
		mSDM.setPrice(bookDetails.getPrice());
		
		myIndivdualProjectBookModel updateData = myRepository.save(mSDM);
		return updateData;
	}

	// Method to remove a Book
	@DeleteMapping("/Book/{id}")
	public ResponseEntity<?> deletebook(@PathVariable(value = "id") Long bookID) {
		myIndivdualProjectBookModel mSDM = myRepository.findById(bookID)
				.orElseThrow(() -> new ResourceNotFoundException("Book", "id", bookID));

		myRepository.delete(mSDM);
		return ResponseEntity.ok().build();

	}
}
