package com.springboot.individualproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert(true)
@DynamicUpdate(true)
@Table(name = "book")


public class myIndivdualProjectBookModel implements Serializable {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long book_id;
	
	@NotBlank
	@Column(name = "title")
	private String title;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "description")
	private String description;
	
	@NotBlank
	@Column(name = "rating")
	private String rating;
	
	
	@Column(name = "price")
	private String price;
	
	
	
	public  myIndivdualProjectBookModel(String title, String author, String description, String rating, String price ) {
		this.book_id = book_id;
		this.title = title;
		this.author = author;
		this.description = description;
		this.rating = rating;
		this.price = price;
		
		
	
		
	}
	
	public  myIndivdualProjectBookModel() {
	}
	
	public Long getBook_id() {
		return book_id;
	}

	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	

}




