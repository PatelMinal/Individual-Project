package com.springboot.individualproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.individualproject.model.myIndivdualProjectBookModel;



@Repository
public interface myIndivdualProjectBookRepository extends JpaRepository<myIndivdualProjectBookModel,Long>  {

}